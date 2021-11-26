package com.basics;

class Basics {
    public static void main(String[] args) {
        System.out.println("Java basics!");

        // initiate a new instance of class PrimitiveDataTypes present in same package
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

        // initiate a new instance of class AdvancedDataTypes present in same package
        com.basics.AdvancedDataTypes advDataTypes = new com.basics.AdvancedDataTypes();
        System.out.println("\nAdvanced Data Types -");
        System.out.println("\tString: " + advDataTypes.StringVar);
        // Add items to primitive type array
        advDataTypes.IntArray[0] = 1;
        advDataTypes.IntArray[1] = 2;
        System.out.println("\tint[0]: " + advDataTypes.IntArray[0]);
        // Add items to array list
        advDataTypes.ArrayListVar.add(0, "item1");
        advDataTypes.ArrayListVar.add(1, 2);
        System.out.println("\tArrayList: " + advDataTypes.ArrayListVar);
        // Add keys to map
        advDataTypes.MapVar.put("Key", "Value");
        System.out.println("\tMap: " + advDataTypes.MapVar);

        // initiate a new instance of class Constructor present in same package
        System.out.println("\nConstructor ran at -");
        new com.basics.Constructor();

        // initiate a new instance of class Conditionals present in same package
        com.basics.Conditionals conditionals = new com.basics.Conditionals();
        System.out.println("\nConditional values -");
        conditionals.ifElse(-1);
        conditionals.switchStatement("tom");

        // initiate a new instance of class Loops present in same package
        com.basics.Loops loops = new com.basics.Loops();
        System.out.println("\nLoops -");
        loops.forLoop(2);
        loops.whileLoop(2);
        loops.doWhileLoop(0);
        // change values in above declared array
        advDataTypes.IntArray[0] = 5;
        advDataTypes.IntArray[1] = -2;
        loops.forEachLoop(advDataTypes.IntArray);

        // initiate a new instance of class ErrorHandling present in same package
        com.basics.ErrorHandling errorHandling = new com.basics.ErrorHandling();
        System.out.println("\nException handling -");
        errorHandling.tryCatch();

        // OOP
        // 1. Encapsulation
        // 2. Abstraction
        // 3. Inheritance
        // initiate a new instance of class Inheritance present in same package
        System.out.println("\nInheritance -");
        com.basics.Inheritance inheritance = new com.basics.Inheritance();
        inheritance.properties();
        // 4. Polymorphism

        // initiate a new instance of class CustomException present in same package
        System.out.println("\nCustom Exceptions -");
        try{
            throw new com.basics.CustomException("custom exception");
        }catch (com.basics.CustomException e) {
            System.out.println("\tException caught! " + e.getClass());
        }
    }
}
