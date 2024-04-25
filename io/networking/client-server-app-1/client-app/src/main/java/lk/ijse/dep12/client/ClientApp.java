package lk.ijse.dep12.client;

import java.io.IOException;
import java.net.Socket;

public class ClientApp {

    public static void main(String[] args) throws IOException {
        try(Socket remoteSocket = new Socket("localhost", 5050)){
            System.out.println("Connected to the server");
        }
    }
}
