package soal1;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class Dadu {
    private int nilai;

    public Dadu() {
        acakNilai();
    }

    public void acakNilai() {
        Random random = new Random();
        this.nilai = random.nextInt(6) + 1; 
    }

    public int getNilai() {
        return nilai;
    }
}

public class code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah dadu: ");
        int jumlahDadu = scanner.nextInt();

        LinkedList<Dadu> daduList = new LinkedList<>();

        for (int i = 0; i < jumlahDadu; i++) {
            Dadu dadu = new Dadu();
            daduList.add(dadu);
        }

        int totalNilai = 0;

        for (int i = 0; i < daduList.size(); i++) {
            Dadu dadu = daduList.get(i);
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + dadu.getNilai());
            totalNilai += dadu.getNilai();
        }
        
        System.out.println("Total nilai dadu keseluruhan " + totalNilai);

        scanner.close();
    }
}
