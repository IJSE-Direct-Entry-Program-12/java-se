package lk.ijse.dep12.ransomware.controller;

import com.github.sarxos.webcam.Webcam;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;

public class MainViewController {
    public ImageView imgWebCam;

    public void initialize(){
        Task<Object> camTask = new Task<>(){
            @Override
            protected Object call() throws Exception {
                Webcam webcam = Webcam.getDefault();
                webcam.open();
                Runtime.getRuntime().addShutdownHook(new Thread(()->{
                    webcam.close();
                }));
                while (true) {
                    BufferedImage image = webcam.getImage();
                    WritableImage fxImage = SwingFXUtils.toFXImage(image, null);
                    Platform.runLater(()-> imgWebCam.setImage(fxImage));
                    Thread.sleep(47);       // fps = 21
                }
            }
        };

        Platform.runLater(()->{
            Stage stage = (Stage) (imgWebCam.getScene().getWindow());
            stage.setOnCloseRequest(event ->{
                camTask.cancel();
            });
        });
        new Thread(camTask).start();

    }
}
