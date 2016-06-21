package edu.avans.netmul.task.one.a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author JKetelaar
 */
public class UdpServer {

    public static final int DEFAULT_SOCKET_PORT = 7896;

    public UdpServer(int port) {
        try {
            this.start(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UdpServer() {
        try {
            this.start(DEFAULT_SOCKET_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start(int port) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(port);
        byte[] receivedBytes = new byte[1024];

        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(receivedBytes, receivedBytes.length);
            datagramSocket.receive(datagramPacket);

            System.out.println("Client with port " + datagramPacket.getPort() + " sent: " + new String(datagramPacket.getData()));
        }
    }
}
