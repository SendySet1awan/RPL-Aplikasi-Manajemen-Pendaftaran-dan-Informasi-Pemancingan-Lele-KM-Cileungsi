package com.mycompany.pemancingan.model;

import javax.persistence.*;

@Entity
@Table(name = "peserta")
public class Peserta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nama;
    private int nomorLapak;
    private String metodeBayar;
    private String statusBayar;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public int getNomorLapak() { return nomorLapak; }
    public void setNomorLapak(int nomorLapak) { this.nomorLapak = nomorLapak; }
    public String getMetodeBayar() { return metodeBayar; }
    public void setMetodeBayar(String metodeBayar) { this.metodeBayar = metodeBayar; }
    public String getStatusBayar() { return statusBayar; }
    public void setStatusBayar(String statusBayar) { this.statusBayar = statusBayar; }
}