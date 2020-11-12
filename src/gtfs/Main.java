/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * creates the gui and starts program
 *
 * @author Andrew Budreck
 * @version 1.0
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setStage(primaryStage);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        controller.goHome();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
