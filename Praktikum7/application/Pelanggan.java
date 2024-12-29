package application;

public class Pelanggan {
		private int pelanggan_id;
		private String nama;
		private String email;
		private String telepon;
		
		public Pelanggan(int id_pelanggan, String nama, String email, String telepon) {
			this.pelanggan_id = id_pelanggan;
			this.nama = nama;	
			this.email = email;
			this.telepon = telepon;
		}
		
		public int getPelangganID() {
			return this.pelanggan_id;
		}
		
		public String getNama() {
			return this.nama;
		}
		
		public String getEmail() {
			return this.email;
		}
		
		public String getTelepon() {
			return this.telepon;
		}
		
		public void setNama(String nama) {
			this.nama = nama;
		}
		
		public void setEmail(String email) {
	        this.email = email;
	    }
		
		public void setTelepon(String telepon) {
	        this.telepon = telepon;
	    }

	    public void setPelangganID(int id_pelanggan) {
	        this.pelanggan_id = id_pelanggan;
	    }
	}
