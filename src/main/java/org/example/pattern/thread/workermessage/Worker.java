package org.example.pattern.thread.workermessage;

import java.util.Random;

public class Worker extends Thread {

    public final static Random random = new Random(System.currentTimeMillis());

    private final PackageChannel channel;

    public Worker(String name, PackageChannel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {

        while (true) {
            channel.take().execute();

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
