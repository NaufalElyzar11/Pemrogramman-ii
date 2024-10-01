package Praktikum1;

import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();  
        int angkaAwal = input.nextInt();  

        int count = 0;  
        StringBuilder output = new StringBuilder();  

        do {
            if (angkaAwal % 2 != 0) {  
                output.append(angkaAwal);  
                count++;  

                if (count < N) { 
                    output.append(", ");
                }
            }
            angkaAwal++;  
        } while (count < N);  

        System.out.println(output); 
    }
}

