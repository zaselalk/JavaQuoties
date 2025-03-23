package com.tec.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 3001;
        String host = "localhost";
        try(Socket socket = new Socket(host, port)){
                // create streams
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

           while (true){
               out.writeUTF(sc.nextLine());
               out.flush();

               // read
               System.out.println(in.readUTF());
           }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
