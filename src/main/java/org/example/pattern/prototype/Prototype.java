package org.example.pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = -5628102098353991861L;

    private String string;

    private SerializeableObject obj;

    /**
     * 浅层复制
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        /**
         * 将当前对对象写入二进制流
         */
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(this);

        /**
         * 读出二进制流产生新的对象
         */
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializeableObject getObj() {
        return obj;
    }

    public void setObj(SerializeableObject obj) {
        this.obj = obj;
    }
}
