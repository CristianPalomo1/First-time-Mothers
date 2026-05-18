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

        System.out.println("\n===== MOTHER REGISTRATION =====");

        String mFn;
        String mLn;
        String identification;
        String mBd;

        double motherWeight;
        double motherHeight;

        String bFn;
        String bLn;
        String bId;

        int w;
        int h;

        String bBd;

        boolean d;
        boolean neonate;

        String gestation;

        // MOTHER DATA

        mFn = readOnlyLetters("Mother First Name: ");

        mLn = readOnlyLetters("Mother Last Name: ");

        identification = readValidIdentification(
                "Identification Number (max 20 digits): ");

        mBd = readValidDate(
                "Mother Birth Date (YYYY-MM-DD): ");

        System.out.print("Mother Weight (kg): ");
        motherWeight = sc.nextDouble();

        System.out.print("Mother Height (cm): ");
        motherHeight = sc.nextDouble();

        sc.nextLine();

        // BABY DATA

        System.out.println("\n===== BABY REGISTRATION =====");

        System.out.println("\n===== BABY REGISTRATION =====");

        System.out.println("1. Skip baby registration");
        System.out.println("2. Add baby information");

        System.out.print("Select an option: ");
        int adoption = sc.nextInt();

        sc.nextLine();

        if (adoption == 1) {

            System.out.println(
                    "\nProcess completed successfully.");

            return;
        }

        bFn = readOnlyLetters("Baby First Name: ");

        bLn = readOnlyLetters("Baby Last Name: ");

        System.out.print(
                "Baby Age (weeks or months): ");

        String age = sc.nextLine();

        System.out.print(
                "Baby ID (optional): ");

        bId = sc.nextLine();

        System.out.print(
                "Baby Weight (grams): ");

        w = sc.nextInt();

        System.out.print(
                "Baby Height (cm): ");

        h = sc.nextInt();

        sc.nextLine();

        bBd = readValidDate(
                "Baby Birth Date (YYYY-MM-DD): ");

        System.out.print(
                "Gestation Period: ");

        gestation = sc.nextLine();

        System.out.print(
                "Is neonate? (true/false): ");

        neonate = sc.nextBoolean();

        System.out.print(
                "Has disability? (true/false): ");

        d = sc.nextBoolean();

        // OBJECTS

        Mother mother = new Mother(
                mFn,
                mLn,
                identification,
                mBd,
                motherWeight,
                motherHeight);

        Baby baby = new Baby(
                bFn,
                bLn,
                bId,
                w,
                h,
                bBd,
                d,
                gestation,
                neonate);

        System.out.println(
                "\nProfile registered successfully!");
    }

    // ONLY LETTERS

    private String readOnlyLetters(String msg) {

        String text;

        while (true) {

            System.out.print(msg);

            text = sc.nextLine();

            if (text.matches(
                    "[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {

                return text;
            }

            System.out.println(
                    "ERROR: Only letters are allowed.");
        }
    }

    // VALID IDENTIFICATION

    private String readValidIdentification(String msg) {

        String id;

        while (true) {

            System.out.print(msg);

            id = sc.nextLine();

            if (id.matches("\\d{1,20}")) {

                return id;
            }

            System.out.println(
                    "ERROR: Only numbers allowed. Max 20 digits.");
        }
    }

    // VALID DATE

    private String readValidDate(String msg) {

        String date;

        while (true) {

            System.out.print(msg);

            date = sc.nextLine();

            if (date.matches(
                    "\\d{4}-\\d{2}-\\d{2}")) {

                return date;
            }

            System.out.println(
                    "ERROR: Date format must be YYYY-MM-DD.");
        }
    }
}