/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 * FXML Controller class
 *
 * @author Skaha_AM
 */
public class FXMLBuatakun implements Initializable {

    @FXML
    private JFXTextField nama1;
    @FXML
    private JFXTextField username1;
    @FXML
    private JFXButton id_create;
    @FXML
    private JFXButton id_back;
    @FXML
    private JFXPasswordField password1;

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql = "INSERT INTO `pelanggan`(nama,username,password) VALUES (?,?,?)";
    PreparedStatement ps;
    String nama = null, pass = null, user = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
    
    koneksi DB = new koneksi();
    DB.config();
    con = DB.con;
    stat = DB.stm;
    }    
    @FXML
    private void create(ActionEvent event) throws SQLException, IOException {
        nama = nama1.getText();
        user = username1.getText();
        pass = password1.getText();
        if(nama == null){
            JOptionPane.showMessageDialog(null, "Masukkan nama");
        }
      /*  else if(user == null){
            JOptionPane.showMessageDialog(null, "Masukkan username");
    }
        else if(pass == null){
            JOptionPane.showMessageDialog(null, "Masukkan Password");
        }*/
        else{
             try {
    ps = con.prepareStatement(sql);
    ps.setString(1, nama1.getText());
    ps.setString(2, username1.getText());
    ps.setString(3, password1.getText());
    ps.executeUpdate();
    System.out.println(nama1.getText());
    JOptionPane.showMessageDialog(null, "Sign Up Berhasil");
    ((Node)(event.getSource())).getScene().getWindow().hide();
     FXMLLoader fxmlLoader = new FXMLLoader();
     fxmlLoader.setLocation(getClass().getResource("FXMLLogin.fxml"));
     Scene scene = new Scene(fxmlLoader.load());
      Stage stage = new Stage();
      stage.setScene(scene);
      stage.setTitle("Touring");
      stage.show();
    }catch (IOException a) {
            System.out.println("Failed to create new Window." + a);
        }
    }
    }
     @FXML
    private void back(ActionEvent event) {
         try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLLogin.fxml"));
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
