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

public class MedicalRecord {

    public void monitorWarningSigns() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== WARNING SIGNS MONITOR =====");

        System.out.print("Mother weight (kg): ");
        double motherWeight = sc.nextDouble();

        System.out.print("Mother temperature (°C): ");
        double motherTemp = sc.nextDouble();

        System.out.print("Baby weight (kg): ");
        double babyWeight = sc.nextDouble();

        System.out.print("Baby temperature (°C): ");
        double babyTemp = sc.nextDouble();

        System.out.println("\n===== RESULTS =====");

        boolean danger = false;

        if (motherWeight < 45) {

            System.out.println("WARNING: Mother weight is too low.");
            danger = true;
        }

        if (motherTemp > 38) {

            System.out.println("WARNING: Mother has fever.");
            danger = true;
        }

        if (babyWeight < 2.5) {

            System.out.println("WARNING: Baby weight is below normal.");
            danger = true;
        }

        if (babyTemp > 38 || babyTemp < 35.5) {

            System.out.println("WARNING: Baby temperature is abnormal.");
            danger = true;
        }

        if (danger) {

            System.out.println("\nCRITICAL WARNING DETECTED.");
            System.out.println("Medical attention is recommended.");

        } else {

            System.out.println("\nMother and baby are stable.");
        }
    }
}