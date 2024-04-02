/*
Exercício 01
Lista 1 - Exercícios de Introdução à Linguagem de Programação Java Comandos de decisão e repetição
Matheus Machado de Oliveira Andrade
AED2 - 20/02/2022
*/

import java.util.Locale;
import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        double salary;

        do
        {
            /*entrada de dados*/
            System.out.println("Enter the salary value:");
            salary = sc.nextDouble();

            double newSalary, increase;

            /*verificação do valor do salário*/
            if(salary <= 1200)
            {
                increase = (salary * 0.1);
                newSalary = salary + increase;

                System.out.println("Salary increase value: R$" + String.format("%.2f", increase));
                System.out.println("New salary amount: R$" + String.format("%.2f", newSalary));

            }
            else
            {
                increase = (salary * 0.05);
                newSalary = salary + increase;

                System.out.println("Salary increase value: R$" + String.format("%.2f", increase));
                System.out.println("New salary value: R$" + String.format("%.2f", newSalary));
            }

            System.out.println("");

        } while(salary > 0);

        if(salary < 0)
        {
            System.out.println("N/A Salary value.");
        }

        sc.close();
    }
}
