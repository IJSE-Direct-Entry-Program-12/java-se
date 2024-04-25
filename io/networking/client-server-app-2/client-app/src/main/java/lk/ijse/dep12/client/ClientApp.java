package lk.ijse.dep12.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

    public static void main(String[] args) throws IOException {
        final Scanner SCANNER = new Scanner(System.in);

        try(Socket remoteSocket = new Socket("localhost", 5050)){
            System.out.println("Connected to the server");

            while (true) {
                System.out.print("Enter message: ");
                String message = SCANNER.nextLine().strip() + "\n";
                if (message.equalsIgnoreCase("exit\n")) break;
                remoteSocket.getOutputStream().write(message.getBytes());
            }
        }
    }
}
