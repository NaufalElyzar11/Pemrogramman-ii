package Praktikum1;

import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        double jariJari = sc.nextDouble();
        
        System.out.print("Masukkan tinggi: ");
        double tinggi = sc.nextDouble();

        double volume = 3.14 * jariJari * jariJari * tinggi;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3\n", jariJari, tinggi, volume);

        sc.close();
    }
}

