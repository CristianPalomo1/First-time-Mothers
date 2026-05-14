/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;

import java.util.Scanner;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class PediatricGrowthValidator {

    public void validateGrowth() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n---PEDIATRIC GROWTH VALIDATOR ---");

        System.out.print("Enter baby weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("Enter baby size in the womb (cm): ");
        double size = sc.nextDouble();

        System.out.println("\n--- RESULTS --");

        if (weight >= 2.5 && size >= 45) {

            System.out.println("Growth Status: NORMAL");

        } else if (weight >= 1.8 && size >= 35) {

            System.out.println("Growth Status: LOW RISK");

        } else {

            System.out.println("Growth Status: SEVERE");
        }
    }
}