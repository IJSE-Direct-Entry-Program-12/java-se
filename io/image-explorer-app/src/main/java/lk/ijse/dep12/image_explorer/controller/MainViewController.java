package lk.ijse.dep12.image_explorer.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainViewController {
    public TreeView<String> tvExplorer;

    public void initialize() {
        TreeItem<String> rootNode = new TreeItem<>();
        rootNode.setValue("This PC");
        rootNode.setGraphic(getIcon("pc"));
        tvExplorer.setRoot(rootNode);
        rootNode.setExpanded(true);

        for (Path disk : FileSystems.getDefault().getRootDirectories()) {
            TreeItem<String> diskNode = new TreeItem<>(disk.toString());
            diskNode.setGraphic(getIcon("disk"));
            rootNode.getChildren().add(diskNode);
            diskNode.expandedProperty().addListener((observable, previous, current) -> {
                if (!current || !diskNode.getChildren().isEmpty()) return;
                try {
                    try (DirectoryStream<Path> paths = Files.newDirectoryStream(disk)) {
                        for (Path folder : paths) {
                            TreeItem<String> folderNode = new TreeItem<>(folder.getFileName().toString());
                            folderNode.setGraphic(getIcon("folder"));
                            diskNode.getChildren().add(folderNode);
                            folderNode.expandedProperty().addListener((o, p, c) -> {
                                folderNode.setGraphic(getIcon(c ? "folder-open": "folder"));
                            });
                            if (Files.isReadable(folder)){
                                try(DirectoryStream<Path> paths1 = Files.newDirectoryStream(folder)){
                                    if (paths1.iterator().hasNext()){
                                        TreeItem<String> fakeFolder = new TreeItem<>("Fake");
                                        fakeFolder.setGraphic(getIcon("folder"));
                                        folderNode.getChildren().add(fakeFolder);
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    new Alert(Alert.AlertType.ERROR, "Failed to read the disk").show();
                    e.printStackTrace();
                }
            });
        }
        rootNode.getChildren().getFirst().setExpanded(true);
    }

    private ImageView getIcon(String icon) {
        ImageView imageView = new ImageView(switch (icon) {
            case "pc" -> "/icon/computer.png";
            case "disk" -> "/icon/external-hard-drive.png";
            case "folder" -> "/icon/folder.png";
            case "folder-open" -> "/icon/open-folder.png";
            case null, default -> throw new RuntimeException("Invalid icon");
        });
        imageView.setFitWidth(24);
        imageView.setPreserveRatio(true);
        return imageView;
    }
}
