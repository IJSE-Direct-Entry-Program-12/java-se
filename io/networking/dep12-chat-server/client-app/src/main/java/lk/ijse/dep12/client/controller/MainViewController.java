package lk.ijse.dep12.client.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class MainViewController {
    public TextField txtMessage;
    public Button btnSend;
    private Socket remoteSocket;

    public void initialize() throws IOException {
        remoteSocket = new Socket("localhost", 5050);
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        String message = txtMessage.getText() + "\n";
        remoteSocket.getOutputStream().write(message.getBytes());
        txtMessage.clear();
        txtMessage.requestFocus();
    }
}
