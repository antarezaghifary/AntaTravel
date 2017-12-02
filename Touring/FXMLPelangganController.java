/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.delete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static jdk.nashorn.internal.runtime.Debug.id;
import koneksi.koneksi;

/**
 * FXML Controller class
 *
 * @author Skaha_AM
 */
public class FXMLPelangganController implements Initializable {
    @FXML
    private JFXButton id_awal;
    @FXML
    private JFXButton id_logout;
    @FXML
    private TableColumn<TabelPelanggan, String> nama;
    @FXML
    private TableColumn<TabelPelanggan, String> username;
    @FXML
    private TableColumn<TabelPelanggan, String> password;
    
    private ObservableList<TabelPelanggan> data1;
    @FXML
    private TableView <TabelPelanggan>TabelPelanggan;
    private String nama1;
    private String username1;
    private String password1;
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
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
    private void update(ActionEvent event) {
        try {
            data1 = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            rs = stat.executeQuery("SELECT `nama`,`username`,`password` FROM `pelanggan`");
            while (rs.next()) {
                //get string from db,whichever way 
                data1.add(new TabelPelanggan(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        nama.setCellValueFactory(new PropertyValueFactory<>("nama1"));
        username.setCellValueFactory(new PropertyValueFactory<>("username1"));
        password.setCellValueFactory(new PropertyValueFactory<>("password1"));
        
        TabelPelanggan.setItems(data1);
    }

    @FXML
    private void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Close " + "Program" + " ?", ButtonType.YES, ButtonType.CANCEL);
    alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
    //do stuff
    Stage stage = (Stage) id_logout.getScene().getWindow();
    // do what you have to do
    stage.close();
    } 

    }
    
    @FXML
    private void awal(ActionEvent event) throws SQLException {
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
