package com.basics;

class Basics {
    public static void main(String[] args) {
        System.out.println("Java basics!");

        // initiate a new instance of class DataTypes present in same package
        com.basics.PrimitiveDataTypes dataTypes = new com.basics.PrimitiveDataTypes();

        System.out.println("\nPrimitive Data Types (in increasing order of size) -");
        System.out.println("\tboolean: " + dataTypes.Boolean);
        System.out.println("\tbyte: " + dataTypes.Byte);
        System.out.println("\tshort: " + dataTypes.Short);
        System.out.println("\tchar: " + dataTypes.Char);
        System.out.println("\tint: " + dataTypes.Integer);
        System.out.println("\tfloat: " + dataTypes.FloatingPoint);
        System.out.println("\tlong: " + dataTypes.Long);
        System.out.println("\tdouble: " + dataTypes.Double);
    }
}
