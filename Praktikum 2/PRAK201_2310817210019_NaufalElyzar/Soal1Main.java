package PRAK201_2310817210019_NaufalElyzar;

class Buah {
 String nama;
 double beratPerUnit; 
 double hargaPerUnit; 
 double jumlahBeli;  

 public Buah(String nama, double beratPerUnit, double hargaPerUnit, double jumlahBeli) {
     this.nama = nama;
     this.beratPerUnit = beratPerUnit;
     this.hargaPerUnit = hargaPerUnit;
     this.jumlahBeli = jumlahBeli;
 }

 public double hitungHargaSebelumDiskon() {
     return (jumlahBeli / beratPerUnit) * hargaPerUnit;
 }

 public double hitungDiskon() {
     double diskonPer4Kg = 0.02; 
     double jumlahDiskon = (jumlahBeli / 4) * diskonPer4Kg;
     return hitungHargaSebelumDiskon() * jumlahDiskon;
 }

 public double hitungHargaSetelahDiskon() {
     return hitungHargaSebelumDiskon() - hitungDiskon();
 }

 public void cetakInformasi() {
     System.out.printf("Nama Buah: %s\n", nama);
     System.out.printf("Berat: %.1fkg\n", beratPerUnit);
     System.out.printf("Harga: Rp%.1f\n", hargaPerUnit);
     System.out.printf("Jumlah Beli: %.1fkg\n", jumlahBeli);
     System.out.printf("Harga Sebelum Diskon: Rp%.2f\n", hitungHargaSebelumDiskon());
     System.out.printf("Total Diskon: Rp%.2f\n", hitungDiskon());
     System.out.printf("Harga Setelah Diskon: Rp%.2f\n\n", hitungHargaSetelahDiskon());
 }
}

public class Soal1Main {
 public static void main(String[] args) {
     Buah apel = new Buah("Apel", 0.4, 7000.0, 40.0);
     Buah mangga = new Buah("Mangga", 0.2, 3500.0, 15.0);
     Buah alpukat = new Buah("Alpukat", 0.25, 10000.0, 12.0);

     apel.cetakInformasi();
     mangga.cetakInformasi();
     alpukat.cetakInformasi();
 }
}
