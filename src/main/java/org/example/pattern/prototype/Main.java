package org.example.pattern.prototype;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        // 浅拷贝
        Prototype a = new Prototype();
        a.setObj(new SerializeableObject("testObjA"));
        a.setString("testA");

        System.out.println(a);
        Prototype cloneA = (Prototype) a.clone();
        System.out.println(cloneA);

        if (cloneA.getObj() == a.getObj()) {
            System.out.println("浅拷贝");
        }

        // 深度拷贝
        Prototype deepCloneA = (Prototype) a.deepClone();
        System.out.println(deepCloneA);
        if (deepCloneA.getObj() != a.getObj()) {
            System.out.println("深拷贝");
        }
    }
}
