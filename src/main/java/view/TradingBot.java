package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Represents the main starting point for the application.
 *
 * @author Catalin Cosma
 */
public class TradingBot extends Application {

    /**
     * Builds the GUI using JavaFX
     *
     * @param stage the GUI container
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Load the .fxml file required to build the GUI
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AuctionScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Set an icon for the application
        Image icon = new Image("file:auc.png");
        stage.getIcons().add(icon);

        // Set a tile for the application
        stage.setTitle("Trading bot");
        stage.setScene(scene);

        // Display the GUI
        stage.show();
    }

    /**
     * Starts the application.
     *
     * @param args the arguments for the main method
     */
    public static void main(String[] args) {
        launch();
    }
}