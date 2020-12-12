package org.example.pattern.thread.threadpermessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static int DEFAULT_PORT = 12345;

    private static ServerSocket serverSocket;

    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }

    private static void start(int port) throws IOException {
        if (serverSocket != null) {
            return;
        }

        try {
            // 启动服务
            serverSocket = new ServerSocket(port);
            // 监听客户端
            while (true) {

                Socket socket = serverSocket.accept();
                long start = System.currentTimeMillis();

                new Thread(new ServerHandler(socket)).start();

                long end = System.currentTimeMillis();

                System.out.println("cost " + (end - start));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                System.out.println("服务器关闭");
                serverSocket.close();
            }
        }
    }

    public static void main(String[] args) {
        // 服务端
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
