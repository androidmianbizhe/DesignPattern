package org.example.pattern.adapter;

public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is targetable method");
    }
}
