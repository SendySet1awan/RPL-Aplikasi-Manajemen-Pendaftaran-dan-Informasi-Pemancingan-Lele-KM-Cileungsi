package com.mycompany.pemancingan.dao;

import com.mycompany.pemancingan.model.Aduan;
import com.mycompany.pemancingan.model.Peserta;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PemancinganDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void savePeserta(Peserta peserta) {
        getCurrentSession().save(peserta);
    }

    public List<Peserta> getAllPeserta() {
        return getCurrentSession().createQuery("FROM Peserta", Peserta.class).list();
    }

    public void saveAduan(Aduan aduan) {
        getCurrentSession().save(aduan);
    }

    public List<Aduan> getAllAduan() {
        return getCurrentSession().createQuery("FROM Aduan", Aduan.class).list();
    }
}