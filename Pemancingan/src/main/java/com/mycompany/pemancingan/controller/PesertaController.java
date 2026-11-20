package com.mycompany.pemancingan.controller;

import com.mycompany.pemancingan.model.Peserta;
import com.mycompany.pemancingan.model.Aduan;
import com.mycompany.pemancingan.util.hibernateutil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PesertaController {
    public void simpanPeserta(String nama, int nomorLapak, String metodeBayar, String statusBayar) {
        Transaction tx = null;
        try (Session session = hibernateutil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Peserta peserta = new Peserta();
            peserta.setNama(nama);
            peserta.setNomorLapak(nomorLapak);
            peserta.setMetodeBayar(metodeBayar);
            peserta.setStatusBayar(statusBayar);
            session.save(peserta);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void simpanAduan(String isiKeluhan) {
        Transaction tx = null;
        try (Session session = hibernateutil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Aduan aduan = new Aduan();
            aduan.setIsiKeluhan(isiKeluhan);
            aduan.setStatusAduan("Menunggu");
            session.save(aduan);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}