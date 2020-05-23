package org.openjfx.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.openjfx.configuration.Configuration;

import java.net.*;

public class ChatShipService extends Service<String> {

    private DatagramPacket package2ship;
    private DatagramSocket socketEnvio;
    private byte[] bufer;
    private String message;

    public ChatShipService() {
        try {
            bufer = new byte[200];
            package2ship = new DatagramPacket(bufer,
                    bufer.length,
                    InetAddress.getByName("localhost"),
                    Configuration.outPort);
            socketEnvio = new DatagramSocket();
        } catch (UnknownHostException| SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Task<String> createTask() {
        ChatShipTask chatShipTask = new ChatShipTask();
        chatShipTask.setBufer(bufer);
        chatShipTask.setPackage2ship(package2ship);
        chatShipTask.setSocketEnvio(socketEnvio);
        chatShipTask.setMsg(message);
        return chatShipTask;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
