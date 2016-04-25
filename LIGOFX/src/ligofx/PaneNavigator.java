/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligofx;

import java.io.IOException;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Mike
 */
public class PaneNavigator {
    
    public static final String MAIN    = "main_pane.fxml";
    public static final String EINSTEIN = "einstein_pane.fxml";
    public static final String DISCOVERY = "discovery_pane.fxml";
    public static final String BLACK = "black_holes_pane.fxml";
    
    private static MainController mainController;

public static void setMainController(MainController mainController) {
        PaneNavigator.mainController = mainController;
    }

     public static void loadPane(String fxml) {
        try {
            mainController.setPane(
                FXMLLoader.load(
                    PaneNavigator.class.getResource(
                        fxml
                    )
                )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
