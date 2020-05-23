package org.openjfx.services;

import javafx.concurrent.Task;

import java.net.*;
import java.util.Arrays;

public class ChatReceiveTask extends Task<String> {

    private DatagramPacket paqueteEnReceptor;
    private DatagramSocket socket;
    private byte[] bufer;




    @Override
    protected String call() throws Exception {
        String s="";
        if (!socket.isClosed()) {
            System.out.println("Waiting 4 a message");
            socket.receive(paqueteEnReceptor);
            s=s + new String(bufer).trim() + "\n";
            System.out.println("new message: " + s);
            Arrays.fill(bufer, (byte) 0);
        }
        return s;
    }

    public void setPaqueteEnReceptor(DatagramPacket paqueteEnReceptor) {
        this.paqueteEnReceptor = paqueteEnReceptor;
    }


    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    public void setBufer(byte[] bufer) {
        this.bufer = bufer;
    }
}
