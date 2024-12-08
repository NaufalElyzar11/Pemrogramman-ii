package soal3;
import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }
}

public class code3 {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String nim = scanner.nextLine();

                    boolean exists = false;
                    for (Mahasiswa m : mahasiswaList) {
                        if (m.getNim().equals(nim)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Mahasiswa dengan NIM tersebut sudah ada.");
                    } else {
                        mahasiswaList.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa " + nama + " ditambahkan.");
                    }
                    break;

                case 2: 
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String nimHapus = scanner.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < mahasiswaList.size(); i++) {
                        if (mahasiswaList.get(i).getNim().equals(nimHapus)) {
                            mahasiswaList.remove(i);
                            removed = true;
                            System.out.println("Mahasiswa dengan NIM " + nimHapus + " dihapus.");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                    }
                    break;

                case 3: 
                    System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
                    String nimCari = scanner.nextLine();
                    boolean found = false;

                    for (Mahasiswa m : mahasiswaList) {
                        if (m.getNim().equals(nimCari)) {
                            System.out.println("Mahasiswa ditemukan: NIM: " + m.getNim() + ", Nama: " + m.getNama());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
                    }
                    break;

                case 4: 
                    System.out.println("Daftar Mahasiswa:");
                    if (mahasiswaList.isEmpty()) {
                        System.out.println("Tidak ada data mahasiswa.");
                    } else {
                        for (Mahasiswa m : mahasiswaList) {
                            System.out.println("NIM: " + m.getNim() + ", Nama: " + m.getNama());
                        }
                    }
                    break;

                case 0: 
                    System.out.println("Terima kasih!");
                    mahasiswaList.clear(); 
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}

