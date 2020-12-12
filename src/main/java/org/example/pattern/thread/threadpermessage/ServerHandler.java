package org.example.pattern.thread.threadpermessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader in = null;
        PrintWriter out = null;

        try {

            while (true) {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String clientMsg = in.readLine();
                System.out.println("客户端:" + clientMsg);

                out = new PrintWriter(socket.getOutputStream());
                System.out.println("请输入：");
                BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
                String words = s.readLine();
                out.println(words);
                out.flush();

                if ("exit".equals(words)) {
                    System.out.println("服务端关闭连接");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
