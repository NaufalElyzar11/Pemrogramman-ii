package soal2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class Negara {
    private String nama;
    private String jenisKepemimpinan;
    private String namaPemimpin;
    private int tanggalKemerdekaan;
    private int bulanKemerdekaan;
    private int tahunKemerdekaan;

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan) {
        this.nama = nama;
        this.jenisKepemimpinan = jenisKepemimpinan;
        this.namaPemimpin = namaPemimpin;
        this.tanggalKemerdekaan = tanggalKemerdekaan;
        this.bulanKemerdekaan = bulanKemerdekaan;
        this.tahunKemerdekaan = tahunKemerdekaan;
    }

    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin) {
        this(nama, jenisKepemimpinan, namaPemimpin, -1, -1, -1);
    }

    public void tampilkanDetail(HashMap<Integer, String> bulanMap) {
        System.out.print("Negara " + nama + " mempunyai ");
        if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
            System.out.println("Raja bernama " + namaPemimpin + "\n");
        } else {
            System.out.println(jenisKepemimpinan.substring(0, 1).toUpperCase() + jenisKepemimpinan.substring(1).toLowerCase() + " bernama " + namaPemimpin);
            System.out.println("Deklarasi Kemerdekaan pada Tanggal " + tanggalKemerdekaan + " " + bulanMap.get(bulanKemerdekaan) + " " + tahunKemerdekaan + "\n");
        }
    }
}

public class code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Integer, String> bulanMap = new HashMap<>();
        bulanMap.put(1, "Januari");
        bulanMap.put(2, "Februari");
        bulanMap.put(3, "Maret");
        bulanMap.put(4, "April");
        bulanMap.put(5, "Mei");
        bulanMap.put(6, "Juni");
        bulanMap.put(7, "Juli");
        bulanMap.put(8, "Agustus");
        bulanMap.put(9, "September");
        bulanMap.put(10, "Oktober");
        bulanMap.put(11, "November");
        bulanMap.put(12, "Desember");

        int jumlahNegara = Integer.parseInt(scanner.nextLine());

        LinkedList<Negara> negaraList = new LinkedList<>();

        for (int i = 0; i < jumlahNegara; i++) {
            String nama = scanner.nextLine();
            String jenisKepemimpinan = scanner.nextLine();
            String namaPemimpin = scanner.nextLine();

            if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
                negaraList.add(new Negara(nama, jenisKepemimpinan, namaPemimpin));
            } else {
                int tanggalKemerdekaan = Integer.parseInt(scanner.nextLine());
                int bulanKemerdekaan = Integer.parseInt(scanner.nextLine());
                int tahunKemerdekaan = Integer.parseInt(scanner.nextLine());
                negaraList.add(new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggalKemerdekaan, bulanKemerdekaan, tahunKemerdekaan));
            }
        }

        for (Negara negara : negaraList) {
            negara.tampilkanDetail(bulanMap);
        }

        scanner.close();
    }
}

