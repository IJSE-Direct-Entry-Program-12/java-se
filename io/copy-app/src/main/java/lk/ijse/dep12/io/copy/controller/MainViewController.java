package lk.ijse.dep12.io.copy.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class MainViewController {

    public Button btnBrowseSource;
    public Button btnBrowseTarget;
    public Button btnCopy;
    public Button btnReset;
    public Label lblProgress;
    public Label lblStatus;
    public ProgressBar pbCopy;
    public AnchorPane root;
    public TextField txtSource;
    public TextField txtTarget;

    public void btnBrowseSourceOnAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select source folder");
        File folder = directoryChooser.showDialog(btnBrowseSource.getScene().getWindow());
        txtSource.setText(folder == null ? "" : folder.getAbsolutePath());
    }

    public void btnBrowseTargetOnAction(ActionEvent event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select target folder");
        File folder = directoryChooser.showDialog(btnBrowseTarget.getScene().getWindow());
        txtTarget.setText(folder == null ? "" : folder.getAbsolutePath());
    }

    public void btnCopyOnAction(ActionEvent event) {
        String source = txtSource.getText();
        String target = txtTarget.getText();
        if (source.isBlank()) {
            txtSource.requestFocus();
            return;
        }
        if (target.isBlank()) {
            txtTarget.requestFocus();
            return;
        }
        Task<Object> copyTask = new Task<>() {
            @Override
            protected Object call() throws Exception {
                updateMessage("Analyzing the folder content");
                Path sourcePath = Paths.get(txtSource.getText());
                Path targetPath = Paths.get(txtTarget.getText(), sourcePath.getFileName() + "");
                while (Files.exists(targetPath)){
                    targetPath = Paths.get(targetPath + " (copy)");
                }

                ArrayList<Path> paths = new ArrayList<>();
                Files.walkFileTree(sourcePath, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        if (!sourcePath.equals(dir)) paths.add(dir);
                        return super.preVisitDirectory(dir, attrs);
                    }
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        paths.add(file);
                        return super.visitFile(file, attrs);
                    }
                });
                if (Files.notExists(targetPath)) {
                    updateMessage("Create target directory");
                    Files.createDirectory(targetPath);
                }
                int i = 0;
                for (Path path : paths) {
                    if (Files.isDirectory(path)) {
                        updateMessage("Creating directory: " + path.getFileName());
                    } else {
                        updateMessage("Copying file: " + path.getFileName());
                    }
                    Files.copy(path, targetPath.resolve(sourcePath.relativize(path)));
                    updateProgress(++i, paths.size());
                    Thread.sleep(100);
                }
                updateMessage("Copied Successfully");
                return null;
            }
        };

        copyTask.progressProperty().addListener((observable, previous, current) -> {
            lblProgress.setText((int) (current.doubleValue() * 100) + "%");
        });
        pbCopy.progressProperty().bind(copyTask.progressProperty());
        lblStatus.textProperty().bind(copyTask.messageProperty());
        new Thread(copyTask).start();
    }

    public void btnResetOnAction(ActionEvent event) {
        lblStatus.textProperty().unbind();
        pbCopy.progressProperty().unbind();
        lblStatus.setText("Click copy to start");
        lblProgress.setText("0%");
        pbCopy.setProgress(0);
        txtSource.clear();
        txtTarget.clear();
        btnCopy.requestFocus();
    }

}
