package org.example.pattern.thread.threadoptimize;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 例子步骤
 * 1. 查询订单库
 * 2. 查询派送库
 * 3. 执行对账操作
 * 4. 差异写入差异库
 */
public class CyclicBarrierExample {

    // 优化前
    public void before() {
        int pds = 0;
        int dos = 0;
        int diff = 0;
        while (true) {
            // 1. 查询订单库
            pds = getPOrders();
            // 2. 查询派送库
            dos = getDOrders();
            // 3. 执行对账操作
            diff = check(pds, dos);
            // 4. 差异写入库
            save(diff);
        }
    }

    private Executor executor = Executors.newFixedThreadPool(1);
    private Vector<Integer> pds;
    private Vector<Integer> dos;
    private boolean exsitNoCheckOrder = true;
    // 优化后
    public void after() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                // 在被最后await被调用的线程里面执行
                // 此时又在新的线程里面执行队长操作
                executor.execute(() -> doCheck());
            }
        });

        Thread t1 = new Thread(() -> {
            while (exsitNoCheckOrder) {
                pds.add(getPOrders());

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            while (exsitNoCheckOrder) {
                dos.add(getDOrders());

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        });
        t2.start();

    }

    private void doCheck() {
        int p = pds.remove(0);
        int d = dos.remove(0);
        int diff = check(p, d);
        save(diff);
    }

    private void save(int diff) {

    }

    private int check(int pds, int dos) {



        return 0;
    }

    private int getDOrders() {
        return 0;
    }

    private int getPOrders() {
        return 0;
    }
}
