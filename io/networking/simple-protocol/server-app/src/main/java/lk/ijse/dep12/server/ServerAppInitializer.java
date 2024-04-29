package lk.ijse.dep12.server;

import lk.ijse.dep12.shared.to.Customer;
import lk.ijse.dep12.shared.to.Request;
import lk.ijse.dep12.shared.to.Response;
import lk.ijse.dep12.shared.util.Status;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAppInitializer {

    public static void main(String[] args) throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(5051)){
            System.out.println("Server has been started");
            while (true) {
                Socket localSocket = serverSocket.accept();
                System.out.println("New client: " + localSocket.getRemoteSocketAddress());

                new Thread(()->{
                    try {
                        ObjectInputStream ois = new ObjectInputStream(localSocket.getInputStream());
                        ObjectOutputStream oos = new ObjectOutputStream(localSocket.getOutputStream());

                        while (true) {
                            try {
                                Request clientRequest = (Request) ois.readObject();
                                switch (clientRequest.getType()) {
                                    case CUSTOMER -> {
                                        try {
                                            Customer customer = (Customer) clientRequest.getBody();
                                            if (customer != null) {
                                                oos.writeObject(new Response(Status.SUCCESS, customer.toString()));
                                            } else {
                                                oos.writeObject(new Response(Status.BAD_REQUEST, "Empty Customer"));
                                            }
                                        } catch (ClassCastException exp) {
                                            oos.writeObject(new Response(Status.BAD_REQUEST, "Invalid Customer Object"));
                                        }
                                    }
                                    case FILE -> {
                                        try {
                                            byte[] file = (byte[]) clientRequest.getBody();
                                            if (file != null) {
                                                oos.writeObject(new Response(Status.SUCCESS, "File received"));
                                            } else {
                                                oos.writeObject(new Response(Status.BAD_REQUEST, "Empty File"));
                                            }
                                        } catch (ClassCastException exp) {
                                            oos.writeObject(new Response(Status.BAD_REQUEST, "Invalid File"));
                                        }
                                    }
                                    default -> {
                                        try {
                                            String message = (String) clientRequest.getBody();
                                            if (message != null) {
                                                oos.writeObject(new Response(Status.SUCCESS, "Received: " + message));
                                            } else {
                                                oos.writeObject(new Response(Status.BAD_REQUEST, "Empty Message"));
                                            }
                                        } catch (ClassCastException exp) {
                                            oos.writeObject(new Response(Status.BAD_REQUEST, "Invalid message"));
                                        }
                                    }
                                }
                            } catch (ClassCastException exp) {
                                oos.writeObject(new Response(Status.BAD_REQUEST, "Invalid Client Request"));
                            }
                        }

                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
            }
        }
    }
}
