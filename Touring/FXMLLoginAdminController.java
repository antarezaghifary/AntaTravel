/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;

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
public class FXMLLoginAdminController implements Initializable {

    @FXML
    private JFXTextField user1;
     @FXML
    private JFXPasswordField pass1;

    /**
     * Initializes the controller class.
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql = "INSERT INTO `admin`(username,password) VALUES (?,?)";
    PreparedStatement ps;
    String pass = null, user = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    koneksi DB = new koneksi();
    DB.config();
    con = DB.con;
    stat = DB.stm;
    }    
    @FXML
    private void daftar(ActionEvent event)throws SQLException, IOException {
        user = user1.getText();
        pass = pass1.getText();
        if(user == null){
            JOptionPane.showMessageDialog(null, "Masukkan user");
        }
    /*    else if(user == null){
            JOptionPane.showMessageDialog(null, "Masukkan username");
    }
        else if(pass == null){
            JOptionPane.showMessageDialog(null, "Masukkan Password");
        }*/
        else{
             try {
    ps = con.prepareStatement(sql);
    ps.setString(1, user1.getText());
    ps.setString(2, pass1.getText());
    ps.executeUpdate();
    System.out.println(user1.getText());
    JOptionPane.showMessageDialog(null, "Sign Up Berhasil");
    ((Node)(event.getSource())).getScene().getWindow().hide();
     FXMLLoader fxmlLoader = new FXMLLoader();
     fxmlLoader.setLocation(getClass().getResource("FXMLLoginAdmin.fxml"));
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
    private void masuk(ActionEvent event) throws SQLException {
        
         String username=user1.getText();
        String password=pass1.getText();
        try {
            sql = "SELECT * FROM admin WHERE username='"+user1.getText()+"' AND password='"+pass1.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(user1.getText().equals(rs.getString("username")) && pass1.getText().equals(rs.getString("password"))){
                    JOptionPane.showMessageDialog(null, "berhasil login");
                     ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLPelanggan.fxml"));
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
            fxmlLoader.setLocation(getClass().getResource("FXMLLoginAdmin.fxml"));
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
    void back(ActionEvent event) throws IOException{
       // tampilUser.setText(username);
       // tampilPass.setText(password);
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
