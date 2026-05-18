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

    public void showAppointments() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== MEDICAL CALENDAR =====");

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Reminder message: ");
        String reminder = sc.nextLine();

        System.out.println("\nAppointment saved successfully!");

        System.out.println("Appointment Date: " + date);
        System.out.println("Reminder: " + reminder);
    }
}