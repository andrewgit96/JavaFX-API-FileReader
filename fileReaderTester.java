package JavaFXAPIFileReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class fileReaderTester extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("finalcoding.fxml"));

        Scene scene = new Scene(parent);
        primaryStage.setTitle("Final Coding Test");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
