
package hjsssystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class SubmittedReview {
    
    private String StudentBookingID;
    private String StudentID;
    private String ClassLessonID;
    private String WrittenReview;
    private int StarRating;

    public static List <SubmittedReview> reviewInfo = new ArrayList<>();

    public SubmittedReview(String StudentBookingID, String StudentID, String ClassLessonID, String WrittenReview, int StarRating) {
        this.StudentBookingID = StudentBookingID;
        this.StudentID = StudentID;
        this.ClassLessonID = ClassLessonID;
        this.WrittenReview = WrittenReview;
        this.StarRating = StarRating;
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

    public String getWrittenReview() {
        return WrittenReview;
    }

    public int getStarRating() {
        return StarRating;
    }

    public static List<SubmittedReview> getReviewInfo() {
        return reviewInfo;
    }
    
       
    //Attend class
    public static void attend(){
        Scanner sc = new Scanner(System.in);
        
        //Take Lesson Choice
        System.out.print("\nEnter Booking ID for which you want to attend lesson : ");
        String bookingID = sc.nextLine();
        
        //Validate Booking ID
        boolean validateBookingID = ValidateFunction.validateBookingID(bookingID);
        if(!validateBookingID){
            System.out.println("\nYou have entered incorrect Booking ID.");
            return;
        }
                
        String instructor = "";
        String classLessonID = "";
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();
        
        if(studentBookingInfo.size() < 1){
            System.out.println("\nNo Booking Found"); 
            return;
        }
        
        for(StudentBooking obj : studentBookingInfo){
            if(obj.getStudentBookingID().equalsIgnoreCase(bookingID)){
                for(ClassLesson classObj : lessonInfo){
                    if(obj.getClassLessonID().equalsIgnoreCase(classObj.getClassLessonID())){
                        instructor = classObj.getInstructor();
                        classLessonID = classObj.getClassLessonID();
                        break;
                    }
                }
            }
        }
            
        //Is Already cancelled or attended
        boolean validateBookingStatus = ValidateFunction.validateBookingStatus(bookingID);
        if(validateBookingStatus){
            System.out.println("\nYou have already attended or cancelled given Booking ID");
            return;
        }
        
        System.out.print("\nPlease Enter few lines for your class instructor "+instructor+" : ");
        String review = sc.nextLine();
        
        if(review.equalsIgnoreCase("")){
            do{
                System.out.print("\nYou can't skip few lines for your class instructor. Please Enter : ");
                review = sc.nextLine();
            }while(review.equalsIgnoreCase(""));
        }
        
        System.out.println("\n\n------------------------------------------");
        System.out.printf("| %-15s | %-20s |\n","Rating Value","Review");
        System.out.println("------------------------------------------");
        System.out.printf("| %-15s | %-20s |\n","1","Very dissatisfied");
        System.out.printf("| %-15s | %-20s |\n","2","Dissatisfied");
        System.out.printf("| %-15s | %-20s |\n","3","OK");
        System.out.printf("| %-15s | %-20s |\n","4","Satisfied");
        System.out.printf("| %-15s | %-20s |\n","5","Very Satisfied");
        System.out.println("------------------------------------------");
        
        System.out.print("\nPlease Enter Star Rating to give it to your instructor "+instructor+" : ");
        String rating = sc.nextLine();
         
        if(rating.equalsIgnoreCase("") || !MainInterface.checkChoice(rating) || Integer.parseInt(rating) < 1 || Integer.parseInt(rating) > 5){
            do{
                System.out.print("\nYou can't skip Star Rating. Please Enter Correct Star Rating Value : ");
                rating = sc.nextLine();
            }while(rating.equalsIgnoreCase("") || !MainInterface.checkChoice(rating) || Integer.parseInt(rating) < 1 || Integer.parseInt(rating) > 5);
        }
    
        //Add Review
        SubmittedReview obj = new SubmittedReview(bookingID,LoggedUser.STUDENT_ROLL_NO,classLessonID,review,
                Integer.parseInt(rating));
        SubmittedReview.reviewInfo.add(obj);
        
        //Update status
        for(StudentBooking obj1 : studentBookingInfo){
            if(obj1.getStudentBookingID().equalsIgnoreCase(bookingID)){
                obj1.setBookingStatus(StudentBooking.ATTEND);
                break;
            }
        }
        
        //Update available seats by increasing by 1
        ValidateFunction.updateAvailableSeats(classLessonID,0,1);
        
        //Update grade of student if attended higher grade class
        ValidateFunction.updateStudentGrade(LoggedUser.STUDENT_ROLL_NO,classLessonID);
        
        System.out.println("\nYour review has been recorded in the system.");
        return;
        
    }
    
    
     
    //View Ratings
    public static void viewRatings(){
        
        List<SubmittedReview> reviewInfo = SubmittedReview.getReviewInfo();
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();       
        List<Student> studentInfo = Student.getStudentInfo();       
        
        if(reviewInfo.size() < 1){
            System.out.println("\nNo Review Found"); 
            return;
        }

        System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-18s | %-13s | %-40s | %-12s | %-10s | %-30s \n",
                "BookingID","SubmittedBy", "ClassLessonID", "Title", "Instructor","Star Rating","SubmittedReview");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        Set<String> uniqueRecords = new HashSet<>(); 

        for(SubmittedReview reviewObj : reviewInfo){
            for(StudentBooking obj : studentBookingInfo){
                
                if(reviewObj.getStudentBookingID().equalsIgnoreCase(obj.getStudentBookingID())){
                    
                    //Lesson Details
                    String title = "";
                    String instructor = "";
                    for(ClassLesson classObj : lessonInfo){
                        if(obj.getClassLessonID().equalsIgnoreCase(classObj.getClassLessonID())){
                            title = classObj.getTitle();
                            instructor = classObj.getInstructor();
                            break;
                        }
                    }
                    
                    //Student Details
                    String firstname = "";
                    String lastname = "";
                    for(Student studentObj : studentInfo){
                        if(studentObj.getStudentRollNo().equalsIgnoreCase(obj.getStudentID())){
                            firstname = studentObj.getFirstName();
                            lastname = studentObj.getLastName();
                            break;
                        }
                    }

                    //Display
                    if (!uniqueRecords.contains(String.valueOf(reviewObj.getStudentBookingID()))){
                        uniqueRecords.add(String.valueOf(reviewObj.getStudentBookingID()));     

                         System.out.printf("| %-12s | %-18s | %-13s | %-40s | %-12s | %-10s | %-30s \n",
                        reviewObj.getStudentBookingID(),firstname+" "+lastname, obj.getClassLessonID(), title, instructor,reviewObj.getStarRating(),
                        reviewObj.getWrittenReview());
                    }
                }
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
    
    
    
}
