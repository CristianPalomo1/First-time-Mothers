package ec.edu.espe.mothersApp.view;

import ec.edu.espe.mothersApp.model.*;
import ec.edu.espe.mothersApp.controller.ManagementWeekCalculatorController;
import ec.edu.espe.mothersApp.controller.AlarmValidatorController;
import ec.edu.espe.mothersApp.controller.InteractiveChatController;
import ec.edu.espe.mothersApp.controller.EducationalResourceController;
import java.util.Map;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class MothersApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProfileManager manager = new ProfileManager();
        MedicalDataBase db = new MedicalDataBase();

        int option;

        do {

            System.out.println("\n____ MATERNITY HEALTH CARE SYSTEM ____");
            System.out.println("1. Register Mother and Baby Profiles");
            System.out.println("2. Calculate Gestation Week");
            System.out.println("3. Validate Pediatric Growth");
            System.out.println("4. Manage Medical Appointment");
            System.out.println("5. Classify Health Risk Level");
            System.out.println("6. Interactive Community Chat for Mothers");
            System.out.println("7. Medical History");
            System.out.println("8. Provide Educational Resource");
            System.out.println("9. Monitor Warning Signs");
            System.out.println("10. Show Registered Mothers");
            System.out.println("11. Exit");

            System.out.print("Select an option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:

                    manager.createMotherProfile();

                    if (ProfileManager.savedMother != null && ProfileManager.savedBaby != null) {

                        ProfileManager.savedMother.babies.clear();
                        ProfileManager.savedMother.babies.add(ProfileManager.savedBaby);

                        db.saveHistory(ProfileManager.savedMother);
                    }

                    break;

                case 2:

                    try {
                        System.out.print("Day: ");
                        int day = sc.nextInt();

                        System.out.print("Month: ");
                        int month = sc.nextInt();

                        System.out.print("Year: ");
                        int year = sc.nextInt();
                        sc.nextLine();

                        ManagementWeekCalculatorController gestation =
                                new ManagementWeekCalculatorController();

                        Map<String, String> result =
                                gestation.calculateGestation(day, month - 1, year);

                        System.out.println(result.get("weeksResult"));
                        System.out.println(result.get("dueDateResult"));

                        if (!result.get("warning").isEmpty()) {
                            System.out.println(result.get("warning"));
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }

    break;

                case 3:

                    PediatricGrowthValidator.validateGrowth();

                    break;

                case 4:

                    Appointment appointment = new Appointment();

                    System.out.print("Reason of appointment: ");
                    String reason = sc.nextLine();

                    appointment.schedule(new Date(),
                            new Time(System.currentTimeMillis()),
                            reason);

                    System.out.println("Appointment scheduled successfully.");

                    break;

                case 5:

                    AlarmValidatorController alarm =
                    new AlarmValidatorController();

                    System.out.print("Temperature: ");
                    double temp = sc.nextDouble();

                    System.out.print("Respiratory distress (true/false): ");
                    boolean respiratory = sc.nextBoolean();

                    System.out.print("Feeding problems (true/false): ");
                    boolean feeding = sc.nextBoolean();

                    System.out.print("Abnormal skin color (true/false): ");
                    boolean skin = sc.nextBoolean();

                    System.out.print("Lethargy (true/false): ");
                    boolean lethargy = sc.nextBoolean();

                    sc.nextLine();

                    System.out.println(alarm.validateAndSaveAssessment(
                            temp,
                            respiratory,
                            feeding,
                            skin,
                            lethargy));

                    break;

                case 6:

                    InteractiveChatController chat =
                    new InteractiveChatController();

                    System.out.print("Write your message: ");
                    String message = sc.nextLine();

                    chat.sendMessage("Mother", message);

                    System.out.println("Message sent.");

                    break;

                case 7:

                    showHistory();

                    break;

                case 8:

                    EducationalResourceController resource =
                    new EducationalResourceController();

                    System.out.print("Topic: ");
                    String topic = sc.nextLine();

                    System.out.println(resource.searchTopic(topic));

                    break;

                case 9:

                    new MedicalRecord().monitorWarningSigns();

                    break;

                case 10:

                    db.showHistory();

                    break;

                case 11:

                    System.out.println("Exiting system...");

                    break;

                default:

                    System.out.println("Invalid option.");

            }

        } while (option != 11);

    }

    public static void showHistory() {

        if (ProfileManager.savedMother == null || ProfileManager.savedBaby == null) {

            System.out.println("No profile registered.");
            return;

        }

        Mother m = ProfileManager.savedMother;
        Baby b = ProfileManager.savedBaby;

        System.out.println("\n___________________________________");
        System.out.println("         MEDICAL HISTORY");
        System.out.println("___________________________________");

        System.out.println("\nMother:");
        System.out.println(m.firstName + " " + m.lastName);
        System.out.println("ID: " + m.id);
        System.out.println("Birth Date: " + m.birthDate);

        System.out.println("\nBaby:");
        System.out.println(b.firstName + " " + b.getLastName());
        System.out.println("Birth/Expected Date: " + b.birthDate);

        System.out.println("Mother Weight: " + m.weight + " kg");
        System.out.println("Mother Height: " + m.height + " cm");

        System.out.println("Baby Weight: " + b.getWeight() + " g");
        System.out.println("Baby Height: " + b.getHeight() + " cm");

        System.out.println("___________________________________");

    }
}