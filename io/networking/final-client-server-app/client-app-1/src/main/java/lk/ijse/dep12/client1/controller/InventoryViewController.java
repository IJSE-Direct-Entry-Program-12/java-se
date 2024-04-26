package lk.ijse.dep12.client1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep12.client1.to.Item;

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

    public void btnDeleteOnAction(ActionEvent event) {

    }

    public void btnNewItemOnAction(ActionEvent event) {

    }

    public void btnSaveOnAction(ActionEvent event) {
        TextField invalidField;
        if ((invalidField = validateData()) != null) {
            invalidField.requestFocus();
            invalidField.selectAll();
            return;
        }

    }

    private TextField validateData(){
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

    private boolean isPrice(String input){
        try {
            BigDecimal price = new BigDecimal(input);
            return price.compareTo(BigDecimal.ZERO) > 0;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isNumber(String input){
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public void tblInventoryOnKeyPressed(KeyEvent event) {

    }

}
