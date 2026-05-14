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

        System.out.println("\n===== MEDICAL APPOINTMENTS =====");

        System.out.println("1. 2026-05-20 | 08:00 AM");
        System.out.println("2. 2026-05-20 | 10:00 AM");
        System.out.println("3. 2026-05-21 | 02:00 PM");
        System.out.println("4. 2026-05-22 | 04:00 PM");

        System.out.print("\nSelect an appointment: ");
        int option = sc.nextInt();

        switch (option) {

            case 1:
                System.out.println("Appointment scheduled for 2026-05-20 at 08:00 AM");
                break;

            case 2:
                System.out.println("Appointment scheduled for 2026-05-20 at 10:00 AM");
                break;

            case 3:
                System.out.println("Appointment scheduled for 2026-05-21 at 02:00 PM");
                break;

            case 4:
                System.out.println("Appointment scheduled for 2026-05-22 at 04:00 PM");
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}