
package hjsssystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


public class StudentBooking {
 
    
    private String StudentBookingID;
    private String StudentID;
    private String ClassLessonID;
    private String BookingStatus;

    public static final String BOOKED = "Booked";
    public static final String CHANGE = "Changed";
    public static final String ATTEND = "Attended";
    public static final String CANCEL = "Cancelled";

    public static List <StudentBooking> studentBookingInfo = new ArrayList<>();

    public StudentBooking(String StudentBookingID, String StudentID, String ClassLessonID, String BookingStatus) {
        this.StudentBookingID = StudentBookingID;
        this.StudentID = StudentID;
        this.ClassLessonID = ClassLessonID;
        this.BookingStatus = BookingStatus;
    }

    public String getStudentBookingID() {
        return StudentBookingID;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getClassLessonID() {
        return ClassLessonID;
    }

    public String getBookingStatus() {
        return BookingStatus;
    }

    public static List<StudentBooking> getStudentBookingInfo() {
        return studentBookingInfo;
    }

    public void setClassLessonID(String ClassLessonID) {
        this.ClassLessonID = ClassLessonID;
    }

    public void setBookingStatus(String BookingStatus) {
        this.BookingStatus = BookingStatus;
    }
        
    //Book class
    public static void book(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nEnter 1 to Schedule a Class");
        System.out.println("Enter 2 to Go Back");
        
        System.out.print("\nPlease Enter your Choice : ");
        String choice = sc.nextLine();
        
        //Validations
        if(choice.equalsIgnoreCase("")){
           do{
                System.out.print("\nYou can't skip Choice. Please Enter Correct Choice : ");
                choice = sc.nextLine();
            }while(choice.equalsIgnoreCase("")); 
        }
        
       
        if(choice.equalsIgnoreCase("") || !(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2"))){
            do{
                System.out.print("\nYou can't skip Choice. Please Enter Correct Choice : ");
                choice = sc.nextLine();
            }while(choice.equalsIgnoreCase("") || !(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2")));
        }
        
         if(choice.equalsIgnoreCase("2")){
           return;
        }
        
        //Take Lesson Choice
        System.out.print("\nEnter Your Choice of Class Lesson ID : ");
        String lessonChoice = sc.nextLine();
        if(choice.equalsIgnoreCase("1")){
            if(lessonChoice.equalsIgnoreCase("")){
                do{
                    System.out.print("\nYou can't skip Your Choice of Class Lesson. Please Enter : ");
                    lessonChoice = sc.nextLine();
                }while(lessonChoice.equalsIgnoreCase(""));
            }
        }
        
        //Validate lesson Class ID
        boolean validateLessonChoice = ValidateFunction.validateLessonChoice(lessonChoice);
        if(!validateLessonChoice){
            System.out.println("\nYou have entered incorrect Class Lesson ID.");
            return;
        }
        
        //If No Seat
        boolean validateAvailableSeat = ValidateFunction.validateAvailableSeat(lessonChoice);
        if(validateAvailableSeat){
            System.out.println("\nNo Seat is available for selected Lesson.");
            return;
        }
        
        
        //Is booking duplicate
        boolean validateDuplicateBooking = ValidateFunction.validateDuplicateBooking(lessonChoice, LoggedUser.STUDENT_ROLL_NO);
        if(validateDuplicateBooking){
            System.out.println("\nYou have selected lesson which is already booked by you.");
            return;
        }
        
        //Is lesson of Current Grade level
        boolean validateIsOfCurrentGrade = ValidateFunction.validateIsOfCurrentGrade(LoggedUser.STUDENT_ROLL_NO,lessonChoice);
        if(validateIsOfCurrentGrade){
                System.out.println("\nYou have selected lesson which is lower or higher than your current grade level.");
                return;
        }
               
        Random random = new Random();
        int studentBookingID = random.nextInt(1000);
        String bookingID = "BN"+studentBookingID;
        
        StudentBooking obj = new StudentBooking(bookingID, LoggedUser.STUDENT_ROLL_NO,lessonChoice,BOOKED );
        StudentBooking.studentBookingInfo.add(obj);
        
        //Update available seats by decreasing by 1
        ValidateFunction.updateAvailableSeats(lessonChoice,1,0);
        
        System.out.println("\nYour Booking has been confirmed with Booking ID : "+bookingID);
        LoggedUser.IS_BOOKING = 0;
        return;        
    }
        
    //Change class
    public static void change(){
        Scanner sc = new Scanner(System.in);
        
        //Take Lesson Choice
        System.out.print("\nEnter Booking ID for which you want to change lesson : ");
        String bookingID = sc.nextLine();
        
        //Validate Booking ID
        boolean validateBookingID = ValidateFunction.validateBookingID(bookingID);
        if(!validateBookingID){
            System.out.println("\nYou have entered incorrect Booking ID.");
            return;
        }
        
        //Is Already cancelled or attended
        boolean validateBookingStatus = ValidateFunction.validateBookingStatus(bookingID);
        if(validateBookingStatus){
            System.out.println("\nYou have already attended or cancelled given Booking ID");
            return;
        }
        
        LoggedUser.CHANGING_BOOKING_ID = bookingID;
        System.out.println("\nSelect New Lesson To Update : ");

        ClassLesson.scheduledClasses();
        LoggedUser.CHANGING_BOOKING_ID = "";
        LoggedUser.IS_CHANGING = 0;
    }
    
        
        
    //Change class with new lesson
    public static void updateBookingWithNewLesson(){
        Scanner sc = new Scanner(System.in);
        String bookingID = LoggedUser.CHANGING_BOOKING_ID;

        System.out.print("\nEnter Your Choice of Class Lesson ID : ");
        String lessonChoice = sc.nextLine();
        if(lessonChoice.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip Your Choice of Class Lesson. Please Enter : ");
                lessonChoice = sc.nextLine();
            }while(lessonChoice.equalsIgnoreCase(""));
        }
        
        //Validate lesson Class ID
        boolean validateLessonChoice = ValidateFunction.validateLessonChoice(lessonChoice);
        if(!validateLessonChoice){
            System.out.println("\nYou have entered incorrect Class Lesson ID.");
            return;
        }
          
        //If No Seat
        boolean validateAvailableSeat = ValidateFunction.validateAvailableSeat(lessonChoice);
        if(validateAvailableSeat){
            System.out.println("\nNo Seat is available for selected Lesson.");
            return;
        }
      
        //Is booking duplicate
        boolean validateDuplicateBooking = ValidateFunction.validateDuplicateBooking(lessonChoice, LoggedUser.STUDENT_ROLL_NO);
        if(validateDuplicateBooking){
            System.out.println("\nYou have selected lesson which is already booked by you.");
            return;
        }
               
        //Is lesson of Current Grade level
        boolean validateIsOfCurrentGrade = ValidateFunction.validateIsOfCurrentGrade(lessonChoice, LoggedUser.STUDENT_ROLL_NO);
        if(validateIsOfCurrentGrade){
                System.out.println("\nYou have selected lesson which is lower or higher than your current grade level.");
                return;
        }
        
        //Update new lesson ans status
        String lessonID = "";
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        for(StudentBooking obj : studentBookingInfo){
            if(obj.getStudentBookingID().equalsIgnoreCase(bookingID)){
                lessonID = obj.getClassLessonID();
                obj.setClassLessonID(lessonChoice);
                obj.setBookingStatus(CHANGE);
                break;
            }
        }
         //Update available seats by decreasing by 1
        ValidateFunction.updateAvailableSeats(lessonChoice,1,0);
        
        //Update available seats by increasing by 1
        ValidateFunction.updateAvailableSeats(lessonID,0,1);
        
        System.out.println("\nYour booking has been updated with new lesson.");
        return;
    }
    
        
    //Cancel class
    public static void cancel(){
        Scanner sc = new Scanner(System.in);
        
        //Take Lesson Choice
        System.out.print("\nEnter Booking ID for which you want to cancel lesson : ");
        String bookingID = sc.nextLine();
        
        //Validate Booking ID
        boolean validateBookingID = ValidateFunction.validateBookingID(bookingID);
        if(!validateBookingID){
            System.out.println("\nYou have entered incorrect Booking ID.");
            return;
        }
        
        
        //Is Already cancelled or attended
        boolean validateBookingStatus = ValidateFunction.validateBookingStatus(bookingID);
        if(validateBookingStatus){
            System.out.println("\nYou have already attended or cancelled given Booking ID");
            return;
        }
        
        
        //Upadte status
        String lessonID = "";
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        for(StudentBooking obj : studentBookingInfo){
            if(obj.getStudentBookingID().equalsIgnoreCase(bookingID)){
                lessonID = obj.getClassLessonID();
                obj.setBookingStatus(CANCEL);
                break;
            }
        }
        
        //Update available seats by decreasing by 1
        ValidateFunction.updateAvailableSeats(lessonID,0,1);
        
        System.out.println("\nYour booking has been cancelled by you.");
        return;
    }
    
    
    //View booking
    public static void view(){
        
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();       
        List<Student> studentInfo = Student.getStudentInfo();       
        
        if(studentBookingInfo.size() < 1){
            System.out.println("\nNo Booking Found"); 
            return;
        }

        System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-16s | %-13s | %-15s | %-30s | %-12s | %-15s | %-10s | %-15s | %-11s | %-8s |\n",
                "BookingID","BookedBy", "StudentGrade","ClassLessonID", "Title", "LessonGrade","ScheduledDay","Timing","ScheduledOn", 
                "Instructor","Status");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        
        Set<String> uniqueRecords = new HashSet<>(); 

        for(StudentBooking obj : studentBookingInfo){
            
            //Lesson Details
            String title = "";
            String classGrade = "";
            String scheduledDay = "";
            String scheduledOn = "";
            String timing = "";
            String instructor = "";
            for(ClassLesson classObj : lessonInfo){
                if(obj.getClassLessonID().equalsIgnoreCase(classObj.getClassLessonID())){
                    title = classObj.getTitle();
                    classGrade = String.valueOf(classObj.getClassGrade());
                    scheduledDay = classObj.getScheduledDay();
                    scheduledOn = classObj.getScheduledOn();
                    timing = classObj.getTiming();
                    instructor = classObj.getInstructor();
                    break;
                }
            }
            
            //Student Details
            String firstname = "";
            String lastname = "";
            String studentGrade = "";
            for(Student studentObj : studentInfo){
                if(studentObj.getStudentRollNo().equalsIgnoreCase(obj.getStudentID())){
                    firstname = studentObj.getFirstName();
                    lastname = studentObj.getLastName();
                    studentGrade = String.valueOf(studentObj.getCurrentGradeLevel());
                    break;
                }
            }
            
            //Display
            if (!uniqueRecords.contains(String.valueOf(obj.getStudentBookingID()))){
                uniqueRecords.add(String.valueOf(obj.getStudentBookingID()));     
                
                //If Student
                if(!LoggedUser.STUDENT_ROLL_NO.equalsIgnoreCase("") && obj.getStudentID().equalsIgnoreCase(LoggedUser.STUDENT_ROLL_NO)){
                      System.out.printf("| %-12s | %-16s | %-13s | %-15s | %-30s | %-12s | %-15s | %-10s | %-15s | %-11s | %-8s |\n",
                        obj.getStudentBookingID(),firstname+" "+lastname, studentGrade,obj.getClassLessonID(), title, classGrade,scheduledDay,
                        timing,scheduledOn, instructor,obj.getBookingStatus());
                //If Admin
                }else if(!LoggedUser.ADMIN_ID.equalsIgnoreCase("")){
                    System.out.printf("| %-12s | %-16s | %-13s | %-15s | %-30s | %-12s | %-15s | %-10s | %-15s | %-11s | %-8s |\n",
                        obj.getStudentBookingID(),firstname+" "+lastname, studentGrade,obj.getClassLessonID(), title, classGrade,scheduledDay,
                        timing,scheduledOn, instructor,obj.getBookingStatus());
                }
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    
    
}
