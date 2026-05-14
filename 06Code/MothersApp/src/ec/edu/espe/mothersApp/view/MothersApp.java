package ec.edu.espe.mothersApp.view;

import ec.edu.espe.mothersApp.model.*;
import java.util.Scanner;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class MothersApp {

    static MedicalDataBase db = new MedicalDataBase();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;

        do {

            System.out.println("\n--- MATERNITY HEALTH CARE SYSTEM ---");
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
            option = sc.nextInt();

            switch (option) {

                case 1:

                    ProfileManager profileManager = new ProfileManager();
                    profileManager.createMotherProfile();

                    break;

                case 2:

                    new GestationCalculator().calculateFromWeek();
                    break;

                case 3:

                    new PediatricGrowthValidator().validateGrowth();

                    break;

                case 4:

                    new ScheduleAppointment().showAppointments();

                    break;

                case 5:

                    new AlarmValidator().classifyRiskLevel();

                    break;

                case 6:

                    new InteractiveChat().startChat();

                    break;

                case 7:

                    sc.nextLine();

                    System.out.print("Enter mother's medical record: ");
                    String history = sc.nextLine();

                    db.saveHistory(history);

                    db.showHistory();

                    break;

                case 8:

                    new CommunityActivity().showEducationalResources();

                    break;

                case 9:

                    new MedicalRecord().monitorWarningSigns();

                    break;

                case 10:

                    System.out.println("Exiting system...");

                    break;

                default:

                    System.out.println("Invalid option.");
            }

        } while (option != 10);
    }
}