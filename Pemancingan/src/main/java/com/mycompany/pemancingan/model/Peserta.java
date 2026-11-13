package com.mycompany.pemancingan.model;

import javax.persistence.*;

@Entity
@Table(name = "peserta")
public class Peserta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nama;

    @Column(name = "nomor_lapak", nullable = false)
    private int nomorLapak;

    @Column(name = "metode_bayar")
    private String metodeBayar;

    @Column(name = "status_bayar")
    private String statusBayar;

    // Getter & Setter
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