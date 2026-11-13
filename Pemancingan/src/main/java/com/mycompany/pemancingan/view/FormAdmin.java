package com.mycompany.pemancingan.view;

import com.mycompany.pemancingan.model.Aduan;
import com.mycompany.pemancingan.model.Peserta;
import javax.swing.*;
import java.util.List;

public class FormAdmin extends JFrame {
    JTextArea txtAreaAdmin = new JTextArea();

    public FormAdmin() {
        setTitle("Menu Admin");
        setSize(500, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbl = new JLabel("DASHBOARD ADMIN", SwingConstants.CENTER);
        lbl.setBounds(50, 20, 400, 25);
        add(lbl);

        JButton btnP = new JButton("Data Peserta Mancing");
        btnP.setBounds(40, 60, 190, 30);
        add(btnP);
        btnP.addActionListener(e -> {
            txtAreaAdmin.setText("=== DAFTAR PESERTA (DATABASE) ===\n\n");
            try {
                List<Peserta> listPeserta = FormLogin.service.ambilSemuaPeserta();
                if (listPeserta.isEmpty()) {
                    txtAreaAdmin.append("Belum ada peserta yang mendaftar.\n");
                } else {
                    for (Peserta p : listPeserta) {
                        txtAreaAdmin.append("ID: " + p.getId() +
                                " | Nama: " + p.getNama() +
                                " | Lapak: " + p.getNomorLapak() +
                                " | Status: " + p.getStatusBayar() + "\n");
                    }
                }
            } catch (Exception ex) {
                txtAreaAdmin.append("Gagal memuat data peserta: " + ex.getMessage());
            }
        });

        JButton btnA = new JButton("Data Aduan/Keluhan");
        btnA.setBounds(250, 60, 190, 30);
        add(btnA);
        btnA.addActionListener(e -> {
            txtAreaAdmin.setText("=== DAFTAR ADUAN (DATABASE) ===\n\n");
            try {
                List<Aduan> listAduan = FormLogin.service.ambilSemuaAduan();
                if (listAduan.isEmpty()) {
                    txtAreaAdmin.append("Belum ada aduan masuk.\n");
                } else {
                    for (Aduan a : listAduan) {
                        txtAreaAdmin.append("ID: " + a.getId() +
                                " | Keluhan: " + a.getIsiKeluhan() +
                                " | Status: " + a.getStatusAduan() + "\n");
                    }
                }
            } catch (Exception ex) {
                txtAreaAdmin.append("Gagal memuat data aduan: " + ex.getMessage());
            }
        });

        txtAreaAdmin.setEditable(false);
        add(new JScrollPane(txtAreaAdmin)).setBounds(40, 110, 400, 230);

        JButton btnK = new JButton("Kembali ke Login");
        btnK.setBounds(160, 360, 180, 30);
        add(btnK);
        btnK.addActionListener(e -> {
            new FormLogin().setVisible(true);
            dispose();
        });
    }
}