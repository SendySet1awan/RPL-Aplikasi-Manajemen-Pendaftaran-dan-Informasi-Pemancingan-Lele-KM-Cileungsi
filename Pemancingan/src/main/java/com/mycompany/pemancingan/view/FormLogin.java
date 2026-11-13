package com.mycompany.pemancingan.view;

import com.mycompany.pemancingan.service.PemancinganService;
import javax.swing.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FormLogin extends JFrame {
    public static PemancinganService service;

    public FormLogin() {
        setTitle("Login - Pemancingan Lele KM Cileungsi");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lbl = new JLabel("APLIKASI PEMANCINGAN KM", SwingConstants.CENTER);
        lbl.setBounds(50, 30, 300, 30);
        add(lbl);

        JButton btnP = new JButton("Login Pemancing");
        btnP.setBounds(100, 90, 200, 40);
        add(btnP);
        btnP.addActionListener(e -> {
            new FormPemancing().setVisible(true);
            dispose();
        });

        JButton btnA = new JButton("Login Admin");
        btnA.setBounds(100, 150, 200, 40);
        add(btnA);
        btnA.addActionListener(e -> {
            new FormAdmin().setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = (PemancinganService) context.getBean("pemancinganService");

        java.awt.EventQueue.invokeLater(() -> {
            new FormLogin().setVisible(true);
        });
    }
}