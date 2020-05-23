package org.openjfx.services;

import javafx.concurrent.Task;
import org.openjfx.configuration.Configuration;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ChatShipTask extends Task<String> {

    private DatagramPacket package2ship;
    private DatagramSocket socketEnvio;
    private byte[] bufer;
    private String msg;

    @Override
    protected String call() throws Exception {
        sendMsg(Configuration.user,msg);
        return null;
    }

    private void sendMsg(String client,String msg) throws Exception {
        String msg2Send =client + ": " + msg;
        byte[] data = msg2Send.getBytes();
        package2ship.setData(data);
        package2ship.setLength(data.length);
        socketEnvio.send(package2ship);
    }

    public void setPackage2ship(DatagramPacket package2ship) {
        this.package2ship = package2ship;
    }

    public void setSocketEnvio(DatagramSocket socketEnvio) {
        this.socketEnvio = socketEnvio;
    }

    public void setBufer(byte[] bufer) {
        this.bufer = bufer;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
