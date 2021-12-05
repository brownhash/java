package com.advanced.vertx.basics;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

/*
This code is to show the Asynchronous pattern via native Java
From this we can understand the upsides of Asynchronous over Synchronous pattern
*/
public class Asynchronous {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(3000));
        // We need to put the channel into non-blocking mode.
        serverSocketChannel.configureBlocking(false);
        // The selector will notify of incoming connections.
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // This collects all non-blocking I/O notifications.
            selector.select();
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isAcceptable()) { // We have a new connection.
                    newConnection(selector, key);
                } else if (key.isReadable()) { // A socket has received data.
                    echo(key);
                } else if (key.isWritable()) { // A socket is ready for writing again.
                    continueEcho(selector, key);
                }
                // Selection keys need to be manually removed,
                // or they will be available again in the next loop iteration.
                it.remove();
            }
        }
    }

    // The Context class keeps state related to the handling of a TCP connection.
    private static class Context {
        private final ByteBuffer nioBuffer = ByteBuffer.allocate(512);
        private String currentLine = "";
        private boolean terminating = false;
    }

    private static final HashMap<SocketChannel, Context> contexts = new HashMap<>();

    private static void newConnection(Selector selector, SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel
                // We set the channel to non-blocking and declare interest in read operations.
                .configureBlocking(false)
                .register(selector, SelectionKey.OP_READ);
        // We keep all connection states in a hash map.
        contexts.put(socketChannel, new Context());
    }

    private static final Pattern QUIT = Pattern.compile("(\\r)?(\\n)?/quit$");

    private static void echo(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        Context context = contexts.get(socketChannel);
        try {
            socketChannel.read(context.nioBuffer);
            context.nioBuffer.flip();
            context.currentLine = context.currentLine + Charset.defaultCharset().decode(context.nioBuffer);
            if (QUIT.matcher(context.currentLine).find()) { // If we find a line ending with /quit, we terminate the connection.
                context.terminating = true;
            } else if (context.currentLine.length() > 16) {
                context.currentLine = context.currentLine.substring(8);
            }
            // Java NIO buffers need positional manipulations: the buffer has read data,
            // so to write it back to the client, we need to flip and return to the start position.
            context.nioBuffer.flip();
            int count = socketChannel.write(context.nioBuffer);
            // It may happen that not all data can be written, so we stop looking for read operations and
            // declare interest in a notification indicating when the channel can be written to again.
            if (count < context.nioBuffer.limit()) {
                key.cancel();
                socketChannel.register(key.selector(), SelectionKey.OP_WRITE);
            } else {
                context.nioBuffer.clear();
                if (context.terminating) {
                    cleanup(socketChannel);
                }
            }
        } catch (IOException err) {
            err.printStackTrace();
            cleanup(socketChannel);
        }
    }

    private static void cleanup(SocketChannel socketChannel) throws IOException {
        socketChannel.close();
        contexts.remove(socketChannel);
    }

    private static void continueEcho(Selector selector, SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        Context context = contexts.get(socketChannel);
        try {
            int remainingBytes = context.nioBuffer.limit() - context.nioBuffer.position();
            int count = socketChannel.write(context.nioBuffer);
            // We remain in this state until all data has been written back.
            // Then we drop our write interest and declare read interest.
            if (count == remainingBytes) {
                context.nioBuffer.clear();
                key.cancel();
                if (context.terminating) {
                    cleanup(socketChannel);
                } else {
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
            }
        } catch (IOException err) {
            err.printStackTrace();
            cleanup(socketChannel);
        }
    }
}

/*
Till now, you would have already realized that,
this code is really long and complex as compared to the Synchronous one.
So, this is where Vert.X will come into picture

Compile the code,
    $ javac ...Asynchronous.java

Run the server,
    $ java ...Asynchronous

To interact,
    $ netcat localhost 3000     # start a connection with server
    $ hello world!              # input some string
    > hello world!              # receive the same string as output
    $ /quit                     # enter `/quit` keyword
    > /quit                     # receive the same as output and exits
*/
