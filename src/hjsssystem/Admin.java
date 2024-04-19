
package hjsssystem;

import static hjsssystem.MainInterface.checkChoice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    
    private String adminID;
    private String Password;

    public static List <Admin> adminInfo = new ArrayList<>();

    public Admin(String adminID, String Password) {
        this.adminID = adminID;
        this.Password = Password;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getPassword() {
        return Password;
    }

    public static List<Admin> getAdminInfo() {
        Admin a1 = new Admin("ADMIN","pass");
        adminInfo.add(a1);
        return adminInfo;
    }
        
    //Admin Functions Menu
    public static void adminFunctionsMenu(){     
        int selectedOption;
        do {
            selectedOption = adminFunctions();
            switch (selectedOption) {
                case 1 -> ClassLesson.scheduledClasses();
                case 2 -> StudentBooking.view();
                case 3 -> SubmittedReview.viewRatings();
                case 4 -> Student.registerdStudents();
                case 5 -> {
                            ReportCommand instructorReport = new InstructorReportCommand();
                            // Create invoker
                            ReportInvoker invoker = new ReportInvoker();
                            // Set and display instructor report
                            invoker.setReportCommand(instructorReport);
                            invoker.displayReport();
                            
                        }
                case 6 -> {
                            ReportCommand studentReport = new StudentReportCommand();
                            // Create invoker
                            ReportInvoker invoker = new ReportInvoker();

                            // Set and display student report
                            invoker.setReportCommand(studentReport);
                            invoker.displayReport();
                          }
                case 7 -> {
                            LoggedUser.ADMIN_ID = "";
                            return;
                        }
                default -> System.out.println("\nPlease enter a valid choice (1-7)");
            }
        } while (selectedOption != 7);
    }


    
    //Admin Functions Options
    public static int adminFunctions(){     
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nSelect your choice : ");
        System.out.println("1. Want to view Scheduled Classes?");
        System.out.println("2. Want to view booked classes?");
        System.out.println("3. Want to view submitted reviews?");
        System.out.println("4. Want to view registered students?");
        System.out.println("5. Want to view monthly rating report given by the student");
        System.out.println("6. Want to view monthly student report with the number of lessons booked/cancelled and attended");
        System.out.println("7. Logout");
        System.out.print("\nEnter Your Choice : ");

        String menuOption = sc.nextLine();
        while (menuOption.equals("") || !checkChoice(menuOption))
        {
            System.out.print("\nYour Choice is not valid. Please Enter again your choice : ");
            menuOption = sc.nextLine();
        }
        return Integer.parseInt(menuOption);
    }
 
}
