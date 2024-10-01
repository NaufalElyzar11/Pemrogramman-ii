package Praktikum1;

import java.util.Scanner;

public class Soal4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Tangan Abu: ");
        String[] tanganAbu = sc.nextLine().split(" ");

        System.out.print("Tangan Bagas: ");
        String[] tanganBagas = sc.nextLine().split(" ");

        int skorAbu = 0;
        int skorBagas = 0;

        for (int i = 0; i < 3; i++) {
            String abu = tanganAbu[i];
            String bagas = tanganBagas[i];

            if (abu.equals(bagas)) {
                continue;
            } else if ((abu.equals("B") && bagas.equals("G")) || 
                       (abu.equals("G") && bagas.equals("K")) || 
                       (abu.equals("K") && bagas.equals("B"))) {
                skorAbu++;
            } else {
                skorBagas++;
            }
        }

        if (skorAbu > skorBagas) {
            System.out.println("Abu");
        } else if (skorBagas > skorAbu) {
            System.out.println("Bagas");
        } else {
            System.out.println("Seri");
        }

        sc.close();
    }
}
