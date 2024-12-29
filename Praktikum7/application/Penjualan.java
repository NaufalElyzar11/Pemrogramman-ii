package application;
import java.sql.Date;

public class Penjualan {
    private int pelanggan_id;  
    private int buku_id;       
    private int penjualan_id;  
    private int jumlah;
    private double total_harga;
    private Date tanggal;

    public Penjualan(int penjualan_id, int buku_id, int pelanggan_id, int jumlah, double total_harga, Date tanggal) {
        this.penjualan_id = penjualan_id;
        this.buku_id = buku_id;
        this.pelanggan_id = pelanggan_id;
        this.jumlah = jumlah;
        this.total_harga = total_harga;
        this.tanggal = tanggal;
    }


    public int getPelangganID() {
        return this.pelanggan_id;
    }

    public int getBukuID() {
        return this.buku_id;
    }

    public int getPenjualanID() {
        return this.penjualan_id;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public double getTotalHarga() {
        return this.total_harga;
    }

    public Date getTanggal() {
        return this.tanggal;
    }
    
    public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}
	
	public void setTotalHarga(double total_harga) {
        this.total_harga = total_harga;
    }
	
	public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}
