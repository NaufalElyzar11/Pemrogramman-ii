package soal1;

import java.util.Scanner;

class HewanPeliharaan {
    private String nama; 
    private String ras;  
    
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

class code1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        
        System.out.print("Nama hewan peliharaan: ");
        String nama = input.nextLine();
        
        System.out.print("Ras: ");
        String ras = input.nextLine();
        
        HewanPeliharaan hewan = new HewanPeliharaan(ras, nama);
        
        hewan.display();
        
        input.close(); 
    }
}
