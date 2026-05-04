/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package riyadhmetroproject;

//import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sarah
 */
public class RiyadhMetroProject {


    private static void printMainScreen() {
        System.out.println("\n=====================================");
        System.out.println("      Riyadh Metro Management System");
        System.out.println("=====================================");
        System.out.println("1. Ticketing & Passenger Processing");
        System.out.println("2. Maintenance Management System");
        System.out.println("3. Metro Lines & Station Network"); 

        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void ticketingMenu(TicketingSystem ticketing) {
              Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Ticketing & Passenger Processing ---");
            System.out.println("1. Add new passenger to a machine");
            System.out.println("2. Serve next passenger at a machine");
            System.out.println("3. Who is next (peek) for a machine");
            System.out.println("4. Display all waiting passengers");
            System.out.println("5. Display waiting counts per machine");
            System.out.println("6. Average waiting time (assume 2 minutes per served passenger)");
            System.out.println("7. Back to main menu");
            System.out.print("Choose: ");

            int c = input.nextInt();
            input.nextLine();

            switch (c) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Passenger Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Destination: ");
                    String dest = input.nextLine();

                    ticketing.addPassenger(input.nextInt(),input.nextInt() ,input.nextLine(), input.nextLine());
                    break;

                case 2:
                    ticketing.serveNextPassenger(input.nextInt());
                    break;

                case 3:
                    ticketing.peekNextPassenger(input.nextInt());
                    break;

                case 4:
                    ticketing.displayAllWaitingPassengers();
                    break;

                case 5:
                     ticketing.waitingCount();
                    break;

                case 6:
                    System.out.println("Average Waiting Time = "
                            + ticketing.averageWaitingTime() + " minutes");
                    break;

                case 7:
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    // ---------------------- MAINTENANCE MENU ----------------------

    private static void maintenanceMenu(MaintenanceSystem maintenance) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Maintenance Management ---");
            System.out.println("1. Submit new maintenance request");
            System.out.println("2. Assign work to next available team");
            System.out.println("3. View most critical pending request (peek)");
            System.out.println("4. Display all pending maintenance (sorted)");
            System.out.println("5. Update priority of existing request");
            System.out.println("6. Back to main menu");
            System.out.print("Choose: ");

            int c = input.nextInt();
            input.nextLine();

            switch (c) {

                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = input.nextLine();

                    System.out.println("Enter Priority (1->Low : 2->Medium : 3->High : 4->Critical ? ");
                    int p = input.nextInt();
                    input.nextLine();

                    maintenance.submitTask(id, desc, p);
                    maintenance.submitTask(input.nextInt(), input.nextLine(), input.nextInt());
                    maintenance.submitTask(input.nextInt(), input.nextLine(), input.nextInt());

                    break;

                case 2:
                    maintenance.assignNextTask();
                    break;

                case 3:
                    maintenance.viewMostCritical();
                    break;

                case 4:

                    maintenance.displayAllPendingTasks();
                    break;

                case 5:
                    System.out.print("Enter Task ID to update: ");
                    int uid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new priority: ");
                    int np = input.nextInt();
                    input.nextLine();

                    maintenance.updatePriority(uid, np);
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // ------------------------- 
    private static void metroMenu(MetroNetwork metro) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n--- Metro Lines & Station Network ---");
            System.out.println("Choose line: 1. Orange (Line 1)  2. Yellow (Line 2)  3. Green (Line 3)  4. Back");
            System.out.print("Line: ");
            int lineChoice = input.nextInt();
            input.nextLine();

            CircularDoublyList line = null;
            String lineName = "";
            switch (lineChoice) {
                case 1:
                    line = metro.line1;
                    lineName = "Line 1 (Orange)";
                    break;
                case 2:
                    line = metro.line2;
                    lineName = "Line 2 (Yellow)";
                    break;
                case 3:
                    line = metro.line3;
                    lineName = "Line 3 (Green)";
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid line.");
                    continue;
            }

            while (true) {
                System.out.println("\n--- " + lineName + " ---");
                System.out.println("1. Add station at beginning");
                System.out.println("2. Add station at end");
                System.out.println("3. Insert station between two stations");
                System.out.println("4. Remove station");
                System.out.println("5. Find station");
                System.out.println("6. Display forward");
                System.out.println("7. Display backward");
                System.out.println("8. Count stations");
                System.out.println("9. Shortest route between two stations (same line)");
                System.out.println("10. Duration time between two stations (includes 2min per station wait)");
                System.out.println("11. Back to lines selection");
                System.out.print("Choose: ");
                int opt = input.nextInt();
                input.nextLine();
                switch (opt) {

                    case 1:
                        System.out.println("1. Add station at beginning");
                        System.out.println("Enter the name of the and the time ");
                        line.addFirst(input.nextLine(), input.nextInt());
                        break;
                    case 2:
                        System.out.println("1. Add station at end");
                        System.out.println("Enter the name of the and the time ");
                        line.addLast(input.nextLine(), input.nextInt());
                        break;
                    case 3:
                        System.out.println("1.Insert station between two stations");
                        System.out.println("Enter the name of  befor and after firt then for the staatin new and the time ");
                        line.insertBetween(input.next(), input.next(), input.next(), input.nextInt());
                        break;
                    case 4:
                        System.out.println("Remove station");
                        System.out.println("Enter the name of it ");
                        line.remove(input.nextLine());
                        break;
                    case 5:
                        System.out.println("Find station");
                        System.out.println("Enter the name of it ");
                        line.Find(input.nextLine());
                        break;
                    case 6:
                        System.out.println("Display forward");

                        line.displayForward();
                        break;
                    case 7:
                        System.out.println("displayBackward");
                        line.displayBackward();
                        break;
                    case 8:
                        System.out.println("Count stations");
                        System.out.println(line.count());
                        break;
                    case 9:
                        System.out.println("Shortest route between two stations (same line)");
                        line.printShortestRoute(input.nextLine(), input.nextLine());
                    case 10:
                        System.out.println("Duration time between two stationstwo stations (same line)");
                        line.durationAndCount(input.nextLine(), input.nextLine());
                }

                if (opt == 11) {
                    break;
                }
            }
        }
    }
    // ------------------------- 

private static void directoryMenu(StationDirectory directory) { 
          Scanner input = new Scanner(System.in);
while (true) { 
System.out.println("\n--- Station Directory & Search ---"); 
System.out.println("1. Add new station to directory"); 
System.out.println("2. Search station by ID"); 
System.out.println("3. Find stations within ID range"); 
System.out.println("4. Update station information"); 
System.out.println("5. Remove station"); 
System.out.println("6. Display all stations (sorted by ID)"); 
System.out.println("7. Find min ID station"); 
System.out.println("8. Find max ID station"); 
System.out.println("9. Check if station ID exists"); 
System.out.println("10. Back to main menu"); 
System.out.print("Choose: "); 
int c = input.nextInt(); 
input.nextLine(); 
switch (c) { 
// to be implemented by you  
} 
} 
} 



    public static void main(String[] args) {
      
        Scanner input = new Scanner(System.in);
        TicketingSystem ticketing = new TicketingSystem();
        MaintenanceSystem maintenance = new MaintenanceSystem();
        MetroNetwork metro = new MetroNetwork();
       StationDirectory directory = new StationDirectory(); 

        while (true) {
            printMainScreen();

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    ticketingMenu(ticketing);
                    break;

                case 2:
                    maintenanceMenu(maintenance);
                    break;
                    
                    
                   case 3:
                    metroMenu(metro);
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

//    // ------------------------- 
//    private static void metroMenu(MetroNetwork metro) { 
//        while (true) { 
//              Scanner input = new Scanner(System.in);
//            System.out.println("\n--- Metro Lines & Station Network ---"); 
//            System.out.println("Choose line: 1. Orange (Line 1)  2. Yellow (Line 2)  3. Green (Line 3)  4. Back"); 
//            System.out.print("Line: "); 
//            int lineChoice = input.nextInt(); 
//            input.nextLine(); 
// 
//            CircularDoublyList line = null; 
//            String lineName = ""; 
//            switch (lineChoice) { 
//                case 1: 
//                    line = metro.line1; 
//                    lineName = "Line 1 (Orange)"; 
//                    break; 
//                case 2: 
//                    line = metro.line2; 
//                    lineName = "Line 2 (Yellow)"; 
//                    break; 
//                case 3: 
//                    line = metro.line3; 
//                    lineName = "Line 3 (Green)"; 
//                    break; 
//                case 4: 
//                    return; 
//                default: 
//                    System.out.println("Invalid line."); 
//                    continue; 
//            } 
// 
//            while (true) { 
//                System.out.println("\n--- " + lineName + " ---"); 
//                System.out.println("1. Add station at beginning"); 
//                System.out.println("2. Add station at end"); 
//                System.out.println("3. Insert station between two stations"); 
//                System.out.println("4. Remove station"); 
//                System.out.println("5. Find station"); 
//                System.out.println("6. Display forward"); 
//                System.out.println("7. Display backward"); 
//                System.out.println("8. Count stations"); 
//                System.out.println("9. Shortest route between two stations (same line)"); 
//                System.out.println("10. Duration time between two stations (includes 2min per station wait)"); 
//                System.out.println("11. Back to lines selection"); 
//                System.out.print("Choose: "); 
//                int opt = input.nextInt(); 
//                input.nextLine(); 
//switch (opt) { 
//               
//                    case 1: 
//                      System.out.println("1. Add station at beginning"); 
//                      System.out.println("Enter the name of the and the time "); 
//                      line.addFirst( input.nextLine(), input.nextInt());
//                     break; 
//                     case 2: 
//                      System.out.println("1. Add station at end"); 
//                      System.out.println("Enter the name of the and the time "); 
//                      line.addLast(input.nextLine(), input.nextInt());
//                     break; 
//                     case 3: 
//                      System.out.println("1.Insert station between two stations"); 
//                      System.out.println("Enter the name of  befor and after firt then for the staatin new and the time "); 
//                      line.insertBetween(input.next(),input.next(),input.next(), input.nextInt());
//                     break;
//                     case 4: 
//                      System.out.println("Remove station"); 
//                      System.out.println("Enter the name of it "); 
//                      line.remove(input.nextLine());
//                     break;
//                      case 5: 
//                      System.out.println("Find station"); 
//                      System.out.println("Enter the name of it "); 
//                      line.Find(input.nextLine());
//                     break;
//                      case 6: 
//                      System.out.println("Display forward"); 
//                     
//                      line.displayBackward();
//                     break;
//                     case 7: 
//                      System.out.println("displayBackward");
//                      line.displayBackward();
//                     break;
//                      case 8: 
//                      System.out.println("Count stations");
//                       System.out.println( line.count());
//                     break;
//                     case 9: 
//                    System.out.println("Shortest route between two stations (same line)") ;
//                    line.printShortestRoute(input.nextLine(),input.nextLine());
//                    case 10: 
//                    System.out.println("Duration time between two stationstwo stations (same line)") ;
//                    line.durationAndCount(input.nextLine(),input.nextLine());
//} 
//
//if (opt == 11) break; 
//} 
//} 
//} 
// ------------------------- 
}

//package RiyadhMetroProject; 
// 
//import java.util.Scanner; 
//import java.util.InputMismatchException; 
// 
///** 
// * Main class for Riyadh Metro Management System 
// * Integrates: TicketingSystem, MaintenanceSystem, MetroNetwork (3 circular lines), StationDirectory 
// * 
//* You can implement those classes with the data structures described in the project. 
// */ 
//public class Main { 
// 
//    private static final Scanner input = new Scanner(System.in); 
// 
//    public static void main(String[] args) { 
// 
//        // Subsystems (must be implemented separately) 
//        TicketingSystem ticketing = new TicketingSystem(); 
//        MaintenanceSystem maintenance = new MaintenanceSystem(); 
//        MetroNetwork metro = new MetroNetwork(); 
//        StationDirectory directory = new StationDirectory(); 
// 
//        // ... you can add more classes or data  
// 
//        while (true) { 
//            printMainScreen(); 
// 
//            int selection = input.nextInt(); 
//       // each one print a special menu  
//            switch (selection) { 
//                case 1: 
//                    ticketingMenu(ticketing); 
//                    break; 
//                case 2: 
//                    maintenanceMenu(maintenance); 
//                    break; 
//                case 3: 
//                    metroMenu(metro); 
//                    break; 
//                case 4: 
//                    directoryMenu(directory); 
//                    break; 
//                case 5: 
//                    integrationMenu(ticketing, metro, directory, maintenance); 
//                    break; 
//                case 6: 
//                    System.out.println("Exiting the system..."); 
//                    return; 
//                default: 
//                    System.out.println("Invalid choice. Try again."); 
//            } 
//        } 
//    }
//   
//    private static void printMainScreen() { 
//        System.out.println("\n====================================="); 
//        System.out.println("      Riyadh Metro Management System"); 
//        System.out.println("====================================="); 
//        System.out.println("1. Ticketing & Passenger Processing"); 
//        System.out.println("2. Maintenance Management System"); 
//        System.out.println("3. Metro Lines & Station Network"); 
//        System.out.println("4. Station Directory & Search"); 
//        System.out.println("5. Exit "); 
// 
//        System.out.print("Choose an option: "); 
//    } 
// 
//    // ------------------------- 
//    // Ticketing Menu 
//    // ------------------------- 
//    private static void ticketingMenu(TicketingSystem ticketing) { 
//        while (true) { 
//            System.out.println("\n--- Ticketing & Passenger Processing ---"); 
//            System.out.println("1. Add new passenger to a machine"); 
//            System.out.println("2. Serve next passenger at a machine"); 
//            System.out.println("3. Who is next (peek) for a machine"); 
//            System.out.println("4. Display all waiting passengers"); 
//            System.out.println("5. Display waiting counts per machine"); 
//            System.out.println("6. Average waiting time (assume 2 minutes per served passenger)"); 
//            System.out.println("7. Back to main menu"); 
//            System.out.print("Choose: "); 
//            int c = input.nextInt(); 
//            input.nextLine(); // clear newline 
// 
//            switch (c) { 
//            // to be implemented by you  
//            } 
//        } 
//    } 
// 
//    // ------------------------- 
//    // Maintenance Menu 
//    // ------------------------- 
//    private static void maintenanceMenu(MaintenanceSystem maintenance) { 
//        while (true) { 
//            System.out.println("\n--- Maintenance Management ---"); 
//            System.out.println("1. Submit new maintenance request"); 
//            System.out.println("2. Assign work to next available team"); 
//            System.out.println("3. View most critical pending request (peek)"); 
//            System.out.println("4. Display all pending maintenance (sorted by priority)"); 
//            System.out.println("5. Update priority of existing request"); 
//            System.out.println("6. Back to main menu"); 
//            System.out.print("Choose: "); 
//            int c = input.nextInt(); 
//            input.nextLine(); 
// 
//            switch (c) { 
//            // to be implemented by you  
//            } 
//        } 
//    } 
// 
//    // ------------------------- 
//    // Metro Lines & Network Menu 
//    // ------------------------- 
//    private static void metroMenu(MetroNetwork metro) { 
//        while (true) { 
//            System.out.println("\n--- Metro Lines & Station Network ---"); 
//            System.out.println("Choose line: 1. Orange (Line 1)  2. Yellow (Line 2)  3. Green (Line 3)  4. 
//Back"); 
//            System.out.print("Line: "); 
//            int lineChoice = input.nextInt(); 
//            input.nextLine(); 
// 
//            CircularLine line = null; 
//            String lineName = ""; 
//            switch (lineChoice) { 
//                case 1: 
//                    line = metro.line1; 
//                    lineName = "Line 1 (Orange)"; 
//                    break; 
//                case 2: 
//                    line = metro.line2; 
//                    lineName = "Line 2 (Yellow)"; 
//                    break; 
//                case 3: 
//                    line = metro.line3; 
//                    lineName = "Line 3 (Green)"; 
//                    break; 
//                case 4: 
//                    return; 
//                default: 
//                    System.out.println("Invalid line."); 
//                    continue; 
//            } 
// 
//            while (true) { 
//                System.out.println("\n--- " + lineName + " ---"); 
//                System.out.println("1. Add station at beginning"); 
//                System.out.println("2. Add station at end"); 
//                System.out.println("3. Insert station between two stations"); 
//                System.out.println("4. Remove station"); 
//                System.out.println("5. Find station"); 
//                System.out.println("6. Display forward"); 
//                System.out.println("7. Display backward"); 
//                System.out.println("8. Count stations"); 
//                System.out.println("9. Shortest route between two stations (same line)"); 
//                System.out.println("10. Duration time between two stations (includes 2min per station 
//wait)"); 
//                System.out.println("11. Back to lines selection"); 
//                System.out.print("Choose: "); 
//                int opt = input.nextInt(); 
//                input.nextLine(); 
//switch (opt) { 
//// to be implemented by you  
//} 
//if (opt == 11) break; 
//} 
//} 
//} 
//// ------------------------- 
//// Station Directory Menu 
//// ------------------------- 
//private static void directoryMenu(StationDirectory directory) { 
//while (true) { 
//System.out.println("\n--- Station Directory & Search ---"); 
//System.out.println("1. Add new station to directory"); 
//System.out.println("2. Search station by ID"); 
//System.out.println("3. Find stations within ID range"); 
//System.out.println("4. Update station information"); 
//System.out.println("5. Remove station"); 
//System.out.println("6. Display all stations (sorted by ID)"); 
//System.out.println("7. Find min ID station"); 
//System.out.println("8. Find max ID station"); 
//System.out.println("9. Check if station ID exists"); 
//System.out.println("10. Back to main menu"); 
//System.out.print("Choose: "); 
//int c = input.nextInt(); 
//input.nextLine(); 
//switch (c) { 
//// to be implemented by you  
//} 
//} 
//} 
//// ------------------------- 
//} 
//}
////        
////  
////    
