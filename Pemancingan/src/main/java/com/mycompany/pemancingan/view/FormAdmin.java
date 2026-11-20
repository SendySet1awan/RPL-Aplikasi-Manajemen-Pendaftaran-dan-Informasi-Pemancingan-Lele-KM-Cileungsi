package com.mycompany.pemancingan.view;

import com.mycompany.pemancingan.model.Aduan;
import com.mycompany.pemancingan.model.Peserta;
import com.mycompany.pemancingan.service.PemancinganService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FormAdmin extends JFrame {
    private static final Logger logger = Logger.getLogger(FormAdmin.class.getName());

    private ClassPathXmlApplicationContext context;
    private PemancinganService pemancinganService;
    private JTextArea txtAreaAdmin = new JTextArea();

    public FormAdmin() {
        setTitle("Menu Admin");
        setSize(500, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Spring merakit semua bean (DAO, Service, SessionFactory) di sini
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        pemancinganService = context.getBean("pemancinganService", PemancinganService.class);

        // Tutup container Spring saat jendela ditutup
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (context != null) {
                    context.close();
                }
            }
        });

        JLabel lbl = new JLabel("DASHBOARD ADMIN", SwingConstants.CENTER);
        lbl.setBounds(50, 20, 400, 25);
        add(lbl);

        JButton btnP = new JButton("Data Peserta Mancing");
        btnP.setBounds(40, 60, 190, 30);
        add(btnP);
        btnP.addActionListener(e -> {
            txtAreaAdmin.setText("=== DAFTAR PESERTA ===\n\n");
            List<Peserta> list = pemancinganService.ambilSemuaPeserta();
            for (Peserta p : list) {
                txtAreaAdmin.append("ID: " + p.getId() + " | Nama: " + p.getNama() + " | Lapak: " + p.getNomorLapak() + "\n");
            }
        });

        JButton btnA = new JButton("Data Aduan/Keluhan");
        btnA.setBounds(250, 60, 190, 30);
        add(btnA);
        btnA.addActionListener(e -> {
            txtAreaAdmin.setText("=== DAFTAR ADUAN ===\n\n");
            List<Aduan> list = pemancinganService.ambilSemuaAduan();
            for (Aduan a : list) {
                txtAreaAdmin.append("ID: " + a.getId() + " | Keluhan: " + a.getIsiKeluhan() + "\n");
            }
        });

        txtAreaAdmin.setEditable(false);
        add(new JScrollPane(txtAreaAdmin)).setBounds(40, 110, 400, 220);

        // Button Cetak
        JButton btnCetak = new JButton("Cetak");
        btnCetak.setBounds(40, 350, 185, 35);
        add(btnCetak);

        btnCetak.addActionListener(e -> {
            try {
                // Lokasi file .jrxml di JaspersoftWorkspace
                String reportPath = "C:/Users/LENOVO/JaspersoftWorkspace/pemancingan/Simple_Blue.jrxml";

                // Compile file .jrxml terlebih dahulu
                JasperReport jr = JasperCompileManager.compileReport(reportPath);

                // Koneksi database dari Spring DataSource
                DataSource ds = context.getBean(DataSource.class);
                try (Connection conn = ds.getConnection()) {

                    // Parameter (kosongkan jika tidak ada)
                    Map<String, Object> param = new HashMap<>();

                    // Isi laporan (masukkan objek 'jr', bukan String path)
                    JasperPrint jp = JasperFillManager.fillReport(jr, param, conn);

                    // Tampilkan laporan
                    JasperViewer.viewReport(jp, false);
                }
            } catch (Exception ex) {
                logger.severe("Gagal mencetak laporan: " + ex.getMessage());
                JOptionPane.showMessageDialog(this,
                        "Gagal mencetak laporan: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        JButton btnK = new JButton("Kembali ke Login");
        btnK.setBounds(255, 350, 185, 35);
        add(btnK);
        btnK.addActionListener(e -> {
            new FormLogin().setVisible(true);
            dispose();
        });
    }
}