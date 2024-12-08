package PRAK203_2310817210019_NaufalElyzar;

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai();
        
        p1.nama = "Roi";  // Disini error karena kurang titik koma (;) di akhir baris 

        p1.asal = "Kingdom of Orvel";  
        
        p1.setJabatan("Assasin");

        p1.setUmur(17); //Menambahkan umur
        
        // Pada baris ini terjadi error karena atribut 'jabatan' bukan merupakan atribut publik.
        // p1.jabatan;
        // Perbaikan:
        System.out.println("Nama: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan); // Atribut jabatan harus dapat diakses dengan setter/getter atau cukup akses langsung
        System.out.println("Umur: " + p1.umur);
    }
}
