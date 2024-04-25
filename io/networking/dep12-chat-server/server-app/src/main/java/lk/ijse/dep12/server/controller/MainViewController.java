package lk.ijse.dep12.server.controller;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainViewController {

    public TextArea txtMessage;

    public void initialize() {
        new Thread(()->{
            try(ServerSocket serverSocket = new ServerSocket(5050)){
                while (true) {
                    Socket localSocket = serverSocket.accept();
                    updateText(localSocket.getRemoteSocketAddress() + ": Entered\n");

                    new Thread(() -> {
                        try {
                            InputStream is = localSocket.getInputStream();
                            byte[] byteBuffer = new byte[1024];
                            while (true){
                                int read = is.read(byteBuffer);
                                if (read == -1){
                                    updateText(localSocket.getRemoteSocketAddress() + ": Exited\n");
                                    break;
                                }
                                String message = new String(byteBuffer, 0, read);
                                updateText(localSocket.getRemoteSocketAddress() + ": " + message);
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).start();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void updateText(String message){
        Platform.runLater(()-> txtMessage.appendText(message));
    }
}
