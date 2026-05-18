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

    // 🔹 Datos de cita
    private static String appointmentDate = "";
    private static String reminder = "";

    // 🔹 Recomendación médica
    private static String doctorRecommendation = "";

    // ===============================
    // ✅ AGENDAR CITA
    // ===============================
    public static void scheduleAppointment(String date, String note) {
        appointmentDate = date;
        reminder = note;
        System.out.println("Appointment scheduled successfully.");
    }

    // ===============================
    // ✅ MOSTRAR CITA
    // ===============================
    public static void showAppointments() {
        System.out.println("\n======================================");
        System.out.println("         APPOINTMENTS");
        System.out.println("======================================");

        if (appointmentDate.isEmpty()) {
            System.out.println("No appointment scheduled.");
        } else {
            System.out.println("Date: " + appointmentDate);
            System.out.println("Reminder: " + reminder);
        }

        System.out.println("======================================");
    }

    // ===============================
    // ✅ GUARDAR HISTORIAL (RECOMENDACIÓN)
    // ===============================
    public static void saveMedicalHistory(String recommendation) {
        doctorRecommendation = recommendation;
        System.out.println("Medical history saved successfully.");
    }

    // ===============================
    // ✅ MOSTRAR HISTORIAL MÉDICO
    // ===============================
    public static void showMedicalHistory() {

        System.out.println("\n======================================");
        System.out.println("         MEDICAL HISTORY");
        System.out.println("======================================");

        // 🔹 MADRE
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
        } else {
            System.out.println("\nNo mother data registered.");
        }

        // 🔹 BEBÉ
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

        } else {
            System.out.println("\nNo baby data registered.");
        }

        // 🔹 CITA
        System.out.println("\nAPPOINTMENT");
        System.out.println("----------------------------");

        if (!appointmentDate.isEmpty()) {
            System.out.println("Date: " + appointmentDate);
            System.out.println("Reminder: " + reminder);
        } else {
            System.out.println("No appointment scheduled.");
        }

        // 🔹 RECOMENDACIÓN
        System.out.println("\nDOCTOR RECOMMENDATION");
        System.out.println("----------------------------");

        if (!doctorRecommendation.isEmpty()) {
            System.out.println(doctorRecommendation);
        } else {
            System.out.println("No recommendation provided.");
        }

        System.out.println("======================================");
    }
}