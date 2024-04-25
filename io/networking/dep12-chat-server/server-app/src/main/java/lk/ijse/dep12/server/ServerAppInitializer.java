package lk.ijse.dep12.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerAppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("/view/MainView.fxml"))));
        primaryStage.setTitle("DEP 12 Chat Server");
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
