package lk.ijse.dep12.client2.controller;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep12.shared.to.Item;

public class MainViewController {
    public TableView<Item> tblInventory;

    public void initialize(){
        tblInventory.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("barcode"));
        tblInventory.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblInventory.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblInventory.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
    }
}
