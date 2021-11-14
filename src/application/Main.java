package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Purpose is to generate stage for other components.
 *
 * @author Jason Li, John Leng
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
        primaryStage.setTitle("RU Pizzeria Home");
        primaryStage.setScene(new Scene(root, 818, 692));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
