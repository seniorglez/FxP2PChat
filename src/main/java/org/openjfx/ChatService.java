package org.openjfx;

import javafx.concurrent.Task;

import java.net.*;
import java.util.Arrays;



public class ChatService extends Task {


    private DatagramPacket paqueteEnReceptor;
    private DatagramPacket paqueteAEnviar;
    private DatagramSocket socketEnvio;
    private DatagramSocket socket;
    private byte[] bufer;
    private int inPort = 3000;
    private int outPort = 2000;
    private static ChatService instance= null;

    private ChatService(){
        try {
            socketEnvio = new DatagramSocket();
        socket = new DatagramSocket(inPort);
        bufer = new byte[200];
        paqueteEnReceptor = new DatagramPacket(bufer, bufer.length);
        paqueteAEnviar = new DatagramPacket(bufer,
                bufer.length,
                InetAddress.getByName("localhost"),
                outPort);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object call() throws Exception {
        String s="";
        System.out.println("ChatTaskStarted");
        while (!socket.isClosed()) {
            socket.receive(paqueteEnReceptor);
            System.out.println("new message");
            s=s + new String(bufer).trim() + "\n";
            updateMessage(s);
            Arrays.fill(bufer, (byte) 0);
        }
        return null;
    }


    public static ChatService getInstance(){
        if(instance==null){
            instance = new ChatService();
        }
        return instance;
    }



    public void sendMsg(String client,String msg){
        String msg2Send =client + ": " + msg;

        byte[] data = msg2Send.getBytes();
        paqueteAEnviar.setData(data);
        paqueteAEnviar.setLength(data.length);

        try {
            socketEnvio.send(paqueteAEnviar);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
