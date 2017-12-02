/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author Skaha_AM
 */
public class FXMLLoginController implements Initializable {

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    @FXML
    private Pane close;
    @FXML
    private JFXPasswordField id_pass;
    @FXML
    private JFXTextField id_user;
    @FXML
    private JFXButton id_sign;
    @FXML
    private JFXButton id_create;
    @FXML
    private FontAwesomeIconView CLOSE;

      @FXML
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
    }    

    @FXML
    private void sign(ActionEvent event) throws SQLException {
        
        String username=id_user.getText();
        String password=id_pass.getText();
        try {
            sql = "SELECT * FROM pelanggan WHERE username='"+id_user.getText()+"' AND password='"+id_pass.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(id_user.getText().equals(rs.getString("username")) && id_pass.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "berhasil login");
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
                }
            }else
            {
                    JOptionPane.showMessageDialog(null, "username atau password salah");
            
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
            }
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    
/*        if(username.equalsIgnoreCase("tomboluwe") && password.equalsIgnoreCase("mangan")){
            Parent Home = FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
            Scene homescene = new Scene(Home);
            Stage on = (Stage)((Node)event.getSource()).getScene().getWindow();
            on.setScene(homescene);
            on.show();
        }*/
    }
    @FXML
    private void create(ActionEvent event) throws IOException{
       // tampilUser.setText(username);
       // tampilPass.setText(password);
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLBuatakun.fxml"));
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
        @FXML
    void tutup(MouseEvent event) {
        System.exit(0);
    }
    
    @FXML
    void admin(ActionEvent event) throws IOException{
       // tampilUser.setText(username);
       // tampilPass.setText(password);
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLLoginAdmin.fxml"));
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
    
    