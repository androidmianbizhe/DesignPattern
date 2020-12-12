package org.example.pattern.thread.workermessage;

public class WorkerDemo {

    public static void main(String[] args) {
        // 新建工人
        final PackageChannel channel = new PackageChannel(8);
        // 开始工作
        channel.startWorkers();

        for (int i = 0; i < 100; i++) {
            Package pack = new Package();
            pack.setAddress("test" + i);
            pack.setName("test" + i);

            channel.put(pack);
        }

    }
}
