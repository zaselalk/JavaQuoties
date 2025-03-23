package com.tec.server;

import com.tec.quote.RandomQuote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        int port = 3001;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            Socket socket = serverSocket.accept();
            System.out.println("New connection from " + socket.getRemoteSocketAddress());

            while (true) {

                // streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String input = in.readUTF();
                if(input.equalsIgnoreCase("hi")){
                    out.writeUTF("hi");
                }
                if(input.equalsIgnoreCase("bye")){
                    out.writeUTF("bye");
                    socket.close();
                }
                if(input.equalsIgnoreCase("get")){
                    out.writeUTF(new RandomQuote().getQuote());
                }

            }
        } catch (Exception e) {
            System.out.println("Server closed on:" + port);
//            e.printStackTrace();
        }
    }
}
