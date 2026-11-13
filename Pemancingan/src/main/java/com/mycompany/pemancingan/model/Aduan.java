package com.mycompany.pemancingan.model;

import javax.persistence.*;

@Entity
@Table(name = "aduan")
public class Aduan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "isi_keluhan", nullable = false, columnDefinition = "TEXT")
    private String isiKeluhan;

    @Column(name = "status_aduan")
    private String statusAduan = "Menunggu";

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getIsiKeluhan() { return isiKeluhan; }
    public void setIsiKeluhan(String isiKeluhan) { this.isiKeluhan = isiKeluhan; }
    public String getStatusAduan() { return statusAduan; }
    public void setStatusAduan(String statusAduan) { this.statusAduan = statusAduan; }
}