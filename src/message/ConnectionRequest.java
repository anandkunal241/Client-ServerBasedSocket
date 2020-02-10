/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.io.*;
/**
 *
 * @author kunal
 */
public class ConnectionRequest implements Serializable{
    
    private String ip;
    private int port;
    
    public ConnectionRequest(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }
    
    public String getIp()
    {
        return ip;
    }
    
    public int getPort()
    {
        return port;
    }
}
