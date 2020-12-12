package org.example.pattern.thread.workermessage;

import java.util.Arrays;

public class PackageChannel {

    private final static int MAX_PACKAGE_NUM = 100;

    private final Package[] packagesQueue;

    private final Worker[] workerPool;

    private int head;
    private int tail;
    private int count;

    public PackageChannel(int workers) {
        this.packagesQueue = new Package[MAX_PACKAGE_NUM];
        this.workerPool = new Worker[workers];

        this.head = 0;
        this.tail = 0;
        this.count = 0;

        this.init();
    }

    private void init() {
        for (int i = 0; i < workerPool.length; i++) {
            workerPool[i] = new Worker("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        Arrays.asList(workerPool).forEach(Worker::start);
    }

    public synchronized Package take() {

        while (count <= 0) {

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Package request = this.packagesQueue[head];

        this.head = (this.head + 1) % this.packagesQueue.length;
        this.count--;
        this.notifyAll();

        return  request;
    }

    public synchronized  void put(Package pack) {
        if (this.count > packagesQueue.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.packagesQueue[tail] = pack;
        this.tail = (this.tail + 1) % this.packagesQueue.length;
        this.count ++;
        this.notifyAll();
    }

}
