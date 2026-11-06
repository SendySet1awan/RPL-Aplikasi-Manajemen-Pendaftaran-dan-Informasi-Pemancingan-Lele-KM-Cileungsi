package com.mycompany.pemancingan;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;

public class FormPemancing extends JFrame {
    public static ArrayList<Integer> no_kursi = new ArrayList<>();
    public static ArrayList<String> data_lomba = new ArrayList<>(), listAduan = new ArrayList<>();
    
    JTextField txtNama = new JTextField(), txtKeluhan = new JTextField();
    JComboBox<String> cmbMetode = new JComboBox<>(new String[]{"Tunai", "Transfer/QRIS"});
    JTextArea txtAreaInfo = new JTextArea();

    public FormPemancing() {
        if (no_kursi.isEmpty()) for (int i = 1; i <= 60; i++) no_kursi.add(i);
        setTitle("Menu Pemancing"); setSize(500, 580); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); setLocationRelativeTo(null); setLayout(null);

        // Perbaikan baris 20 (Nama Pemancing)
        add(lbl("Nama Pemancing:", 30, 65)); 
        add(txtNama); 
        txtNama.setBounds(160, 65, 180, 25);
        
        JButton b1 = btn("Daftar Acak", 350, 65, 110, 25);
        b1.addActionListener(e -> {
            String nama = txtNama.getText().trim();
            if (nama.isEmpty()) { JOptionPane.showMessageDialog(null, "Nama kosong!"); return; }
            if (no_kursi.isEmpty()) { JOptionPane.showMessageDialog(null, "Lapak penuh (Max 60)!"); return; }
            Collections.shuffle(no_kursi); int lapak = no_kursi.remove(0);
            data_lomba.add("Nama: " + nama + " | Lapak No: " + lapak + " | Status: Belum Bayar");
            txtAreaInfo.append("Sukses! " + nama + " dapat Lapak No: " + lapak + "\n");
            txtNama.setText("");
        });

       // Perbaikan baris 32 (Metode Bayar)
        add(lbl("Metode Bayar:", 30, 110)); 
        add(cmbMetode); 
        cmbMetode.setBounds(160, 110, 180, 25);

        JButton b2 = btn("Bayar Tiket", 350, 110, 110, 25);
        b2.addActionListener(e -> {
            String cari = txtNama.getText().trim();
            if (cari.isEmpty()) { JOptionPane.showMessageDialog(null, "Masukkan nama!"); return; }
            for (int i = 0; i < data_lomba.size(); i++) {
                if (data_lomba.get(i).contains(cari)) {
                    String metode = cmbMetode.getSelectedItem().toString();
                    String stat = metode.equals("Tunai") ? "Belum Lunas (Tunai)" : "Menunggu Verifikasi (QRIS)";
                    if (metode.equals("Transfer/QRIS") && new File("qris.png").exists()) {
                        JOptionPane.showMessageDialog(null, "Scan QRIS untuk " + cari, "QRIS", 1, new ImageIcon("qris.png"));
                    }
                    data_lomba.set(i, "Nama: " + cari + " | " + data_lomba.get(i).replaceAll(".*(Lapak No: \\d+).*", "$1") + " | Status: " + stat);
                    txtAreaInfo.append("Update Bayar (" + metode + ") untuk " + cari + "\n");
                    txtNama.setText(""); return;
                }
            }
            JOptionPane.showMessageDialog(null, "Nama tidak ditemukan, klik Daftar Acak dulu!");
        });

        // Perbaikan baris 53 (Isi Keluhan)
        add(lbl("Isi Keluhan:", 30, 155)); 
        add(txtKeluhan); 
        txtKeluhan.setBounds(160, 155, 180, 25);
        
        JButton b3 = btn("Kirim Aduan", 350, 155, 110, 25);
        b3.addActionListener(e -> {
            String k = txtKeluhan.getText().trim();
            if (!k.isEmpty()) { listAduan.add("Keluhan: " + k); txtAreaInfo.append("Aduan terkirim!\n"); txtKeluhan.setText(""); }
        });

        txtAreaInfo.setEditable(false);
        
        // Perbaikan baris 60 (ScrollPane Text Info)
        JScrollPane sp = new JScrollPane(txtAreaInfo);
        add(sp); 
        sp.setBounds(30, 205, 430, 235);        
        JButton bKembali = btn("Kembali", 160, 460, 180, 30);
        bKembali.addActionListener(e -> { new FormLogin().setVisible(true); dispose(); });
    }
    private JLabel lbl(String s, int x, int y) { JLabel l = new JLabel(s); l.setBounds(x, y, 120, 25); add(l); return l; }
    private JButton btn(String s, int x, int y, int w, int h) { JButton b = new JButton(s); b.setBounds(x, y, w, h); b.setFocusPainted(false); add(b); return b; }
}