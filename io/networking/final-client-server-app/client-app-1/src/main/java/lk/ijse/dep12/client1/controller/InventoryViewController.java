package lk.ijse.dep12.client1.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep12.shared.to.Item;

import java.math.BigDecimal;

public class InventoryViewController {

    public Button btnDelete;
    public Button btnNewItem;
    public Button btnSave;
    public TableView<Item> tblInventory;
    public TextField txtBarcode;
    public TextField txtDescription;
    public TextField txtPrice;
    public TextField txtQty;

    public void initialize() {
        tblInventory.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("barcode"));
        tblInventory.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblInventory.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblInventory.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("price"));

        tblInventory.getSelectionModel().selectedItemProperty().addListener((o, previous, current) -> {
            btnDelete.setDisable(current == null);
            btnSave.setDisable(current != null);
            if (current != null){
                txtBarcode.setText(current.getBarcode());
                txtDescription.setText(current.getDescription());
                txtQty.setText(current.getQty() + "");
                txtPrice.setText(current.getPrice().toString());
            }
        });

        btnDelete.setDisable(true);
    }

    public void btnDeleteOnAction(ActionEvent event) {
        Item selectedItem = tblInventory.getSelectionModel().getSelectedItem();
        ObservableList<Item> itemList = tblInventory.getItems();
        itemList.remove(selectedItem);
        if (itemList.isEmpty()) btnNewItem.fire();
    }

    public void tblInventoryOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnDelete.fire();
    }

    public void btnNewItemOnAction(ActionEvent event) {
        for (var txt : new TextField[]{txtBarcode, txtDescription, txtQty, txtPrice}) txt.clear();
        tblInventory.getSelectionModel().clearSelection();
        txtBarcode.requestFocus();
        btnSave.setDisable(false);
    }

    public void btnSaveOnAction(ActionEvent event) {
        TextField invalidField;
        if ((invalidField = validateData()) != null) {
            invalidField.requestFocus();
            invalidField.selectAll();
            return;
        }

        ObservableList<Item> itemList = tblInventory.getItems();
        String barcode = txtBarcode.getText().strip();

        for (Item item : itemList) {
            if (item.getBarcode().equals(barcode)) {
                new Alert(Alert.AlertType.ERROR, "Item already exists").show();
                txtBarcode.requestFocus();
                txtBarcode.selectAll();
                return;
            }
        }

        Item newItem = new Item(barcode,
                txtDescription.getText().strip(),
                Integer.parseInt(txtQty.getText()),
                new BigDecimal(txtPrice.getText()));
        itemList.add(newItem);

        btnNewItem.fire();
    }

    private TextField validateData() {
        String barcode = txtBarcode.getText();
        String description = txtDescription.getText();
        String qty = txtQty.getText();
        String price = txtPrice.getText();

        if (barcode.isBlank() || !isNumber(barcode.strip())) return txtBarcode;
        else if (description.isBlank() || description.length() < 3) return txtDescription;
        else if (qty.isBlank() || !isNumber(qty) || Integer.parseInt(qty) <= 0) return txtQty;
        else if (price.isBlank() || !isPrice(price)) return txtPrice;

        return null;
    }

    private boolean isPrice(String input) {
        try {
            BigDecimal price = new BigDecimal(input);
            return price.compareTo(BigDecimal.ZERO) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

}
