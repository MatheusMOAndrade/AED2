/*
Exercício 03
Lista 1 - Exercícios de Introdução à Linguagem de Programação Java Comandos de decisão e repetição
Matheus Machado de Oliveira Andrade
AED2 - 20/02/2022
 */

import java.util.Locale;
import java.util.Scanner;

public class Ex03 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double[] arraySpeeds = new double[5];
        int countVehicles = 0;
        double totalTicketsValue;

        for(int i = 0; i < 5; i++)
        {
            System.out.println("Enter the vehicle speed:");
            arraySpeeds[i] = sc.nextDouble();

            if(arraySpeeds[i] > 60.0)
            {
                countVehicles++;
            }
        }

        totalTicketsValue = countVehicles * 150.0;

        System.out.println("Vehicles' number with speed over than 60Km/h: " + countVehicles);
        System.out.println("Total ticket value: R$" + String.format("%.2f", totalTicketsValue));

        sc.close();
    }
}
