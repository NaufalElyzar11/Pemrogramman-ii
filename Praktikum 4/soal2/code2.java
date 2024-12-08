package soal2;

import java.util.Scanner;

class HewanPeliharaan {
    protected String nama; 
    protected String ras;   
    
    public HewanPeliharaan(String r, String n) {
        this.ras = r;
        this.nama = n;
    }

    public void display() {
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + this.nama);
        System.out.println("Dengan ras : " + this.ras);
    }
}

class Kucing extends HewanPeliharaan {
    private String warnaBulu;  
    
    public Kucing(String r, String n, String w) {
        super(r, n);  
        this.warnaBulu = w;
    }
    
    public void displayDetailKucing() {
        super.display();  
        System.out.println("Memiliki warna bulu : " + this.warnaBulu);
    }
}

class Anjing extends HewanPeliharaan {
    private String warnaBulu;  
    private String[] kemampuan; 
    
    public Anjing(String n, String r, String w, String[] k) {
        super(r, n);  
        this.warnaBulu = w;
        this.kemampuan = k;
    }
    
    public void displayDetailAnjing() {
        super.display(); 
        System.out.println("Memiliki warna bulu : " + this.warnaBulu);
        System.out.print("Memiliki kemampuan : ");
        for (String k : kemampuan) {
            System.out.print(k + "  ");  
        }
        System.out.println();
    }
}

public class code2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine(); 
        
        if (pilihan == 1) {
            System.out.print("Nama hewan peliharaan: ");
            String nama = input.nextLine();
            System.out.print("Ras: ");
            String ras = input.nextLine();
            System.out.print("Warna Bulu: ");
            String warnaBulu = input.nextLine();
            
            Kucing kucing = new Kucing(ras, nama, warnaBulu);
            kucing.displayDetailKucing();
            
        } else if (pilihan == 2) {
            System.out.print("Nama hewan peliharaan: ");
            String nama = input.nextLine();
            System.out.print("Ras: ");
            String ras = input.nextLine();
            System.out.print("Warna Bulu: ");
            String warnaBulu = input.nextLine();
            System.out.print("Kemampuan (pisahkan dengan koma): ");
            String[] kemampuan = input.nextLine().split(",\\s*");
            
            Anjing anjing = new Anjing(nama, ras, warnaBulu, kemampuan);
            anjing.displayDetailAnjing();
            
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}
