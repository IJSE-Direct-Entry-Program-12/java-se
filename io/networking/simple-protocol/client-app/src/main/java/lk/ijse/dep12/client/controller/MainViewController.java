package lk.ijse.dep12.client.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import lk.ijse.dep12.shared.to.Customer;
import lk.ijse.dep12.shared.to.Request;
import lk.ijse.dep12.shared.to.Response;
import lk.ijse.dep12.shared.util.Type;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;

public class MainViewController {

    public Button btnBrowse;
    public Button btnSendCustomer;
    public Button btnSendFile;
    public Button btnSendMessage;
    public TextField txtFile;
    public TextField txtId;
    public TextField txtMessage;
    public TextField txtName;

    private ObjectOutputStream oos;

    public void btnBrowseOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");
        File file = fileChooser.showOpenDialog(btnBrowse.getScene().getWindow());
        txtFile.setText(file != null ? file.getAbsolutePath() : "");
    }

    public void initialize() throws IOException {
        Socket remoteSocket = new Socket("localhost", 5051);
        oos = new ObjectOutputStream(remoteSocket.getOutputStream());

        new Thread(()->{
            try {
                ObjectInputStream ois = new ObjectInputStream(remoteSocket.getInputStream());
                while (true){
                    Response response = (Response) ois.readObject();
                    System.out.println(response);
                    disableSendButtons(false);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private void disableSendButtons(boolean disable){
        btnSendCustomer.setDisable(disable);
        btnSendFile.setDisable(disable);
        btnSendMessage.setDisable(disable);
    }

    public void btnSendCustomerOnAction(ActionEvent event) throws IOException {
        Customer customer = new Customer(txtId.getText(), txtName.getText());
        Request request = new Request(Type.CUSTOMER, customer);
        oos.writeObject(request);
        disableSendButtons(true);
        txtId.clear();
        txtName.clear();
        System.out.println("Customer has been sent");
    }

    public void btnSendMessageOnAction(ActionEvent event) throws IOException {
        oos.writeObject(new Request(Type.MESSAGE, txtMessage.getText()));
        disableSendButtons(true);
        txtMessage.clear();
        System.out.println("Message has been sent");
    }

    public void btnSendFileOnAction(ActionEvent event) throws IOException {
        File file = new File(txtFile.getText());
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = fis.readAllBytes();
        Request request = new Request(Type.FILE, bytes);
        oos.writeObject(request);
        disableSendButtons(true);
        txtFile.clear();
        System.out.println("File has been sent");
    }


}
