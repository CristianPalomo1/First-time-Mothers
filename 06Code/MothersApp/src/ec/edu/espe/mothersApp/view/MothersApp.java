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
<<<<<<< HEAD

                    ProfileManager profileManager = new ProfileManager();
                    profileManager.createMotherProfile();

=======
                    String motherName;
                    boolean motherHasNumbers;
                    
                    do {
                        motherHasNumbers = false;
                        System.out.print("Mother Name: ");
                        motherName = scanner.nextLine();
                        
                        if (motherName.length() == 0) {
                            motherHasNumbers = true;
                        } else {
                            for (int i = 0; i < motherName.length(); i++) {
                                char c = motherName.charAt(i);
                                if (c >= '0' && c <= '9') {
                                    motherHasNumbers = true;
                                }
                            }
                        }
                        
                        if (motherHasNumbers) {
                            System.out.println("Error: Use solo letras.");
                            }
                        } while (motherHasNumbers);
                        
                        String babyName;
                        boolean babyHasNumbers;
                        
                        do{
                            babyHasNumbers = false;
                            System.out.print("Baby Name: ");
                            babyName = scanner.nextLine();
                            
                            if (babyName.length() == 0) {
                                babyHasNumbers = true;
                            } else {
                                for (int i = 0; i < babyName.length(); i++) {
                                    char c = babyName.charAt(i);
                                    if (c >= '0' && c <= '9') {
                                        babyHasNumbers = true;
                                    }
                                }
                            }
                        
                        if (babyHasNumbers) {
                            System.out.println("Error: Use solo letras.");
                        }
                    } while (babyHasNumbers);
                    
                    System.out.println("Baby ID (Cedula): ");
                    String babyId = scanner.nextLine();
                    
                    System.out.println("Weight (g): ");
                    double weight = scanner.nextDouble();
                    
                    System.out.println("Height (cm): ");
                    double height = scanner.nextDouble();
                    scanner.nextLine();
                    
                    Mother mother = new Mother(motherName);
                    Baby baby = new Baby(babyName, babyId, weight, height);
                    mother.getBabies().add(baby);
                    
                    System.out.println("\nProfile registered successfully");
>>>>>>> 2514faeefd2eed03bf7a32f82d54ea0a846324ed
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
