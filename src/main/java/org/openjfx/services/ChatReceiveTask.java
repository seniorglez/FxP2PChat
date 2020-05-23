package org.openjfx.services;

import javafx.concurrent.Task;
import org.openjfx.configuration.Configuration;

import java.net.*;
import java.util.Arrays;



public class ChatReceiveTask extends Task<String> {


    private DatagramPacket paqueteEnReceptor;
    private DatagramSocket socket;
    private byte[] bufer;


    public ChatReceiveTask(){
        try {
        socket = new DatagramSocket(Configuration.inPort);
        bufer = new byte[200];
        paqueteEnReceptor = new DatagramPacket(bufer, bufer.length);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String call() throws Exception {
        String s="";
        if (!socket.isClosed()) {
            System.out.println("Waiting 4 a message");
            socket.receive(paqueteEnReceptor);
            System.out.println("new message");
            s=s + new String(bufer).trim() + "\n";
            updateValue(s);
            Arrays.fill(bufer, (byte) 0);
        }
        return null;
    }

}
