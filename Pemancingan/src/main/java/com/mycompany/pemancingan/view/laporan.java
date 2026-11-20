package com.mycompany.pemancingan.view;

import java.awt.Component;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class laporan {

    private static final Logger logger = Logger.getLogger(laporan.class.getName());
    private static final String DEFAULT_REPORT_PATH = "C:/Users/LENOVO/JaspersoftWorkspace/pemancingan/Simple_Blue.jrxml";

    public static void tampilkanLaporanPeserta(Component parent) {
        tampilkanLaporan(parent, DEFAULT_REPORT_PATH, new HashMap<>());
    }

    public static void tampilkanLaporan(Component parent, String reportPath, Map<String, Object> parameters) {
        ClassPathXmlApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            DataSource ds = context.getBean(DataSource.class);

            JasperReport jr = JasperCompileManager.compileReport(reportPath);

            try (Connection conn = ds.getConnection()) {
                Map<String, Object> param = (parameters != null) ? parameters : new HashMap<>();
                JasperPrint jp = JasperFillManager.fillReport(jr, param, conn);
                JasperViewer.viewReport(jp, false);
            }
        } catch (Exception ex) {
            logger.severe("Gagal menampilkan laporan Jasper: " + ex.getMessage());
            JOptionPane.showMessageDialog(
                    parent,
                    "Gagal mencetak laporan: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
        } finally {
            if (context != null) {
                context.close();
            }
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> tampilkanLaporanPeserta(null));
    }
}