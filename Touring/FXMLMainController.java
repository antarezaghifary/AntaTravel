/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import koneksi.koneksi;

/**
 * FXML Controller class
 *
 * @author Skaha_AM
 */
public class FXMLMainController implements Initializable {
@FXML
    private JFXTextArea nama2;

    @FXML
    private JFXTextArea alamat;

    @FXML
    private JFXTextArea umur;

    @FXML
    private JFXDatePicker tgl;

    @FXML
    private RadioButton id_lk;

    @FXML
    private ToggleGroup huwa;

    @FXML
    private RadioButton id_pr;

    @FXML
    private JFXComboBox paket;

    @FXML
    private JFXButton id_book;

    @FXML
    private JFXButton id_help;

    @FXML
    private JFXTextField tlp;

    @FXML
    private JFXTextField uang;

    @FXML
    private JFXComboBox harga;

    @FXML
    private JFXComboBox kendaraan;

    @FXML
    private JFXComboBox tujuan;
    
     @FXML
    private CheckBox j1;

    @FXML
    private CheckBox j2;

    @FXML
    private CheckBox j3;
    
     @FXML
    private JFXButton id_lihat;

    @FXML
    private CheckBox j4;
     Connection con;
    Statement stat;
    ResultSet rs;
     String sql = "INSERT INTO `penumpang`(`nama`, `harga`, `alamat`, `tlp`, `umur`, `jenis_kel`, `tujuan`, "
             + "`tgl_pesan`, `paket`, `jam`, `kendaraan`, `uang`, `kembali`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement ps;
      @FXML
    void booking(ActionEvent event) throws SQLException {
        String jk = null,jam = null;
        int kembali;
        int harga1 = Integer.parseInt((String) harga.getValue());
        String nama = nama2.getText();
        String alamat1= alamat.getText();
        String umur1 = umur.getText();
        String tgl1 = tgl.getValue().toString();
        int uang1 = Integer.parseInt(uang.getText());
        String tlp1 = tlp.getText();
        String tujuan1 = tujuan.getValue().toString();
        String kendaraan1 = kendaraan.getValue().toString();
        if(j1.isSelected()){
            jam = "06.00";
        }
        if(j2.isSelected()){
            jam = "09.00";
        }
        if(j3.isSelected()){
            jam = "12.00";
        }
        if(j4.isSelected()){
            jam = "16.00";
        }
        
        if(id_lk.isSelected()){
            jk ="L";
        }
        else if(id_pr.isSelected()){
            jk ="P";
        }
        String paket1 = paket.getValue().toString();
        kembali=uang1 - harga1;
        
    ps = con.prepareStatement(sql);
    ps.setString(1, nama);
    ps.setInt(2, harga1);
    ps.setString(3, alamat1);
    ps.setString(4, tlp1);
    ps.setString(5, umur1);
    ps.setString(6, jk);
    ps.setString(7, tujuan1);
    ps.setString(8, tgl1);
    ps.setString(9, paket1);
    ps.setString(10, jam);
    ps.setString(11, kendaraan1);
    ps.setInt(12, uang1);
    ps.setInt(13, kembali);
    ps.executeUpdate();
       
       
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Anda sudah terdaftar | Selamat Datang Di ANTA TOUR'S", ButtonType.NEXT);
    alert.showAndWait();

if (alert.getResult() == ButtonType.NEXT) {
    //do stuff
    // Stage stage = (Stage) id_book.getScene().getWindow();
    // do what you have to do
    try 
            {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLOutput.fxml"));
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
    @FXML
    void help(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLHelp.fxml"));
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        paket.getItems().addAll("MorningSlow","AfternoonHot","NightLast");
        tujuan.getItems().addAll("Tulungagung - Malang (Patas)","Tulungagung - Surabaya (Bisnis)","Tulungagung - Yogyakarta (Executive)");
        harga.getItems().addAll("70000","120000","180000");
        kendaraan.getItems().addAll("Avanza","Xenia","Terios","Kijang inova","Panther","Rush");
        nama2.setText("");
        alamat.setText("");
        umur.setText("");
        id_lk.setSelected(false);
        id_pr.setSelected(false);
        j1.isSelected();
        j2.isSelected();
        j3.isSelected();
        j4.isSelected();
        tlp.setText("");
        uang.setText("");
        
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
    }        
    @FXML
    void lihat(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLOutput.fxml"));
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
