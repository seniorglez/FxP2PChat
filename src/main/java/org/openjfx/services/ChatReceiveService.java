package org.openjfx.services;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import org.openjfx.configuration.Configuration;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceiveService extends ScheduledService<String> {

    private DatagramPacket paqueteEnReceptor;
    private DatagramSocket socket;
    private byte[] bufer;

    @Override
    protected Task<String> createTask() {
        ChatReceiveTask chatReceiveTask = new ChatReceiveTask();
        chatReceiveTask.setBufer(bufer);
        chatReceiveTask.setPaqueteEnReceptor(paqueteEnReceptor);
        chatReceiveTask.setSocket(socket);
        return chatReceiveTask;
    }

    public void configure(){
        try {
            socket = new DatagramSocket(Configuration.inPort);
            bufer = new byte[200];
            paqueteEnReceptor = new DatagramPacket(bufer, bufer.length);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
