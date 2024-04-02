/*
Exercício 02
Lista 2 - Exercícios de Introdução à Linguagem de Programação Java Vetores e matrizes
Matheus Machado de Oliveira Andrade
AED2 - 05/03/2022
*/

import java.util.Locale;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int[][] array = new int[3][4];

        for (int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {
                System.out.printf("Element[%d,%d]: ", i, j);
                array[i][j] = sc.nextInt();
            }
        }

        int larger = array[0][0];
        int smaller = array[0][0];
        int largerI = 0, largerJ = 0, smallerI = 0, smallerJ = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<4; j++) {

                if(array[i][j]>larger){
                    larger = array[i][j];
                    largerI = i;
                    largerJ = j;
                }

                if(array[i][j]<smaller) {
                    smaller = array[i][j];
                    smallerI = i;
                    smallerJ = j;
                }
            }
        }

        System.out.println();
        System.out.println("The array's largest element: " + larger);
        System.out.printf("Largest element position: [%d,%d] ",largerI , largerJ);
        System.out.println();
        System.out.println("The array's smaller element: " + smaller);
        System.out.printf("Smaller element position: [%d,%d] ",smallerI , smallerJ);

        sc.close();
    }
}
