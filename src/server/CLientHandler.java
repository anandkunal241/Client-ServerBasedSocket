/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.*;
import java.io.*;
import message.ConnectionRequest;
import message.Message;

/**
 *
 * @author kunal
 */
public class CLientHandler implements Runnable{
    private Socket socket,remotesocket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private ConnectionRequest request;
    private Message message;

    public CLientHandler(Socket socket,Socket remotesocket)
    {
        try
        {    
            this.socket = socket;
            this.remotesocket = remotesocket;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
   
    @Override
    public void run() {
        try{
            System.out.println("CLientHandlerRunning");
          
            while(true)
            {
                ois = new ObjectInputStream(socket.getInputStream());
                message = (Message) ois.readObject();
                oos = new ObjectOutputStream(remotesocket.getOutputStream());
                oos.writeObject(message);
                oos.flush();
            }
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        
    }
    
    
    
}
