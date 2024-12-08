package PRAK203_2310817210019_NaufalElyzar;

public class Pegawai {  // Nama class nya salah. Seharusnya nama kelasnya 'Pegawai', bukan 'Employee'
    public String nama;
    public String asal;  // Salah di tipe datanya yaitu 'char'. Seharusnya 'String' karena 'asal' adalah kalimat.
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    // Disini error karena variabel 'j' tidak terdefinisi dalam method setJabatan()
    // public void setJabatan() {
    // this.jabatan = j;
    // }
    // Perbaikannya:
    public void setJabatan(String jabatan) {  // Perlu parameter jabatan untuk menetapkan nilai jabatan
        this.jabatan = jabatan;
    }
    //Tidak ada method untuk umur, perbaikannya:
    public void setUmur(int umur) {  // Menambahkan setter untuk umur
        this.umur = umur;
    }
}
