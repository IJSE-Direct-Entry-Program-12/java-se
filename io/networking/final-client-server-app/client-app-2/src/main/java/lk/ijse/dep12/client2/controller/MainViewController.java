package lk.ijse.dep12.client2.controller;

import javafx.application.Platform;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep12.shared.to.Item;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class MainViewController {
    public TableView<Item> tblInventory;
    private Socket remoteSocket;

    public void initialize() throws IOException, ClassNotFoundException {
        remoteSocket = new Socket("localhost", 5050);
        loadStock();
        tblInventory.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("barcode"));
        tblInventory.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblInventory.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblInventory.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private void loadStock()  {
        new Thread(()->{
            while (true) {
                try {
                    ObjectInputStream ois = new ObjectInputStream(remoteSocket.getInputStream());
                    List<Item> itemList = (List<Item>) ois.readObject();
                    Platform.runLater(()->{
                        tblInventory.getItems().clear();
                        tblInventory.getItems().addAll(itemList);
                    });

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
