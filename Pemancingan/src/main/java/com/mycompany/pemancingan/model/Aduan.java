package com.mycompany.pemancingan.model;

import javax.persistence.*;

@Entity
@Table(name = "aduan")
public class Aduan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isiKeluhan;
    private String statusAduan;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getIsiKeluhan() { return isiKeluhan; }
    public void setIsiKeluhan(String isiKeluhan) { this.isiKeluhan = isiKeluhan; }
    public String getStatusAduan() { return statusAduan; }
    public void setStatusAduan(String statusAduan) { this.statusAduan = statusAduan; }
}