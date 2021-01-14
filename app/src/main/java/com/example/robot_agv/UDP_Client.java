package com.example.robot_agv;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDP_Client extends Thread
{
    private String IP, data_to_send;
    public int port = 5008;
    InetAddress IPAddress;

    DatagramSocket Client_socket;

    public UDP_Client(String ip, String data, int port)
    {
        this.IP = ip;
        this.data_to_send=data;
        this.port=port;

    }

    public UDP_Client(String ip, String data)
    {
        this.IP = ip;
        this.data_to_send=data;

    }

    public void Send_data(String data) throws IOException {
        /*Tutaj trzeba dodac cale wysyanie klawiszy w odpowiedni sposob*/

        byte[] Data_b;

        Data_b = data.getBytes();

        Client_socket = new DatagramSocket(port);
        IPAddress = InetAddress.getByName(IP);

        DatagramPacket packet_data= new DatagramPacket(Data_b, Data_b.length, IPAddress, port);


        Client_socket.send(packet_data);
    }

    public void run()
    {
        try {
            Send_data(this.data_to_send);
            Client_socket.close();
        } catch (IOException e) {
            System.out.println("Client Error");
            e.printStackTrace();
        }
    }

}
