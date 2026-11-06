package com.mycompany.pemancingan;
import javax.swing.*;

public class FormAdmin extends JFrame {
    JTextArea txtAreaAdmin = new JTextArea();

    public FormAdmin() {
        setTitle("Menu Admin"); setSize(500, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); setLocationRelativeTo(null); setLayout(null);

        JLabel lbl = new JLabel("DASHBOARD ADMIN", SwingConstants.CENTER);
        lbl.setBounds(50, 20, 400, 25); add(lbl);

        JButton btnP = new JButton("Data Peserta Mancing");
        btnP.setBounds(40, 60, 190, 30); add(btnP);
        btnP.addActionListener(e -> {
            txtAreaAdmin.setText("=== DAFTAR PESERTA ===\n");
            if (FormPemancing.data_lomba.isEmpty()) txtAreaAdmin.append("Belum ada peserta.\n");
            else for (String s : FormPemancing.data_lomba) txtAreaAdmin.append(s + "\n");
        });

        JButton btnA = new JButton("Data Aduan/Keluhan");
        btnA.setBounds(250, 60, 190, 30); add(btnA);
        btnA.addActionListener(e -> {
            txtAreaAdmin.setText("=== DAFTAR ADUAN ===\n");
            if (FormPemancing.listAduan.isEmpty()) txtAreaAdmin.append("Belum ada aduan.\n");
            else for (String s : FormPemancing.listAduan) txtAreaAdmin.append(s + "\n");
        });

        txtAreaAdmin.setEditable(false);
        add(new JScrollPane(txtAreaAdmin)).setBounds(40, 110, 400, 230);

        JButton btnK = new JButton("Kembali ke Login");
        btnK.setBounds(160, 360, 180, 30); add(btnK);
        btnK.addActionListener(e -> { new FormLogin().setVisible(true); dispose(); });
    }
}