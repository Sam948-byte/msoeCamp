package dayThree.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class labFourDriver extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Estimate Pi");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
