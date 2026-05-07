package ec.edu.espe.mothersapp.view;

import ec.edu.espe.mothersapp.model.Baby;
import ec.edu.espe.mothersapp.model.Mother;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class MothersApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> appointments = new ArrayList<>();
        ArrayList<String> medicalHistory = new ArrayList<>();

        int option;

        do {

            System.out.println("");
            System.out.println("===== MATERNITY HEALTH CARE SYSTEM =====");
            System.out.println("1. Register Mother and Baby Profiles");
            System.out.println("2. Calculate Gestation Week");
            System.out.println("3. Validate Pediatric Growth");
            System.out.println("4. Manage Medical Appointment");
            System.out.println("5. Classify Health Risk Level");
            System.out.println("6. Interactive Community Chat for Mothers");
            System.out.println("7. Persist Medical History");
            System.out.println("8. Provide Educational Resource");
            System.out.println("9. Monitor Warning Signs");
            System.out.println("10. Exit");

            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:

                    System.out.print("Mother Name: ");
                    Mother mother = new Mother(scanner.nextLine());

                    System.out.print("Baby Name: ");
                    String babyName = scanner.nextLine();

                    System.out.print("Baby ID (Cedula): ");
                    String babyId = scanner.nextLine();

                    System.out.print("Weight (g): ");
                    double weight = scanner.nextDouble();

                    System.out.print("Height (cm): ");
                    double height = scanner.nextDouble();
                    scanner.nextLine();

                    Baby baby = new Baby(babyName, babyId, weight, height);

                    mother.getBabies().add(baby);

                    System.out.println("");
                    System.out.println("Profile registered successfully");
                    break;

                case 2:

                    System.out.println("");
                    System.out.println("Method: 1. LMP (FUM) | 2. Ultrasound (ECO)");

                    int method = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");

                    LocalDate date = LocalDate.parse(scanner.nextLine());

                    if (method == 1) {

                        long weeks =
                                ChronoUnit.WEEKS.between(date, LocalDate.now());

                        System.out.println("Weeks by LMP: " + weeks);

                    } else {

                        System.out.print("Weeks reported in ECO: ");

                        int ecoWeeks = scanner.nextInt();

                        long weeksSinceEco =
                                ChronoUnit.WEEKS.between(date, LocalDate.now());

                        System.out.println("Total weeks by ECO: "
                                + (ecoWeeks + weeksSinceEco));
                    }

                    break;

                case 3:

                    System.out.println("");
                    System.out.println("PEDIATRIC GROWTH VALIDATION");

                    System.out.print("Enter baby weight (g): ");
                    double babyWeight = scanner.nextDouble();

                    System.out.print("Enter baby height (cm): ");
                    double babyHeight = scanner.nextDouble();
                    scanner.nextLine();

                    if (babyWeight >= 2500 && babyHeight >= 45) {

                        System.out.println("Healthy pediatric growth");

                    } else {

                        System.out.println("Warning: Pediatric growth requires medical evaluation");
                    }

                    break;

                case 4:

                    System.out.println("");
                    System.out.println("===== MEDICAL APPOINTMENTS");

                    System.out.print("Enter appointment date: ");
                    String appointment = scanner.nextLine();

                    appointments.add(appointment);

                    System.out.println("Appointment registered successfully");

                    System.out.println("Appointments:");

                    for (String app : appointments) {

                        System.out.println("- " + app);
                    }

                    break;

                case 5:

                    System.out.println("");
                    System.out.println("===== HEALTH RISK CLASSIFICATION =====");

                    System.out.print("Mother blood pressure: ");
                    int pressure = scanner.nextInt();

                    System.out.print("Baby weight (g): ");
                    double riskWeight = scanner.nextDouble();
                    scanner.nextLine();

                    if (pressure > 140 || riskWeight < 2500) {

                        System.out.println("HIGH RISK pregnancy");

                    } else {

                        System.out.println("LOW RISK pregnancy");
                    }

                    break;

                case 6:

                    System.out.println("");
                    System.out.println("===== COMMUNITY CHAT =====");

                    System.out.print("Write your message: ");

                    String message = scanner.nextLine();

                    System.out.println("");
                    System.out.println("Message sent successfully:");
                    System.out.println(message);

                    break;

                case 7:

                    System.out.println("");
                    System.out.println("===== MEDICAL HISTORY =====");

                    System.out.print("Enter medical history note: ");

                    String history = scanner.nextLine();

                    medicalHistory.add(history);

                    System.out.println("");
                    System.out.println("Medical history saved successfully");

                    System.out.println("History Records:");

                    for (String record : medicalHistory) {

                        System.out.println("- " + record);
                    }

                    break;

                case 8:

                    System.out.println("");
                    System.out.println("===== EDUCATIONAL RESOURCES =====");

                    System.out.println("1. Nutrition during pregnancy");
                    System.out.println("2. Importance of prenatal checkups");
                    System.out.println("3. Newborn care recommendations");
                    System.out.println("4. Vaccination schedule");
                    System.out.println("5. Breastfeeding benefits");

                    break;

                case 9:

                    System.out.println("");
                    System.out.println("===== MSP WARNING SIGNS =====");

                    System.out.println("1. Constant headache or blurry vision");
                    System.out.println("2. Vaginal bleeding or fluid loss");
                    System.out.println("3. Swelling of hands, face, or feet");
                    System.out.println("4. Baby weak cry");
                    System.out.println("5. High fever or chills");

                    System.out.print("Select a warning sign: ");

                    int sign = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("");

                    switch (sign) {

                        case 1:

                            System.out.println("ALERT: Possible preeclampsia.");
                            break;

                        case 2:

                            System.out.println("ALERT: Emergency during pregnancy.");
                            break;

                        case 3:

                            System.out.println("ALERT: Possible hypertension.");
                            break;

                        case 4:

                            System.out.println("ALERT: Baby requires medical evaluation.");
                            break;

                        case 5:

                            System.out.println("ALERT: Possible infection.");
                            break;

                        default:

                            System.out.println("Invalid option.");
                            break;
                    }

                    break;

                case 10:

                    System.out.println("");
                    System.out.println("System closed");
                    break;

                default:

                    System.out.println("");
                    System.out.println("Invalid option");
                    break;
            }

        } while (option != 10);

        scanner.close();
    }
}