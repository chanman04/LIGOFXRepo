/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligofx;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Listener;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Mike
 */
public class MainPane extends Application {
    
       String videoURL = "<iframe width=\"560\" height=\"315\" src=\"http://www.youtube.com/embed/9bZkp7q19f0\" frameborder=\"0\" allowfullscreen></iframe>";

        private Controller leapController = new Controller();
        private MainLeapListener listener = new MainLeapListener();
        
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //Setup Leap controller and listener pair
        leapController.addListener(listener);
        
        
        Parent root = FXMLLoader.load(getClass().getResource("main_pane.fxml"));
        
        //Use Rectangle2D to determine screen size
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        
        //Throw in WebView stuff
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(videoURL);

        
        //Now we set the Scene to the dimensions we pulled
        Scene scene = new Scene(root, visualBounds.getWidth(), visualBounds.getHeight());
        
        
        stage.setScene(scene);
        stage.show();
    }
    
    private Pane loadMainPanel() throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        Pane mainPane = (Pane) loader.load(
        getClass().getResourceAsStream(
            LigoNavigator.MAIN
            )
        );
        
        MainController mainController = loader.getController();
        
        LigoNavigator.setMainController(mainController);
        LigoNavigator.loadPane()
        
    }
    
    private Scene createScene(Pane mainPane){
        
        Scene scene = new Scene(mainPane);
        
        scene.getStylesheets().setAll(getClass().getResource("").toExternalForm());
        
        return scene;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
