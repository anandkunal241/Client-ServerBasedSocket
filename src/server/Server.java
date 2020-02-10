/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.*;
import java.io.*;
import message.ConnectionRequest;

/**
 *
 * @author kunal
 */
public class Server {
    
    public static void main(String []args)
    {
        try
        {    
            ServerSocket ss = new ServerSocket(5401);  
            System.out.println("Server started");
            Socket socket = ss.accept();
            
            
            System.out.println("Client with ip : " + socket.getInetAddress().getHostName() + " connected");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ConnectionRequest request = (ConnectionRequest) ois.readObject();
            System.out.println("A reuqest to connect to : " + request.getIp() + " on port : " + request.getPort());
            Socket remotesocket = new Socket(request.getIp(),request.getPort());
            System.out.println("Client with ip : " + remotesocket.getInetAddress().getHostName() + " connected");
            Thread thread1 = new Thread(new CLientHandler(socket,remotesocket));
            Thread thread2 = new Thread(new CLientHandler(remotesocket,socket));
            
            thread1.start();
            thread2.start();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
