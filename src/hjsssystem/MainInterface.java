
package hjsssystem;

import java.util.List;
import java.util.Scanner;


public class MainInterface {

    public static void main(String[] args) {
        System.out.println("\nTo Use 'The Hatfield Junior Swimming School' Software, you have to perform below of the operation : ");
        int selectedOption;
        do {
            selectedOption = mainMenu();
            switch (selectedOption) {
                case 1 -> Student.newStudent();
                case 2 -> alreayHaveAccount();
                case 3 ->{
                             System.out.println("\nThankyou for using 'The Hatfield Junior Swimming School' Software\n\n");
                             System.exit(0);
                        }
                default -> System.out.println("\nPlease enter a valid choice (1-3)");
            }
        } while (selectedOption != 3);
    }
    
    
    //Main Menu
    public static int mainMenu(){     
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nSelect your choice : ");
        System.out.println("1. New Student?");
        System.out.println("2. Already have an account?");
        System.out.println("3. Exit Software");
        System.out.print("\nEnter Your Choice : ");

        String menuOption = sc.nextLine();
        while (menuOption.equals("") || !checkChoice(menuOption))
        {
            System.out.print("\nYour Choice is not valid. Please Enter again your choice : ");
            menuOption = sc.nextLine();
        }
        return Integer.parseInt(menuOption);
    }
 
    
    //Check choice 
    public static boolean checkChoice(String choice)
    {
        if (choice == null || choice.isEmpty()) {
             return false;
         }
         for (int i = 0; i < choice.length(); i++) {
             if (!Character.isDigit(choice.charAt(i))) {
                 return false;
             }
         }
         return true;
    }
     
    
    //Alreay Have Account
    public static void alreayHaveAccount()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter ID : ");
        String rollNo = sc.nextLine();
        
        if(rollNo.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip ID. Please Enter : ");
                rollNo = sc.nextLine();
            }while(rollNo.equalsIgnoreCase(""));
        }
        
        System.out.print("\nEnter Password : ");
        String password = sc.nextLine();
        
        if(password.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip Password. Please Enter : ");
                password = sc.nextLine();
            }while(password.equalsIgnoreCase(""));
        }
        
        List<Student> studentInfo = Student.getStudentInfo();
        List<Admin> adminInfo = Admin.getAdminInfo();
        
        boolean isNotAdmin = true;
        boolean isNotStudent = true;
        
        for(Student obj : studentInfo){
            if(obj.getStudentRollNo().equalsIgnoreCase(rollNo) && obj.getPassword().equalsIgnoreCase(password)){
                LoggedUser.STUDENT_ROLL_NO = obj.getStudentRollNo();
                isNotStudent = false;

                System.out.println("\n--------------------------------");
                System.out.println("You are logged in to the system");
                System.out.println("Your Current Grade Level is : "+obj.getCurrentGradeLevel());
                System.out.println("--------------------------------");
                Student.studentFunctionsMenu();
                return;
            }
        }
        for(Admin obj : adminInfo){
            if(obj.getAdminID().equalsIgnoreCase(rollNo) && obj.getPassword().equalsIgnoreCase(password)){
                LoggedUser.ADMIN_ID = obj.getAdminID();
                isNotAdmin = false;
                System.out.println("\n--------------------------------");
                System.out.println("You are logged in to the system");
                System.out.println("--------------------------------");
                Admin.adminFunctionsMenu();
                return;
            }
        }
        if(isNotAdmin && isNotStudent){
            System.out.println("\nYou have entered invalid credentials");
            return;
        }
    }

  
    

}
