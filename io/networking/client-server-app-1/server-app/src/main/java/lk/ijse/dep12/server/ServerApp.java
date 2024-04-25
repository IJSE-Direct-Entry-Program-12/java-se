package lk.ijse.dep12.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(5050)) {
            while (true) {
                System.out.println("Server is listening at 5050");
                Socket localSocket = serverSocket.accept();
                System.out.println("Incoming Connection: " + localSocket.getRemoteSocketAddress());
            }
        }
    }
}
