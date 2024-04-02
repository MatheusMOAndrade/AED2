/*
Exercício 02
Lista 1 - Exercícios de Introdução à Linguagem de Programação Java Comandos de decisão e repetição
Matheus Machado de Oliveira Andrade
AED2 - 20/02/2022
 */

import java.util.Locale;
import java.util.Scanner;

public class Ex02 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        double score1, score2, score3, arMean;


        do {
            System.out.println("Enter the first student score (1-10):");
            score1 = sc.nextDouble();
        } while(score1 < 0 || score1 > 10);

        do {
            System.out.println("Enter the second student score (1-10):");
            score2 = sc.nextDouble();
        } while(score2 < 0 || score2 > 10);

        do {
            System.out.println("Enter the third student score (1-10):");
            score3 = sc.nextDouble();
        } while(score3 < 0 || score3 > 10);

        arMean = (score1 + score2 + score3)/3.0;

        if (arMean < 4.0) {
            System.out.println("Student average score: " + String.format("%.2f", arMean));
            System.out.println("Student situation: Repproved/Reprovado");
        }
        else if (arMean > 4.0 & arMean < 10.0)
        {
            System.out.println("Student average score: " + String.format("%.2f", arMean));
            System.out.println("Student situation: Special Test/Exame Especial");
        }
        else
        {
            System.out.println("Student average score: " + String.format("%.2f", arMean));
            System.out.println("Student situation: Approved/Aprovado");
        }

        System.out.println("");

        sc.close();
}
}
