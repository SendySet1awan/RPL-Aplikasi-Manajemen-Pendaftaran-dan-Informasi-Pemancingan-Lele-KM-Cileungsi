package com.mycompany.act1;

import java.util.*;

public class act1 {
    static Scanner in = new Scanner(System.in);
    static ArrayList<Integer> no_kursi = new ArrayList<>();
    static ArrayList<String> data_lomba = new ArrayList<>();
    static ArrayList<String> listAduan = new ArrayList<>();

    public static void main(String[] args) {
        // Inisialisasi 10 lapak (bisa diubah sesuai kebutuhan)
        for (int i = 1; i <= 10; i++) {
            no_kursi.add(i);
        }

        int pil;
        do {
            System.out.println("\n--- PEMANCINGAN LELE KM CILEUNGSI ---");
            System.out.println("1. Daftar Lapak Acak");
            System.out.println("2. Komplain Fasilitas");
            System.out.println("3. Cek Semua Data");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            pil = in.nextInt();
            in.nextLine(); 

            switch (pil) {
                case 1:
                    System.out.print("Masukkan Nama: ");
                    String nama = in.nextLine();
                    if (no_kursi.isEmpty()) {
                        System.out.println("Maaf, lapak sudah penuh!");
                    } else {
                        Collections.shuffle(no_kursi);
                        int lapakDapat = no_kursi.remove(0);
                        data_lomba.add("Nama: " + nama + " | Lapak No: " + lapakDapat);
                        System.out.println("Berhasil! Anda mendapat Lapak Nomor: " + lapakDapat);
                    }
                    break;

                case 2:
                    System.out.print("Nomor Lapak: ");
                    String lapak = in.nextLine();
                    System.out.print("Keluhan Kerusakan: ");
                    String keluhan = in.nextLine();
                    listAduan.add("Lapak " + lapak + " - " + keluhan + " [Menunggu]");
                    System.out.println("Laporan berhasil dikirim!");
                    break;

                case 3:
                    System.out.println("\n=== DATA PESERTA ===");
                    if (data_lomba.isEmpty()) System.out.println("Belum ada data.");
                    for (String p : data_lomba) System.out.println("- " + p);

                    System.out.println("\n=== DATA PENGADUAN ===");
                    if (listAduan.isEmpty()) System.out.println("Belum ada pengaduan.");
                    for (String a : listAduan) System.out.println("- " + a);
                    break;

                case 4:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pil != 4);
    }
}