
package hjsssystem;

import java.util.List;

public class ValidateFunction {
        
    //Validate lesson choice
    public static boolean validateLessonChoice(String lessonChoice){
        boolean isValidated = false;
        
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();
         for(ClassLesson obj : lessonInfo){
            if(obj.getClassLessonID().equalsIgnoreCase(lessonChoice)){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    //Validate duplicate booking
    public static boolean validateDuplicateBooking(String lessonChoice, String studentRollNo){
        boolean isValidated = false;
        
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        for(StudentBooking obj : studentBookingInfo){
            if(obj.getStudentID().equalsIgnoreCase(studentRollNo) && obj.getClassLessonID().equalsIgnoreCase(lessonChoice) &&
                    (obj.getBookingStatus().equalsIgnoreCase(StudentBooking.BOOKED) || obj.getBookingStatus().equalsIgnoreCase(StudentBooking.CHANGE))){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    //Validate booking id
    public static boolean validateBookingID(String bookingID){
        boolean isValidated = false;
        
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        for(StudentBooking obj : studentBookingInfo){
            if(obj.getStudentBookingID().equalsIgnoreCase(bookingID)){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    
    //Validate booking status
    public static boolean validateBookingStatus(String bookingID){
        boolean isValidated = false;
        
        List<StudentBooking> studentBookingInfo = StudentBooking.getStudentBookingInfo();
        for(StudentBooking obj : studentBookingInfo){
            if(obj.getStudentBookingID().equalsIgnoreCase(bookingID) &&
                    (obj.getBookingStatus().equalsIgnoreCase(StudentBooking.ATTEND) || obj.getBookingStatus().equalsIgnoreCase(StudentBooking.CANCEL))){
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
    
    
    //Validate lesson is of current grade
    public static boolean validateIsOfCurrentGrade(String studentRollNo, String lessonChoice){
        boolean isValidated = false;
        int studentGradeLevel  = 0;
        int lessonGradeLevel  = 0;
        //Lesson Grade
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();
         for(ClassLesson obj : lessonInfo){
            if(obj.getClassLessonID().equalsIgnoreCase(lessonChoice)){
                lessonGradeLevel = obj.getClassGrade();
                break;
            }
        }
        //Student current  Grade
        List<Student> studentInfo = Student.getStudentInfo();
         for(Student obj : studentInfo){
            if(obj.getStudentRollNo().equalsIgnoreCase(studentRollNo)){
                studentGradeLevel = obj.getCurrentGradeLevel();
                break;
            }
        }
       
        if(lessonGradeLevel > (studentGradeLevel + 1) || (lessonGradeLevel < studentGradeLevel)){
            isValidated = true;
        }
        return isValidated;
    }
    
    //Update available seats of lessons
    public static boolean updateAvailableSeats(String lessonChoice, int minus, int plus){
        boolean isValidated = false;
        
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();
         for(ClassLesson obj : lessonInfo){
            if(obj.getClassLessonID().equalsIgnoreCase(lessonChoice) && minus != 0){
                obj.setAvailableVacancy(obj.getAvailableVacancy()-minus);
                break;
            }
            else if(obj.getClassLessonID().equalsIgnoreCase(lessonChoice) && plus != 0){
                obj.setAvailableVacancy(obj.getAvailableVacancy()+plus);
                break;
            }
        }
        return isValidated;
    }
    
    
    //Is Seats available
    public static boolean validateAvailableSeat(String lessonChoice){
        boolean isValidated = false;
        int seats = 0;
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();
         for(ClassLesson obj : lessonInfo){
            if(obj.getClassLessonID().equalsIgnoreCase(lessonChoice)){
                seats = obj.getAvailableVacancy();
                break;
            }
        }
        if(seats == 0){
            isValidated = true;
        }
        return isValidated;
    }
    
    //Upadte student grade after attending higher grade level class
    public static void updateStudentGrade(String studentRollNo, String lessonChoice){
        int studentGradeLevel  = 0;
        int lessonGradeLevel  = 0;
        //Lesson Grade
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();
         for(ClassLesson obj : lessonInfo){
            if(obj.getClassLessonID().equalsIgnoreCase(lessonChoice)){
                lessonGradeLevel = obj.getClassGrade();
                break;
            }
        }
         
        //Student current  Grade
        List<Student> studentInfo = Student.getStudentInfo();
         for(Student obj : studentInfo){
            if(obj.getStudentRollNo().equalsIgnoreCase(studentRollNo)){
                studentGradeLevel = obj.getCurrentGradeLevel();
                break;
            }
        }
       
         //Update current grade level
        if(lessonGradeLevel > studentGradeLevel){
            for(Student obj : studentInfo){
               if(obj.getStudentRollNo().equalsIgnoreCase(studentRollNo)){
                   obj.setCurrentGradeLevel(obj.getCurrentGradeLevel()+1);
                   break;
               }
           }
        }
    }

}
