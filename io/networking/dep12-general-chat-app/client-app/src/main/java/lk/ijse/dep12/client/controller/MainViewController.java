package lk.ijse.dep12.client.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;

public class MainViewController {
    public Button btnSend;
    public TextField txtMessage;
    public TextArea txtDisplay;

    private String nickName;
    private Socket remoteSocket;

    public void initData(Socket remoteSocket, String nickName) {
        this.nickName = nickName;
        this.remoteSocket = remoteSocket;

        txtDisplay.appendText("You: Entered into the chat room \n");

        new Thread(() -> {
            try {
                InputStream is = remoteSocket.getInputStream();
                byte[] byteBuffer = new byte[1024];
                while (true) {
                    int read = is.read(byteBuffer);
                    if (read == -1) {
                        appendText("Connection lost");
                        Platform.runLater(() -> {
                            txtMessage.setDisable(true);
                            btnSend.setDisable(true);
                        });
                        break;
                    }
                    String message = new String(byteBuffer, 0, read);
                    Arrays.fill(byteBuffer, (byte) 0);
                    appendText(message);
                }
            } catch (IOException e) {
                if (!remoteSocket.isClosed())
                    throw new RuntimeException(e);
            }
        }).start();
    }

    private void appendText(String message) {
        Platform.runLater(() -> txtDisplay.appendText(message));
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        txtDisplay.appendText("You: " + txtMessage.getText().strip() + "\n");
        String message = nickName + ": " + txtMessage.getText().strip() + "\n";
        remoteSocket.getOutputStream().write(message.getBytes());
        txtMessage.clear();
        txtMessage.requestFocus();
    }
}
