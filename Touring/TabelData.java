/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Touring;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Skaha_AM
 */
public class TabelData {
    private final StringProperty nama; 
    private final StringProperty alamat;
    private final StringProperty tujuan;
    private final StringProperty tgl;
    private final StringProperty tlp;
    private final StringProperty paket;
    private final StringProperty jam;
    private final StringProperty harga;
    private final StringProperty kendaraan;
    private final StringProperty kembalian;
    
     public TabelData(String nama, String harga , String alamat , String tujuan , String tgl,String tlp,String paket, String jam, String kendaraan,String kembalian) {
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.tujuan = new SimpleStringProperty(tujuan);
        this.tgl = new SimpleStringProperty(tgl);
        this.tlp = new SimpleStringProperty(tlp);
        this.paket = new SimpleStringProperty(paket);
        this.jam = new SimpleStringProperty(jam);
        this.harga = new SimpleStringProperty(harga);
        this.kendaraan = new SimpleStringProperty(kendaraan);
        this.kembalian = new SimpleStringProperty(kembalian);
    }
      //Getters
    public String getname() {
        return nama.get();
    }
    public String getalamat() {
        return alamat.get();
    }
    public String gettujuan() {
        return tujuan.get();
    }
    public String gettgl() {
        return tgl.get();
    }
    public String gettlp() {
        return tlp.get();
    }
    public String getpaket() {
        return paket.get();
    }
    public String getjam() {
        return jam.get();
    }
    public String getharga() {
        return harga.get();
    }
    public String getkendaraan() {
        return kendaraan.get();
    }
    public String getkembalian() {
        return kembalian.get();
    }
    
    //Setters
    public void setnama(String value) {
        nama.set(value);
    }
    public void setalamat(String value) {
        alamat.set(value);
    }
    public void settujuan(String value) {
        tujuan.set(value);
    }
    public void settgl(String value) {
        tgl.set(value);
    }
    public void settlp(String value) {
        tlp.set(value);
    }
    public void setpaket(String value) {
        paket.set(value);
    }
    public void setjam(String value) {
        jam.set(value);
    }
    public void setharga(String value) {
        harga.set(value);
    }
    public void setkendaraan(String value) {
        kendaraan.set(value);
    }
    public void setkembalian(String value) {
        kembalian.set(value);
    }
    //Property values
    public StringProperty namaProperty() {
        return nama;
    }
     public StringProperty alamatProperty() {
        return alamat;
    }
      public StringProperty tujuanProperty() {
        return tujuan;
    }
       public StringProperty tglProperty() {
        return tgl;
    }
        public StringProperty tlpProperty() {
        return tlp;
    }
         public StringProperty paketProperty() {
        return paket;
    }
          public StringProperty jamProperty() {
        return jam;
    }
           public StringProperty hargaProperty() {
        return harga;
    }
            public StringProperty kendaraanProperty() {
        return kendaraan;
    }
             public StringProperty kembalianProperty() {
        return kembalian;
    }
}
