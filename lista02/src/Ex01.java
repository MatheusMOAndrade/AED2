/*
Exercício 01
Lista 2 - Exercícios de Introdução à Linguagem de Programação Java Vetores e matrizes
Matheus Machado de Oliveira Andrade
AED2 - 05/03/2022
*/

import java.util.Locale;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        /*vetor gabarito*/
        char[] testAnswers = new char[8];

        for(int i=0; i < testAnswers.length; i++)
        {
            System.out.println("Enter with the right answer for question #" + (i+1));
            testAnswers[i] = sc.next().charAt(0);
        }

        /*vetor com os alunos*/
        Student[] studentsData = new Student[10];

        int regNumber = 0;
        char[] studentAnswers = new char[8];

        for(int i=0; i<studentsData.length; i++){

            System.out.println("Enter the student register number:");
            regNumber = sc.nextInt();

            for(int j=0; j<studentAnswers.length; j++)
            {
                System.out.println("Enter the student's answer for question #" + (j+1));
                studentAnswers[j] = sc.next().charAt(0);
            }

            studentsData[i] = new Student(regNumber, studentAnswers);
        }

        int studentScore;
        int approvedCount = 0;

        for(int i=0; i<studentsData.length; i++){

            studentScore = 0;

            for (int j=0; j<studentAnswers.length; j++) {
                if(testAnswers[i] == studentAnswers[i])
                {
                    studentScore++;
                }
            }

            if(studentScore >= 5) {
                approvedCount++;
            }

            System.out.println("Student Number: " + studentsData[i].getRegNumber());
            System.out.println("Student Score: " + studentScore);
        }

        int approvedPercent = approvedCount * 10;

    System.out.println("Approved: " + approvedPercent + "% of student class");

        sc.close();
    }
}
