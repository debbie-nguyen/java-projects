package edu.sdccd.cisc191;

import java.net.*;
import java.io.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public VehicleResponse send(VehicleRequest request) throws Exception {
        out.println(VehicleRequest.toJSON(request));
        return VehicleResponse.fromJSON(in.readLine());
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.startConnection("127.0.0.1", 4444);
            System.out.println(client.send(new VehicleRequest(2018,"Subaru","Forester")).toString());
            client.stopConnection();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}