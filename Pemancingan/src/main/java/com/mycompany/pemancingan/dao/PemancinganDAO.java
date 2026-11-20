package com.mycompany.pemancingan.dao;

import com.mycompany.pemancingan.model.Aduan;
import com.mycompany.pemancingan.model.Peserta;
import java.util.List;
import org.hibernate.SessionFactory;

public class PemancinganDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void savePeserta(Peserta peserta) {
        sessionFactory.getCurrentSession().save(peserta);
    }

    public List<Peserta> getAllPeserta() {
        return sessionFactory.getCurrentSession().createQuery("FROM Peserta", Peserta.class).list();
    }

    public void saveAduan(Aduan aduan) {
        sessionFactory.getCurrentSession().save(aduan);
    }

    public List<Aduan> getAllAduan() {
        return sessionFactory.getCurrentSession().createQuery("FROM Aduan", Aduan.class).list();
    }
}