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

public class ScheduleAppointment {

    public static void showMedicalHistory() {

    System.out.println("\n======================================");
    System.out.println("         MEDICAL HISTORY");
    System.out.println("======================================");

    if (ProfileManager.savedMother != null) {

        System.out.println("\nMOTHER INFORMATION");
        System.out.println("----------------------------");

        System.out.println("Name: "
                + ProfileManager.savedMother.firstName + " "
                + ProfileManager.savedMother.lastName);

        System.out.println("ID: "
                + ProfileManager.savedMother.id);

        System.out.println("Birth Date: "
                + ProfileManager.savedMother.birthDate);

        System.out.println("Mother Weight: "
                + PediatricGrowthValidator.motherWeight + " kg");

        System.out.println("Mother Height: "
                + PediatricGrowthValidator.motherHeight + " cm");
    }

    if (ProfileManager.savedBaby != null) {

        System.out.println("\nBABY INFORMATION");
        System.out.println("----------------------------");

        System.out.println("Name: "
                + ProfileManager.savedBaby.firstName + " "
                + ProfileManager.savedBaby.lastName);

        System.out.println("Expected/Birth Date: "
                + ProfileManager.savedBaby.birthDate);

        System.out.println("Baby Weight: "
                + PediatricGrowthValidator.babyWeight + " g");

        System.out.println("Baby Height: "
                + PediatricGrowthValidator.babyHeight + " cm");

        System.out.println("Appointment: General Control");

        System.out.println("Recommendation: Healthy monitoring");
    }

    System.out.println("======================================");
}
    public static void showAppointments() {
        System.out.println("\n======================================");
        System.out.println("         APPOINTMENTS");
        System.out.println("======================================");

        System.out.println("Next appointment: General Control");
        System.out.println("Date: Not scheduled yet");

        System.out.println("======================================");
    }
}
    