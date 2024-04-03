package lk.ijse.dep12.editor.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainViewController {

    public TextArea txt;
    private File currentFile;

    public void mnNewOnAction(ActionEvent event) {
        txt.clear();
        txt.requestFocus();
        setTitle("Untitled Document");
        currentFile = null;
    }

    public void mnOpenOnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a text file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plain Text Files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files (*.*)", "*.*"));
        fileChooser.setInitialDirectory(new File(System.getenv("HOME"), "Desktop"));
        currentFile = fileChooser.showOpenDialog(txt.getScene().getWindow());
        if (currentFile == null) return;

        try {
            try (FileInputStream fis = new FileInputStream(currentFile)) {
                byte[] bytes = new byte[(int) currentFile.length()];
                fis.read(bytes);
                txt.setText(new String(bytes));
                setTitle(currentFile.getName());
            }
        } catch (Throwable e) {
            new Alert(Alert.AlertType.ERROR, "Failed to read the file, try again").show();
            e.printStackTrace();
        }
    }

    private void setTitle(String title) {
        ((Stage) (txt.getScene().getWindow())).setTitle(title);
    }

    public void mnSaveOnAction(ActionEvent event) {
        if (currentFile == null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save a text file");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plain Text Files (*.txt)", "*.txt"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files (*.*)", "*.*"));
            fileChooser.setInitialDirectory(new File(System.getenv("HOME"), "Desktop"));
            File file = fileChooser.showSaveDialog(txt.getScene().getWindow());
            if (file == null) return;
            currentFile = file;
            setTitle(file.getName());
        }
        try (FileOutputStream fos = new FileOutputStream(currentFile)) {
            fos.write(txt.getText().getBytes());
        } catch (Throwable t) {
            new Alert(Alert.AlertType.ERROR, "Failed to save the file").show();
            t.printStackTrace();
        }
    }

    public void mnCloseOnAction(ActionEvent event) {

    }

    public void mnSaveAsOnAction(ActionEvent event) {

    }


}
