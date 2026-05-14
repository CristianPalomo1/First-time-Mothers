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

public class ProfileManager {

    private Scanner sc = new Scanner(System.in);

    public void createMotherProfile() {

        System.out.println("\n--- Mother Registration ---");

        String mFn = readOnlyLetters("First Name: ");
        String mLn = readOnlyLetters("Last Name: ");
        String mId = readValidId("ID (10 digits): ");
        String mBd = readValidDate("Birth Date (YYYY-MM-DD): ");

        System.out.println("\n--- Baby Registration ---");

        String bFn = readOnlyLetters("First Name: ");
        String bLn = readOnlyLetters("Last Name: ");
        String bId = readValidId("Baby ID (10 digits): ");

        System.out.print("Weight (g): ");
        int w = sc.nextInt();

        System.out.print("Height (cm): ");
        int h = sc.nextInt();

        sc.nextLine();

        String bBd = readValidDate("Birth Date (YYYY-MM-DD): ");

        System.out.print("Has disability? (true/false): ");
        boolean d = sc.nextBoolean();

        Mother mother = new Mother(mFn, mLn, mId, mBd);
        Baby baby = new Baby(bFn, bLn, bId, w, h, bBd, d);

        System.out.println("\nProfile registered successfully!");
    }

    private String readOnlyLetters(String msg) {

        String text;

        while (true) {

            System.out.print(msg);
            text = sc.nextLine();

            if (text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return text;
            }

            System.out.println("ERROR: Only letters are allowed.");
        }
    }
    
    private String readValidId(String msg) {

        String id;

        while (true) {

            System.out.print(msg);
            id = sc.nextLine();

            if (id.matches("\\d{10}")) {
                return id;
            }

            System.out.println("ERROR: ID must contain exactly 10 digits.");
        }
    }

    private String readValidDate(String msg) {

        String date;

        while (true) {

            System.out.print(msg);
            date = sc.nextLine();

            if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return date;
            }

            System.out.println("ERROR: Date format must be YYYY-MM-DD.");
        }
    }
}