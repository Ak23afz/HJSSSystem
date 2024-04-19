
package hjsssystem;

import static hjsssystem.MainInterface.checkChoice;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class Student {
    
    private String StudentRollNo;
    private String FirstName;
    private String LastName;
    private int Age;
    private int CurrentGradeLevel;
    private String Gender;
    private String CompleteAddress;
    private String ContactNo;
    private String Password;
    
    private static final int MIN_AGE = 4;
    private static final int MAX_AGE = 11;
    private static final int MIN_CURRENT_GRADE = 1;
    private static final int MAX_CURRENT_GRADE = 5;
    
    public static List <Student> studentInfo = new ArrayList<>();

    public Student(String StudentRollNo, String FirstName, String LastName, int Age, int CurrentGradeLevel, String Gender, String CompleteAddress, String ContactNo,
            String Password) {
        this.StudentRollNo = StudentRollNo;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Age = Age;
        this.CurrentGradeLevel = CurrentGradeLevel;
        this.Gender = Gender;
        this.CompleteAddress = CompleteAddress;
        this.ContactNo = ContactNo;
        this.Password = Password;
    }

    public String getStudentRollNo() {
        return StudentRollNo;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }

    public int getCurrentGradeLevel() {
        return CurrentGradeLevel;
    }

    public String getGender() {
        return Gender;
    }

    public String getCompleteAddress() {
        return CompleteAddress;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public String getPassword() {
        return Password;
    }
    
    public void setCurrentGradeLevel(int CurrentGradeLevel) {
        this.CurrentGradeLevel = CurrentGradeLevel;
    }

    public static List<Student> getStudentInfo() {
        
        Student s1 = new Student("ST41","Naomi","Davies",6,2,"M",
                "78 Falsgrave Rd,Scarborough,North Yorkshire,United Kingdom","01723 507700","pass");
        
        Student s2 = new Student("ST38","Jim","Hughes",8,1,"M",
                "5 Murray St,Hartlepool,Cleveland,United Kingdom","01429 222828","pass");
        
        Student s3 = new Student("ST25","Jodie","Kennedy",6,3,"M",
                "57-58 Wind St,Swansea,Glamorgan,United Kingdom","01792 455477","pass");
        
        Student s4 = new Student("ST31","Tim","Harris",9,4,"M",
                "82-86 High St,Newcastle,Staffordshire,United Kingdom","01782 935900","pass");
        
        Student s5 = new Student("ST68","Georgia","Smith",11,5,"M",
                "Coedcae Rd,Pontypridd,Mid Glamorgan,United Kingdom","01443 687057","pass");
        
        Student s6 = new Student("ST17","Layla","Son",10,2,"M",
                "364-368 Smithdown Rd,Liverpool,United Kingdom","0151 733 3655","pass");
        
        Student s7 = new Student("ST28","Sasha","Taylor",4,1,"M",
                "61 Seaside,Eastbourne,United Kingdom","01323 720464","pass");
        
        Student s8 = new Student("ST93","Andrew","Thomp",5,3,"M",
                "Gittisham,Honiton,United Kingdom","01404 540400","pass");
        
        Student s9 = new Student("ST58","Ruth","Smith",6,5,"M",
                "Cochran St,Paisley,United Kingdom","0141 889 8742","pass");
        
        Student s10 = new Student("ST46","Kirsty","Wilson",7,4,"M",
                "38 Bell St,Sawbridgeworth,Hertfordshire,United Kingdom","01279 721050","pass");
        
        Student s11 = new Student("ST40","Greg","Richard",8,1,"M",
                "Queen's Rd,Westbury,Wiltshire,United Kingdom","01373 822695","pass");
        
        Student s12 = new Student("ST21","Owen","Powell",9,4,"M",
                "29 York St,York,United Kingdom","01904 488742","pass");
        
        Student s13 = new Student("ST14","Keeley","Wilson",11,3,"F",
                "450 Sauchiehall St,Glasgow,United Kingdom","0141 332 3355","pass");
        
        Student s14 = new Student("ST57","Lee","Williams",10,3,"M",
                "36 Bondgate Within,Alnwick,United Kingdom","01665 604810","pass");
        
        Student s15 = new Student("ST82","Bradl","Kennedy",6,5,"M",
                "192 Wincheap,Canterbury,United Kingdom","01227 451401","pass");
        
        studentInfo.add(s1);
        studentInfo.add(s2);
        studentInfo.add(s3);
        studentInfo.add(s4);
        studentInfo.add(s5);
        studentInfo.add(s6);
        studentInfo.add(s7);
        studentInfo.add(s8);
        studentInfo.add(s9);
        studentInfo.add(s10);
        studentInfo.add(s11);
        studentInfo.add(s12);
        studentInfo.add(s13);
        studentInfo.add(s14);
        studentInfo.add(s15);
        return studentInfo;
    }
                  
    //New Student
    public static void newStudent(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nRegistration is allowed for "+MIN_AGE+" TO "+MAX_AGE+ " years students\n");
        
        System.out.print("\nPlease Enter your First Name : ");
        String firstName = sc.nextLine();
        
        if(firstName.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip First Name. Please Enter : ");
                firstName = sc.nextLine();
            }while(firstName.equalsIgnoreCase(""));
        }
        
        System.out.print("\nPlease Enter your Last Name : ");
        String lastName = sc.nextLine();
        
        if(lastName.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip Last Name. Please Enter : ");
                lastName = sc.nextLine();
            }while(lastName.equalsIgnoreCase(""));
        }
        
        System.out.print("\nPlease Enter your Password : ");
        String pass = sc.nextLine();
        
        if(pass.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip Password. Please Enter : ");
                pass = sc.nextLine();
            }while(pass.equalsIgnoreCase(""));
        }
        
        System.out.print("\nPlease Enter your Contact No : ");
        String contact = sc.nextLine();
        
        if(contact.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip Contact No. Please Enter : ");
                contact = sc.nextLine();
            }while(contact.equalsIgnoreCase(""));
        }
        
        System.out.print("\nPlease Enter your Gender (M/F): ");
        String gender = sc.nextLine();
        
        if(gender.equalsIgnoreCase("") || (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"))){
            do{
                System.out.print("\nYou can't skip Gender. Please Enter Correct Gender Value : ");
                gender = sc.nextLine();
            }while(gender.equalsIgnoreCase("") || (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")));
        }
                
        System.out.print("\nPlease Enter your Age : ");
        String age = sc.nextLine();
         
        if(age.equalsIgnoreCase("") || !MainInterface.checkChoice(age) || Integer.parseInt(age) < MIN_AGE || Integer.parseInt(age) > MAX_AGE){
            do{
                System.out.print("\nYou can't skip Age. Please Enter Correct Age Value : ");
                age = sc.nextLine();
            }while(age.equalsIgnoreCase("") || !MainInterface.checkChoice(age) || Integer.parseInt(age) < MIN_AGE || Integer.parseInt(age) > MAX_AGE);
        }
    

        System.out.print("\nPlease Enter your Grade Level ("+MIN_CURRENT_GRADE+" TO "+ MAX_CURRENT_GRADE+") : ");
        String grade = sc.nextLine();
        
         
        if(grade.equalsIgnoreCase("") || !MainInterface.checkChoice(grade) || (Integer.parseInt(grade) < 1 || Integer.parseInt(grade) > 5)){
            do{
                System.out.print("\nYou can't skip Grade Level. Please Enter Correct Grade Level Value : ");
                grade = sc.nextLine();
            }while(grade.equalsIgnoreCase("") || !MainInterface.checkChoice(grade) || (Integer.parseInt(grade) < 1 || Integer.parseInt(grade) > 5));
        }
    
        System.out.print("\nPlease Enter your Complete Address : ");
        String completeAddress = sc.nextLine();
        
        if(completeAddress.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip Complete Address. Please Enter : ");
                completeAddress = sc.nextLine();
            }while(completeAddress.equalsIgnoreCase(""));
        }
        
        Random random = new Random();
        int randomTwoDigitNumber = random.nextInt(90) + 10; 
        String studentRollNo = "ST"+randomTwoDigitNumber;
        
        //Add Obj to ArrayList
        Student obj = new Student(studentRollNo,firstName,lastName,Integer.parseInt(age),Integer.parseInt(grade),
                gender,completeAddress,contact,pass);
        Student.studentInfo.add(obj);
        System.out.println("\nCongratulation! You are registered with the system. Your Student ID : "+studentRollNo);
        
    }

    
      
    //Student Functions Menu
    public static void studentFunctionsMenu(){     
        int selectedOption;
        do {
            selectedOption = studentFunctions();
            switch (selectedOption) {
                case 1 -> ClassLesson.scheduledClasses();
                case 2 -> {
                            LoggedUser.IS_BOOKING = 1;
                            ClassLesson.scheduledClasses();
                        }
                case 3 -> {
                            LoggedUser.IS_CHANGING = 1;
                            StudentBooking.change();
                          }
                case 4 -> StudentBooking.cancel();
                case 5 -> SubmittedReview.attend();
                case 6 -> StudentBooking.view();
                case 7 -> {
                            LoggedUser.STUDENT_ROLL_NO = "";
                            LoggedUser.CHANGING_BOOKING_ID= "";
                            LoggedUser.IS_BOOKING = 0;
                            LoggedUser.IS_CHANGING = 0;
                            return;
                        }
                default -> System.out.println("\nPlease enter a valid choice (1-6)");
            }
        } while (selectedOption != 7);
    }

    
    //Student Functions Options
    public static int studentFunctions(){     
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nSelect your choice : ");
        System.out.println("1. Want to view Scheduled Classes?");
        System.out.println("2. Want to book a class?");
        System.out.println("3. Want to change a booked class?");
        System.out.println("4. Want to cancel a booked class?");
        System.out.println("5. Want to attend a booked class?");
        System.out.println("6. Want to view your booked classes?");
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
 
    
    //view registered students
    public static void registerdStudents(){
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-15s | %-80s \n",
                "StudentRollNo","First Name", "Last name","StudentGrade","Age", "Gender", "ContactNo","CompleteAddress");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        Set<String> uniqueRecords = new HashSet<>(); 
        List<Student> studentInfo = Student.getStudentInfo();
        for(Student obj : studentInfo){
            if (!uniqueRecords.contains(String.valueOf(obj.getStudentRollNo()))){
                uniqueRecords.add(String.valueOf(obj.getStudentRollNo()));     

                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-15s | %-80s \n",
                     obj.getStudentRollNo(),obj.getFirstName(), obj.getLastName(),obj.getCurrentGradeLevel(),obj.getAge()+" yrs.", obj.getGender(),
                     obj.getContactNo(),obj.getCompleteAddress());
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
}
