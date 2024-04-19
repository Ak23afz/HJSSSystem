

import hjsssystem.Admin;
import hjsssystem.ClassLesson;
import hjsssystem.LoggedUser;
import hjsssystem.Student;
import hjsssystem.StudentBooking;
import static hjsssystem.StudentBooking.BOOKED;
import static hjsssystem.StudentBooking.CANCEL;
import hjsssystem.ValidateFunction;
import java.util.List;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;


public class HJJSSystemJUnitTesting {
    
    public HJJSSystemJUnitTesting() {
    }

    public static String bookingID = "";
    
    @Test
    public void t1_gradeFilter() {
        System.out.println("\nTest Case 1 : To Filter Class lessons by Given Grade Level");
        String givenGrade = "4" ;
        ClassLesson.scheduledClassesDisplay("",givenGrade,"");
    }
     
     
     
    @Test
    public void t2_login() {
        System.out.println("\nTest Case 2 : To Login the Student to the System");
        String rollNo = "ST41";
        String password = "pass";
        boolean isNotAdmin = true;
        boolean isNotStudent = true;
        List<Student> studentInfo = Student.getStudentInfo();
        List<Admin> adminInfo = Admin.getAdminInfo();
        for(Student obj : studentInfo){
            if(obj.getStudentRollNo().equalsIgnoreCase(rollNo) && obj.getPassword().equalsIgnoreCase(password)){
                LoggedUser.STUDENT_ROLL_NO = obj.getStudentRollNo();
                isNotStudent = false;

                System.out.println("\n--------------------------------");
                System.out.println("You are logged in to the system");
                System.out.println("Your Current Grade Level is : "+obj.getCurrentGradeLevel());
                System.out.println("--------------------------------");
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
                return;
            }
        }
        if(isNotAdmin && isNotStudent){
            System.out.println("\nYou have entered invalid credentials");
            return;
        }
    }
     
    

    @Test
    public void t3_bookLesson() {
        
        System.out.println("\nTest Case 3 : To Book a Lesson");

        String lessonChoice = "Swim_05";
        
        Random random = new Random();
        int studentBookingID = random.nextInt(1000);
        bookingID = "BN"+studentBookingID;
        
        StudentBooking obj = new StudentBooking(bookingID, LoggedUser.STUDENT_ROLL_NO,lessonChoice,BOOKED );
        StudentBooking.studentBookingInfo.add(obj);
        
        System.out.println("\nYour Booking has been confirmed with Booking ID : "+bookingID);
        LoggedUser.IS_BOOKING = 0;
        
        assertTrue(!StudentBooking.studentBookingInfo.isEmpty());
        
    }
     

     

    @Test
    public void t4_bookLesson() {
        
        System.out.println("\nTest Case 4 : To Validate that the student should not book the class which is already booked by him.");
                
        String lessonChoice = "Swim_05";
         
        boolean isTwice = false;
        
        //Is booking duplicate
        boolean validateDuplicateBooking = ValidateFunction.validateDuplicateBooking(lessonChoice, LoggedUser.STUDENT_ROLL_NO);
        if(validateDuplicateBooking){
            System.out.println("\nYou have selected lesson which is already booked by you.");
            isTwice = true;
        }
        assertTrue(isTwice);
    }
     

     

    @Test
    public void t5_bookGradeLevelValidation() {
        System.out.println("\nTest Case 5 : To Validate that the student should not book the class which is lower or higher grade level than his current grade level.");
                
        String lessonChoice = "SWIM_03";
        
        boolean isHigherOrLower = false;
        
        //Is lesson of Current Grade level
        boolean validateIsOfCurrentGrade = ValidateFunction.validateIsOfCurrentGrade(LoggedUser.STUDENT_ROLL_NO,lessonChoice);
        if(validateIsOfCurrentGrade){
                System.out.println("\nYou have selected lesson which is lower or higher than your current grade level.");
                isHigherOrLower = true;
        }
        assertTrue(isHigherOrLower);
    }
     

    @Test
    public void t6_cancelLesson() {
        System.out.println("\nTest Case 6 : To cancel a class.");
        
        //Upadte status
        String status = "";
        String lessonID = "";
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        for(StudentBooking obj : studentBookingInfo){
            if(obj.getStudentBookingID().equalsIgnoreCase(bookingID)){
                lessonID = obj.getClassLessonID();
                obj.setBookingStatus(CANCEL);
                status = obj.getBookingStatus();
                break;
            }
        }
        
        //Update available seats by decreasing by 1
        ValidateFunction.updateAvailableSeats(lessonID,0,1);
        
        System.out.println("\nYour booking has been cancelled by you.");
        assertTrue(status.equalsIgnoreCase(StudentBooking.CANCEL));
        
    }
     
     
     

     
     
}
