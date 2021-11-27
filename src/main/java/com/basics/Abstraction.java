package com.basics;

// cannot be instantiated, can only be inherited
abstract class MainAbstraction {
    public boolean isAbstract = true;
}

public class Abstraction extends MainAbstraction {
    public boolean extendsAbstract = true;
}
