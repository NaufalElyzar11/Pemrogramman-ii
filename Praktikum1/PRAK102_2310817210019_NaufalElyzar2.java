package Praktikum1;

import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka awal memulai deret: ");
        int angkaAwal = input.nextInt();

        int count = 0; 

        while (count < 10) {
            if (angkaAwal % 5 == 0) {
                System.out.print((angkaAwal / 5) - 1 + ", ");
            } else {
                System.out.print(angkaAwal + ", ");
            }

            angkaAwal++; 
            count++;
        }
    }
}

