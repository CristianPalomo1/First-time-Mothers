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

    // 🔹 Variables globales (BIEN, las mantienes)
    public static double motherWeight;
    public static double motherHeight;

    public static double babyWeight;
    public static double babyHeight;

    // ===============================
    // ✅ VALIDAR CRECIMIENTO
    // ===============================
    public static void validateGrowth() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n========== VALIDATE PEDIATRIC GROWTH ==========");
        System.out.println("1. Baby's information (Gestation period)");
        System.out.println("2. Baby's information (Newborn)");
        System.out.println("3. Mother's information");

        System.out.print("Select an option: ");
        int option = sc.nextInt();

        switch (option) {

            case 1:

                System.out.print("Enter baby weight (g): ");
                babyWeight = sc.nextDouble();

                System.out.print("Enter baby size in the womb (cm): ");
                babyHeight = sc.nextDouble();

                showResult(babyWeight, babyHeight);
                break;

            case 2:

                System.out.print("Enter baby weight (g): ");
                babyWeight = sc.nextDouble();

                System.out.print("Enter baby height (cm): ");
                babyHeight = sc.nextDouble();

                showResult(babyWeight, babyHeight);
                break;

            case 3:

                System.out.print("Enter mother's weight (kg): ");
                motherWeight = sc.nextDouble();

                System.out.print("Enter mother's height (cm): ");
                motherHeight = sc.nextDouble();

                showResult(motherWeight, motherHeight);
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    // ===============================
    // ✅ RESULTADO CORREGIDO
    // ===============================
    public static void showResult(double weight, double size) {

        System.out.println("\n========== RESULTS ==========");

        // 🔴 CAMBIO IMPORTANTE: usar AND en vez de OR
        if (weight >= 2500 && size >= 45) {

            System.out.println("Growth Status: NORMAL");

        } else if (weight >= 1800 && size >= 35) {

            System.out.println("Growth Status: LOW RISK");

        } else {

            System.out.println("Growth Status: SEVERE");
        }
    }
}