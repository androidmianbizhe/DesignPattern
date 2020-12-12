package org.example.pattern.thread.threadpermessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {

    private static int PORT = 12345;
    private static String ADDRESS = "localhost";

    private static Socket clientSocket;

    public static void main(String[] args) {
        start(PORT);
    }

    private static void start(int port) {
        if (clientSocket != null) {
            return;
        }
        try {
            clientSocket = new Socket(ADDRESS, PORT);
            System.out.println("Client start...");

            while (true) {
                // 向服务器端发送数据
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                System.out.println("请输入：\t");

                String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
                out.println(str);
                out.flush();

                // 如果是exit则断开连接
                if ("exit".equals(str)) {
                    System.out.println("客户端关闭连接");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                // 读取服务器数据
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String mes = in.readLine();
                System.out.println("服务端：" + mes);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clientSocket = null;
            }
        }

    }
}
