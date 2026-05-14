package ec.edu.espe.mothersapp.view;

import ec.edu.espe.mothersapp.model.Baby;
import ec.edu.espe.mothersapp.model.Mother;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class MothersApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> appointments = new ArrayList<>();
        ArrayList<String> medicalHistory = new ArrayList<>();
        Mother currentMother = null;
        int option;

        do {
            System.out.println("\n===== MATERNITY HEALTH CARE SYSTEM =====");
            System.out.println("1. Register Mother and Baby Profiles");
            System.out.println("2. Calculate Gestation Week (Prenatal Calculator)");
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
                    break;

                case 2:
                    System.out.println("\n--- Prenatal Calculator (Hospital de Calderón Standards) ---");
                    System.out.println("Method: 1. LMP (FUM) | 2. Current Week (Direct)");
                    int method = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (method == 1) {
                        System.out.print("Enter Date of Last Menstrual Period (YYYY-MM-DD): ");
                        try {
                            LocalDate lmpDate = LocalDate.parse(scanner.nextLine());
                            long weeks = ChronoUnit.WEEKS.between(lmpDate, LocalDate.now());
                            LocalDate fpp = lmpDate.plusDays(7).minusMonths(3).plusYears(1);
                            
                            System.out.println("\n-------------------------------------------");
                            System.out.println(">>> RESULT: WEEK " + weeks + " OF PREGNANCY");
                            
                            if (weeks <= 13) {
                                System.out.println(">>> TRIMESTER: 1st Trimester");
                                if (weeks == 5) {
                                    System.out.println(">>> DEVELOPMENT: Embryo approx. 2 mm (Poppy seed).");
                                    System.out.println(">>> KEY: Placenta starts developing.");
                                }
                            } else if (weeks <= 26) {
                                System.out.println(">>> TRIMESTER: 2nd Trimester");
                            } else {
                                System.out.println(">>> TRIMESTER: 3rd Trimester");
                            }
                            System.out.println(">>> ESTIMATED DUE DATE (FPP): " + fpp);
                        } catch (DateTimeParseException e) {
                            System.out.println(">>> ERROR: Use YYYY-MM-DD format.");
                        }
                    } else {
                        System.out.print("Enter current week: ");
                        int currentW = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Tracking set at Week " + currentW);
                    }
                    break;

                case 3:
                    System.out.println("\n--- Growth Status Validation ---");
                    System.out.print("Enter baby weight (g): ");
                    double vWeight = scanner.nextDouble();
                    System.out.print("Enter baby height (cm): ");
                    double vHeight = scanner.nextDouble();
                    scanner.nextLine();
                    Baby tempBaby = new Baby();
                    tempBaby.setWeight(vWeight);
                    tempBaby.setHeight(vHeight);
                    System.out.println("Status: " + tempBaby.getGrowthStatus());
                    break;

                case 4:
                    System.out.println("\n--- Medical Appointment Record ---");
    
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
    
                    System.out.print("Enter time (HH:mm): ");
                    String time = scanner.nextLine();
    
                    String fullAppointment = "Date: " + date + " | Time: " + time;
                    appointments.add(fullAppointment);
    
                    System.out.println("Registered. Upcoming:");
                    for (String app : appointments) {
                    System.out.println("- " + app);
                    }
                    break;

                case 5:
                    System.out.println("\n--- Health Risk Classification ---");
                    System.out.print("Blood pressure (Systolic): ");
                    int pressure = scanner.nextInt();
                    System.out.print("Baby weight (g): ");
                    double rWeight = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Classification: " + ((pressure > 140 || rWeight < 2500) ? "HIGH RISK" : "LOW RISK"));
                    break;

                case 6:
                         int guideOption;
                         do {
                             System.out.println("\n===========================================");
                             System.out.println("   INTERACTIVE MOTHER & BABY HEALTH GUIDE  ");
                             System.out.println("===========================================");
                             System.out.println("1. Postpartum Care (Recovery & Warning Signs)");
                             System.out.println("2. Breastfeeding (Techniques & Benefits)");
                             System.out.println("3. Safe Sleep (SIDS Prevention)");
                             System.out.println("4. Newborn Nutrition & Stomach Size");
                             System.out.println("5. Return to Main Menu");
                             System.out.print("\nSelect a topic to learn more: ");
                             guideOption = scanner.nextInt();
                             scanner.nextLine();

                             if (guideOption == 5) {
                                 System.out.println("\n>>> Returning to Main System...");
                                 break;
                             }

                             System.out.println("\n-------------------------------------------");
                             switch (guideOption) {
                                 case 1:
                                     System.out.println(">>> TOPIC: MATERNAL POSTPARTUM RECOVERY");
                                     System.out.println(" * PHYSICAL: Rest whenever the baby sleeps. Uterine involution ");
                                     System.out.println("   causes 'entuertos' (cramps), which are normal.");
                                     System.out.println(" * HYDRATION: Drink at least 3 liters of water to support milk.");
                                     System.out.println(" * WARNING SIGNS: Seek help if you have a high fever, foul-smelling");
                                     System.out.println("   discharge, or extreme sadness/anxiety (Postpartum Depression).");
                                     break;
                                 case 2:
                                     System.out.println(">>> TOPIC: BREASTFEEDING MASTERY");
                                     System.out.println(" * THE LATCH: Ensure the baby takes a large mouthful of breast,");
                                     System.out.println("   not just the nipple, to avoid pain and cracks.");
                                     System.out.println(" * COLOSTRUM: The first yellow milk is 'liquid gold,' rich in");
                                     System.out.println("   antibodies to protect your baby from infections.");
                                     System.out.println(" * FREQUENCY: Feed on demand (8-12 times a day).");
                                     break;
                                 case 3:
                                     System.out.println(">>> TOPIC: SAFE SLEEP ENVIRONMENT");
                                     System.out.println(" * POSITION: Always place the baby on their BACK to sleep.");
                                     System.out.println(" * SURFACE: Use a firm, flat mattress. No pillows, stuffed animals,");
                                     System.out.println("   or loose blankets in the crib (prevents suffocation).");
                                     System.out.println(" * TEMPERATURE: Keep the room at a comfortable temperature;");
                                     System.out.println("   don't overdress the baby (overheating is a risk factor).");
                                     break;
                                 case 4:
                                     System.out.println(">>> TOPIC: NEWBORN NUTRITION");
                                     System.out.println(" * STOMACH SIZE: Day 1 (Cherry size, 5-7ml), Day 3 (Walnut size),");
                                     System.out.println("   One week (Apricot size), One month (Large egg size).");
                                     System.out.println(" * EXCLUSIVITY: Only breast milk or formula for the first 6 months.");
                                     System.out.println("   No water, juices, or porridges are needed yet.");
                                     break;
                                 default:
                                     System.out.println(">>> Invalid option. Please select 1-5.");
                                     continue;
                             }
                             System.out.println("-------------------------------------------");
                             System.out.println("Press Enter to go back to the Guide Menu...");
                             scanner.nextLine();

                         } while (guideOption != 5);
                         break;
                case 7:
                    System.out.println("\n--- Persist Medical History ---");
                    System.out.print("Enter note: ");
                    medicalHistory.add(scanner.nextLine());
                    System.out.println("History Records Saved.");
                    break;

                case 8:
                    int eduOption;
                    do {
                        System.out.println("\n--- Educational Resources ---");
                        System.out.println("1. Prenatal Nutrition\n2. Checkup Importance\n3. Vaccination\n4. Return to Main Menu");
                        System.out.print("Select a topic to read: ");
                        eduOption = scanner.nextInt();
                        scanner.nextLine(); 

                        if (eduOption == 4) {
                            System.out.println(">>> Returning...");
                            break;
                        }

                        System.out.println("\n-------------------------------------------");
                        switch (eduOption) {
                            case 1:
                                System.out.println(">>> PRENATAL NUTRITION");
                                System.out.println(" * FOLIC ACID: Essential for baby's brain and spine development.");
                                System.out.println(" * IRON: Prevents anemia and helps deliver oxygen to the baby.");
                                System.out.println(" * AVOID: Raw fish, unpasteurized cheese, and excess caffeine.");
                                break;
                            case 2:
                                System.out.println(">>> CHECKUP IMPORTANCE");
                                System.out.println(" * FREQUENCY: Monthly until week 28, then every 2 weeks.");
                                System.out.println(" * PURPOSE: Monitor blood pressure, fetal growth, and glucose levels.");
                                System.out.println(" * ULTRASOUNDS: Crucial to check baby's organs and anatomy.");
                                break;
                            case 3:
                                System.out.println(">>> VACCINATION GUIDE");
                                System.out.println(" * TDAP: Protects the newborn from whooping cough (tos ferina).");
                                System.out.println(" * INFLUENZA: Safe during any trimester to protect mom and baby.");
                                System.out.println(" * POST-BIRTH: Ensure the baby receives Hepatitis B and BCG.");
                                break;
                            default:
                                System.out.println("Invalid option. Please choose 1-4.");
                        }

                        if (eduOption >= 1 && eduOption <= 3) {
                            System.out.println("-------------------------------------------");
                            System.out.println("Press Enter to continue...");
                            scanner.nextLine();
                        }

                    } while (eduOption != 4);
                    break;

                case 9:
                    System.out.println("\n--- Critical Warning Signs (MSP Protocol) ---");
                    System.out.println("1. Fever/Hypothermia\n2. Respiratory distress\n3. Feeding refusal\n4. Skin color\n5. Activity");
                    System.out.print("Select a sign: ");
                    int sign = scanner.nextInt();
                    scanner.nextLine();
                    String[] alerts = {"Temperature Emergency", "Respiratory Emergency", "Dehydration Risk", "Jaundice/Cyanosis", "Neurological Alert"};
                    if (sign >= 1 && sign <= 5) System.out.println("ALERT: " + alerts[sign-1]);
                    break;

                case 10:
                    System.out.println("\nSystem closed.");
                    break;

                default:
                    System.out.println("\nInvalid option.");
                    break;
            }
        } while (option != 10);
        scanner.close();
    }
}
