package lk.ijse.dep12.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerApp {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(5050)) {
            while (true) {
                System.out.println("Server is listening at 5050");
                Socket localSocket = serverSocket.accept();
                System.out.println("Incoming connection: " + localSocket.getRemoteSocketAddress());

                new Thread(()->{
                    try {
                        InputStream is = localSocket.getInputStream();
                        byte[] byteBuffer = new byte[1024];
                        while (true) {
                            int read = is.read(byteBuffer);
                            if (read == -1) break;
                            String message = new String(byteBuffer, 0, read);
                            System.out.print(message);
                            Arrays.fill(byteBuffer, (byte) 0);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).start();

            }
        }
    }
}
