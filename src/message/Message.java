/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;
import enums.Messagetype;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author kunal
 */
public class Message implements Serializable{
    
    private Messagetype messagetype;
    private String text;
    private ArrayList<Byte>stream;
    private String filename;
    
    public Message()
    {
        this.messagetype = null;
        this.stream = null;
        this.text = null;
        this.filename = null;
    }
    
    public void setMessagetype(Messagetype messagetype)
    {
        this.messagetype = messagetype;
    }
    
    public void setText(String text)
    {
        this.text = text;
    }
    
    public void setBytes(ArrayList<Byte> stream)
    {
        this.stream = stream;
    }
    
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
    
    public Messagetype getMessagetype()
    {
        return this.messagetype;
    }
    
    public String getText(){
        
        return this.text;
    }
    
    public ArrayList<Byte> getBytes()
    {
        return this.stream;
    }
    
    public String getFilename()
    {
        return filename;
    }

    
}
