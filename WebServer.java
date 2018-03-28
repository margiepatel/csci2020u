package sample;

import java.io.*;
import java.net.*;

public final class WebServer {
    private ServerSocket serverSocket = null;

    public WebServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            handleRequests();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Starts up the server & acquire connection.
    public void handleRequests() {
        System.out.println("WebServer Listening");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();//wait for connection

                HttpRequestHandler clientHandler=new HttpRequestHandler(clientSocket);
                Thread clientThread=new Thread(clientHandler);
                clientThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WebServer webServer = new WebServer(8080);
        webServer.handleRequests();
    }
}