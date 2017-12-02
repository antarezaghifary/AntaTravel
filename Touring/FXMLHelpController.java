/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLHelpController {

    @FXML
    private JFXButton id_back1;

    @FXML
    void back1(ActionEvent event) {
         try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLMain.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Touring");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }

}
   
