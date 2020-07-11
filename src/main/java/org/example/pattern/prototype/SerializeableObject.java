package org.example.pattern.prototype;

import java.io.Serializable;

public class SerializeableObject implements Serializable {
    private static final long serialVersionUID = -5224933017568536037L;
    private String a;

    public SerializeableObject(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
