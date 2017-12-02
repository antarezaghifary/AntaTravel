/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import koneksi.koneksi;


/**
 * FXML Controller class
 *
 * @author Skaha_AM
 */
public class FXMLOutputController implements Initializable {

    @FXML
    private JFXButton id_print;
    @FXML
    private JFXButton id_update;
    @FXML
    private StackPane stack;
    @FXML
    private TableColumn<TabelData, String> id_penumpang;
    @FXML
    private TableColumn<TabelData, String> nama1;
    @FXML
    private TableColumn<TabelData, String> alamat1;
    @FXML
    private TableColumn<TabelData, String> tujuan1;
    @FXML
    private TableColumn<TabelData, String> tgl1;
    @FXML
    private TableColumn<TabelData, String> tlp1;
    @FXML
    private TableColumn<TabelData, String> paket1;
    @FXML
    private TableColumn<TabelData, String> jam;
    @FXML
    private TableColumn<TabelData, String> harga1;
    @FXML
    private TableColumn<TabelData, String> kendaraan1;
    @FXML
    private TableColumn<TabelData, String> kembali;
    @FXML
    private JFXButton id_exit;
    private ObservableList<TabelData> data;
    @FXML
    private TableView<TabelData> tabel;
    private String nama;
    private String tujuan;
    private String tgl;
    private String paket;
    private String jam1;
    private String kembali1;
    private String dialogH;
    private String dialog;
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
        
    tabel.setOnMousePressed(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event) {
        nama = tabel.getSelectionModel().getSelectedItem().getname();
        tujuan = tabel.getSelectionModel().getSelectedItem().gettujuan();
        tgl = tabel.getSelectionModel().getSelectedItem().gettgl();
        paket =tabel.getSelectionModel().getSelectedItem().getpaket();
        jam1 =tabel.getSelectionModel().getSelectedItem().getjam();
        kembali1 =tabel.getSelectionModel().getSelectedItem().getkembalian();
        dialogH = "Hai, "+nama;
        dialog = "\nJam : "+jam1
        + "\nTujuan : "+tujuan
        + "\nBerangkat Tanggal : "+tgl
        + "\nUang Kembalian : Rp. "+kembali1;
        }
    });  
    }    
        
    @FXML
    private void print(ActionEvent event) {
        
        Dialog("Okay",dialogH,dialog);
    }

    @FXML
    private void update(ActionEvent event) {
        try {
            data = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            rs = stat.executeQuery("SELECT `nama`,`harga`,`alamat`,`tujuan`,`tgl_pesan`,`tlp`,`paket`,`jam`,`kendaraan`,`kembali` FROM `penumpang`");
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new TabelData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
            }

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.
        nama1.setCellValueFactory(new PropertyValueFactory<>("nama"));
        alamat1.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        tujuan1.setCellValueFactory(new PropertyValueFactory<>("tujuan"));
        tgl1.setCellValueFactory(new PropertyValueFactory<>("tgl"));
        tlp1.setCellValueFactory(new PropertyValueFactory<>("tlp"));
        paket1.setCellValueFactory(new PropertyValueFactory<>("paket"));
        jam.setCellValueFactory(new PropertyValueFactory<>("jam"));
        harga1.setCellValueFactory(new PropertyValueFactory<>("harga"));
        kendaraan1.setCellValueFactory(new PropertyValueFactory<>("kendaraan"));
        kembali.setCellValueFactory(new PropertyValueFactory<>("kembalian"));
        
        tabel.setItems(data);
    }

    @FXML
    private void exit(ActionEvent event) {
        // get a handle to the stage
       // String selection = selection.getText();
    Alert alert = new Alert(AlertType.CONFIRMATION, "Close " + "Program" + " ?", ButtonType.YES, ButtonType.CANCEL);
    alert.showAndWait();

if (alert.getResult() == ButtonType.YES) {
    //do stuff
    Stage stage = (Stage) id_exit.getScene().getWindow();
    // do what you have to do
    stage.close();
    } 
}
     public void Dialog(String b,String p){
        stack.setDisable(false);
                JFXDialogLayout content = new JFXDialogLayout();
            content.setHeading(new Text(p));
            JFXDialog dialog = new JFXDialog(stack,content,JFXDialog.DialogTransition.CENTER);
            JFXButton btn = new JFXButton(b); 
            btn.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                dialog.close();
                stack.setDisable(true);
            }
            });
            content.setActions(btn);
            dialog.show();
    }
    public void Dialog(String b,String h,String p){
        stack.setDisable(false);
                JFXDialogLayout content = new JFXDialogLayout();
            content.setHeading(new Text(h));
            content.setBody(new Text(p));
            JFXDialog dialog = new JFXDialog(stack,content,JFXDialog.DialogTransition.CENTER);
            JFXButton btn = new JFXButton(b); 
            btn.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                dialog.close();
                stack.setDisable(true);
            }
            });
            content.setActions(btn);
            dialog.show();
    }
}
    
