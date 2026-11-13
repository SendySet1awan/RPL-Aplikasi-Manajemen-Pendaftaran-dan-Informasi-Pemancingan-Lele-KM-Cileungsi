package com.mycompany.pemancingan.service;

import com.mycompany.pemancingan.dao.PemancinganDAO;
import com.mycompany.pemancingan.model.Aduan;
import com.mycompany.pemancingan.model.Peserta;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PemancinganService {
    private PemancinganDAO pemancinganDAO;

    public void setPemancinganDAO(PemancinganDAO pemancinganDAO) {
        this.pemancinganDAO = pemancinganDAO;
    }

    public void daftarPeserta(String nama, int nomorLapak, String metodeBayar, String statusBayar) {
        Peserta peserta = new Peserta();
        peserta.setNama(nama);
        peserta.setNomorLapak(nomorLapak);
        peserta.setMetodeBayar(metodeBayar);
        peserta.setStatusBayar(statusBayar);
        pemancinganDAO.savePeserta(peserta);
    }

    public List<Peserta> ambilSemuaPeserta() {
        return pemancinganDAO.getAllPeserta();
    }

    public void kirimAduan(String isiKeluhan) {
        Aduan aduan = new Aduan();
        aduan.setIsiKeluhan(isiKeluhan);
        aduan.setStatusAduan("Menunggu");
        pemancinganDAO.saveAduan(aduan);
    }

    public List<Aduan> ambilSemuaAduan() {
        return pemancinganDAO.getAllAduan();
    }
}