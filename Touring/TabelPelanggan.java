/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;
/**
 *
 * @author Skaha_AM
 */
public class TabelPelanggan {
    private final StringProperty nama1; 
    private final StringProperty username1;
    private final StringProperty password1;
    
    public TabelPelanggan(String nama1, String username1, String password1){
        this.nama1 = new SimpleStringProperty(nama1);
        this.username1= new SimpleStringProperty(username1);
        this.password1 = new SimpleStringProperty(password1);
    }
      //Getters
    public String getnama1() {
        return nama1.get();
    }
    public String getusername1() {
        return username1.get();
    }
    public String getpassword1() {
        return password1.get();
    }
     //Setters

    public void setnama1(String value) {
        nama1.set(value);
    }
    public void setusername1(String value) {
        username1.set(value);
    }
    public void setpassword1(String value) {
        password1.set(value);
    }
    //Property values

    public StringProperty nama1Property() {
        return nama1;
    }
     public StringProperty username1Property() {
        return username1;
    }
      public StringProperty password1Property() {
        return password1;
    }
}

