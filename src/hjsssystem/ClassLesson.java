
package hjsssystem;

import static hjsssystem.MainInterface.checkChoice;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ClassLesson {
    
    private String ClassLessonID;
    private String Title;
    private int Duration;
    private String ScheduledDay;
    private String Timing;
    private String ScheduledOn;
    private String Instructor;
    private int AvailableVacancy;
    private int ClassGrade;

    private static final String DAY_FILTER = "1";
    private static final String GRADE_FILTER = "2";
    private static final String COACH_FILTER = "3";
    
    
    public static List <ClassLesson> lessonInfo = new ArrayList<>();

    public ClassLesson(String ClassLessonID, String Title, int Duration, String ScheduledDay, String Timing, String ScheduledOn, int AvailableVacancy,
            int ClassGrade, String Instructor) {
        this.ClassLessonID = ClassLessonID;
        this.Title = Title;
        this.Duration = Duration;
        this.ScheduledDay = ScheduledDay;
        this.Timing = Timing;
        this.ScheduledOn = ScheduledOn;
        this.AvailableVacancy = AvailableVacancy;
        this.ClassGrade = ClassGrade;
        this.Instructor = Instructor;
    }

    public String getClassLessonID() {
        return ClassLessonID;
    }

    public String getTitle() {
        return Title;
    }

    public int getDuration() {
        return Duration;
    }

    public String getTiming() {
        return Timing;
    }

    public String getScheduledOn() {
        return ScheduledOn;
    }

    public int getAvailableVacancy() {
        return AvailableVacancy;
    }

    public int getClassGrade() {
        return ClassGrade;
    }

    public String getScheduledDay() {
        return ScheduledDay;
    }

    public String getInstructor() {
        return Instructor;
    }
    
    public static List<ClassLesson> getLessonInfo() {
        ClassLesson c1 = new ClassLesson("SWIM_01","Introduction to Water Skills",1,"Mon","4 to 5pm","08-04-2024",
                4,5,"David");
        ClassLesson c2 = new ClassLesson("SWIM_02","Fundamental Aquatic Skills",1,"Mon","5 to 6pm","08-04-2024",
                4,2,"James");
        ClassLesson c3 = new ClassLesson("SWIM_03","Stroke Development",1,"Mon","6 to 7pm","08-04-2024",
                4,4,"John");
        
        ClassLesson c4 = new ClassLesson("SWIM_04","Stroke Improvement",1,"Wed","4 to 5pm","10-04-2024",
                4,1,"Mandy");
        ClassLesson c5 = new ClassLesson("SWIM_05","Stroke Refinement",1,"Wed","5 to 6pm","10-04-2024",
                4,3,"Sammy");
        ClassLesson c6 = new ClassLesson("SWIM_06","Swimming & Skill Proficiency",1,"Wed","6 to 7pm","10-04-2024",
                4,4,"James");
        
        
        ClassLesson c7 = new ClassLesson("SWIM_07","Introduction to Water Skills",1,"Fri","4 to 5pm","12-04-2024",
                4,2,"Mandy");
        ClassLesson c8 = new ClassLesson("SWIM_08","Fundamental Aquatic Skills",1,"Fri","5 to 6pm","12-04-2024",
                4,3,"John");
        ClassLesson c9 = new ClassLesson("SWIM_09","Stroke Development",1,"Fri","6 to 7pm","12-04-2024",
                4,1,"James");
        
         ClassLesson c10 = new ClassLesson("SWIM_10","Stroke Improvement",1,"Sat","2 to 3pm","13-04-2024",
                4,1,"John");
        ClassLesson c11 = new ClassLesson("SWIM_11","Stroke Refinement",1,"Sat","3 to 4pm","13-04-2024",
                4,3,"David");
        
        
        
        ClassLesson c12 = new ClassLesson("SWIM_12","Introduction to Water Skills",1,"Mon","4 to 5pm","15-04-2024",
                4,5,"David");
        ClassLesson c13 = new ClassLesson("SWIM_13","Fundamental Aquatic Skills",1,"Mon","5 to 6pm","15-04-2024",
                4,2,"James");
        ClassLesson c14 = new ClassLesson("SWIM_14","Stroke Development",1,"Mon","6 to 7pm","15-04-2024",
                4,4,"John");
        
        ClassLesson c15 = new ClassLesson("SWIM_15","Stroke Improvement",1,"Wed","4 to 5pm","17-04-2024",
                4,1,"Mandy");
        ClassLesson c16 = new ClassLesson("SWIM_16","Stroke Refinement",1,"Wed","5 to 6pm","17-04-2024",
                4,3,"Sammy");
        ClassLesson c17 = new ClassLesson("SWIM_17","Swimming & Skill Proficiency",1,"Wed","6 to 7pm","17-04-2024",
                4,4,"James");
        
        
        ClassLesson c18 = new ClassLesson("SWIM_18","Introduction to Water Skills",1,"Fri","4 to 5pm","19-04-2024",
                4,2,"Mandy");
        ClassLesson c19 = new ClassLesson("SWIM_19","Fundamental Aquatic Skills",1,"Fri","5 to 6pm","19-04-2024",
                4,3,"John");
        ClassLesson c20 = new ClassLesson("SWIM_20","Stroke Development",1,"Fri","6 to 7pm","19-04-2024",
                4,1,"James");
        
         ClassLesson c21 = new ClassLesson("SWIM_21","Stroke Improvement",1,"Sat","2 to 3pm","20-04-2024",
                4,1,"John");
        ClassLesson c22 = new ClassLesson("SWIM_22","Stroke Refinement",1,"Sat","3 to 4pm","20-04-2024",
                4,3,"David");
                
        
        ClassLesson c23 = new ClassLesson("SWIM_23","Introduction to Water Skills",1,"Mon","4 to 5pm","22-04-2024",
                4,5,"David");
        ClassLesson c24 = new ClassLesson("SWIM_24","Fundamental Aquatic Skills",1,"Mon","5 to 6pm","22-04-2024",
                4,2,"James");
        ClassLesson c25 = new ClassLesson("SWIM_25","Stroke Development",1,"Mon","6 to 7pm","22-04-2024",
                4,4,"John");
        
        ClassLesson c26 = new ClassLesson("SWIM_26","Stroke Improvement",1,"Wed","4 to 5pm","24-04-2024",
                4,1,"Mandy");
        ClassLesson c27 = new ClassLesson("SWIM_27","Stroke Refinement",1,"Wed","5 to 6pm","24-04-2024",
                4,3,"Sammy");
        ClassLesson c28 = new ClassLesson("SWIM_28","Swimming & Skill Proficiency",1,"Wed","6 to 7pm","24-04-2024",
                4,4,"James");
        
        
        ClassLesson c29 = new ClassLesson("SWIM_29","Introduction to Water Skills",1,"Fri","4 to 5pm","26-04-2024",
                4,2,"Mandy");
        ClassLesson c30 = new ClassLesson("SWIM_30","Fundamental Aquatic Skills",1,"Fri","5 to 6pm","26-04-2024",
                4,3,"John");
        ClassLesson c31 = new ClassLesson("SWIM_31","Stroke Development",1,"Fri","6 to 7pm","26-04-2024",
                4,1,"James");
        
         ClassLesson c32 = new ClassLesson("SWIM_32","Stroke Improvement",1,"Sat","2 to 3pm","27-04-2024",
                4,1,"John");
        ClassLesson c33 = new ClassLesson("SWIM_33","Stroke Refinement",1,"Sat","3 to 4pm","27-04-2024",
                4,3,"David");
        
        
        ClassLesson c34 = new ClassLesson("SWIM_34","Introduction to Water Skills",1,"Mon","4 to 5pm","29-04-2024",
                4,5,"David");
        ClassLesson c35 = new ClassLesson("SWIM_35","Fundamental Aquatic Skills",1,"Mon","5 to 6pm","29-04-2024",
                4,2,"James");
        ClassLesson c36 = new ClassLesson("SWIM_36","Stroke Development",1,"Mon","6 to 7pm","29-04-2024",
                4,4,"John");
        
        ClassLesson c37 = new ClassLesson("SWIM_37","Stroke Improvement",1,"Wed","4 to 5pm","01-05-2024",
                4,1,"Mandy");
        ClassLesson c38 = new ClassLesson("SWIM_38","Stroke Refinement",1,"Wed","5 to 6pm","01-05-2024",
                4,3,"Sammy");
        ClassLesson c39 = new ClassLesson("SWIM_39","Swimming & Skill Proficiency",1,"Wed","6 to 7pm","01-05-2024",
                4,4,"James");
        
        
        ClassLesson c40 = new ClassLesson("SWIM_40","Introduction to Water Skills",1,"Fri","4 to 5pm","03-05-2024",
                4,2,"Mandy");
        ClassLesson c41 = new ClassLesson("SWIM_41","Fundamental Aquatic Skills",1,"Fri","5 to 6pm","03-05-2024",
                4,3,"John");
        ClassLesson c42 = new ClassLesson("SWIM_42","Stroke Development",1,"Fri","6 to 7pm","03-05-2024",
                4,1,"James");
        
         ClassLesson c43 = new ClassLesson("SWIM_43","Stroke Improvement",1,"Sat","2 to 3pm","05-05-2024",
                4,1,"John");
        ClassLesson c44 = new ClassLesson("SWIM_44","Stroke Refinement",1,"Sat","3 to 4pm","05-05-2024",
                4,3,"David");
        
        lessonInfo.add(c1);
        lessonInfo.add(c2);
        lessonInfo.add(c3);
        lessonInfo.add(c4);
        lessonInfo.add(c5);
        lessonInfo.add(c6);
        lessonInfo.add(c7);
        lessonInfo.add(c8);
        lessonInfo.add(c9);
        lessonInfo.add(c10);
        lessonInfo.add(c11);
        lessonInfo.add(c12);
        lessonInfo.add(c13);
        lessonInfo.add(c14);
        lessonInfo.add(c15);
        lessonInfo.add(c16);
        lessonInfo.add(c17);
        lessonInfo.add(c18);
        lessonInfo.add(c19);
        lessonInfo.add(c20);
        lessonInfo.add(c21);
        lessonInfo.add(c22);
        lessonInfo.add(c23);
        lessonInfo.add(c24);
        lessonInfo.add(c25);
        lessonInfo.add(c26);
        lessonInfo.add(c27);
        lessonInfo.add(c28);
        lessonInfo.add(c29);
        lessonInfo.add(c30);
        lessonInfo.add(c31);
        lessonInfo.add(c32);
        lessonInfo.add(c33);
        lessonInfo.add(c34);
        lessonInfo.add(c35);
        lessonInfo.add(c36);
        lessonInfo.add(c37);
        lessonInfo.add(c38);
        lessonInfo.add(c39);
        lessonInfo.add(c40);
        lessonInfo.add(c41);
        lessonInfo.add(c42);
        lessonInfo.add(c43);
        lessonInfo.add(c44);
        return lessonInfo;
    }

    public void setAvailableVacancy(int AvailableVacancy) {
        this.AvailableVacancy = AvailableVacancy;
    }
    
    //View Scheduled Classes
    public static void scheduledClasses(){
        System.out.println("\nEnter 1 to Check Scheduled Classes according to 'Day'");
        System.out.println("Enter 2 to Check Scheduled Classes according to 'Grade'");
        System.out.println("Enter 3 to Check Scheduled Classes according to 'Coach'");
        System.out.println("Enter 4 to Go Back");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nPlease Enter your Choice : ");
        String choice = sc.nextLine();
        
        //Validations
        if(choice.equalsIgnoreCase("")){
           do{
                System.out.print("\nYou can't skip Choice. Please Enter Correct Choice : ");
                choice = sc.nextLine();
            }while(choice.equalsIgnoreCase("")); 
        }
        
        if(choice.equalsIgnoreCase("4")){
           return;
        }
        
        if(choice.equalsIgnoreCase("") || !(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") ||
                 choice.equalsIgnoreCase("3"))){
            do{
                System.out.print("\nYou can't skip Choice. Please Enter Correct Choice : ");
                choice = sc.nextLine();
            }while(choice.equalsIgnoreCase("") || !(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") ||
                 choice.equalsIgnoreCase("3")));
        }
        
        if(choice.equalsIgnoreCase(DAY_FILTER)){
            
            System.out.println("\n(Mon/Wed/Fri/Sat)");
            System.out.print("Please Enter Weekday : ");
            String givenDay = sc.nextLine();

            if(givenDay.equalsIgnoreCase("")){
                do{
                    System.out.print("\nYou can't skip Weekday. Please Enter : ");
                    givenDay = sc.nextLine();
                }while(givenDay.equalsIgnoreCase(""));
            }
            
            if(givenDay.equalsIgnoreCase("Monday")){
                givenDay = "Mon";
            }else if(givenDay.equalsIgnoreCase("Wednesday")){
                givenDay = "Wed";
            }else if(givenDay.equalsIgnoreCase("Friday")){
                givenDay = "Fri";
            }else if(givenDay.equalsIgnoreCase("Saturday")){
                givenDay = "Sat";
            }
            
            if(!(givenDay.equalsIgnoreCase("Mon") || givenDay.equalsIgnoreCase("Wed") || givenDay.equalsIgnoreCase("Fri") ||
                    givenDay.equalsIgnoreCase("Sat"))){
                do{
                    System.out.print("\nYou have entered incorrect Weekday. Please Enter Correct : ");
                    givenDay = sc.nextLine();
                }while(!(givenDay.equalsIgnoreCase("Mon") || givenDay.equalsIgnoreCase("Wed") || givenDay.equalsIgnoreCase("Fri") ||
                    givenDay.equalsIgnoreCase("Sat")));
            }
        
            scheduledClassesDisplay(givenDay,"","");
        }else if(choice.equalsIgnoreCase(GRADE_FILTER)){
            System.out.println("\n(1 to 5)");
            System.out.print("Please Enter Grade Level : ");
            String givenGrade = sc.nextLine();

            if(givenGrade.equalsIgnoreCase("") || !checkChoice(givenGrade) || (Integer.parseInt(givenGrade) < 0 || Integer.parseInt(givenGrade) > 5)){
                do{
                    System.out.print("\nYou can't skip Grade Level. Please Enter Correct : ");
                    givenGrade = sc.nextLine();
                }while(givenGrade.equalsIgnoreCase("") || !checkChoice(givenGrade) || (Integer.parseInt(givenGrade) < 0 || Integer.parseInt(givenGrade) > 5));
            }
            scheduledClassesDisplay("",givenGrade,"");
        }else if(choice.equalsIgnoreCase(COACH_FILTER)){
            System.out.println("\n(David, John, James, Mandy, Sammy)");
            System.out.print("Please Enter Coach Name : ");
            String givenCoach = sc.nextLine();

            if(givenCoach.equalsIgnoreCase("")){
                do{
                    System.out.print("\nYou can't skip Coach Name. Please Enter : ");
                    givenCoach = sc.nextLine();
                }while(givenCoach.equalsIgnoreCase(""));
            }

            if(!(givenCoach.equalsIgnoreCase("David") || givenCoach.equalsIgnoreCase("John") || givenCoach.equalsIgnoreCase("james") ||
                    givenCoach.equalsIgnoreCase("Mandy") || givenCoach.equalsIgnoreCase("Sammy"))){
                do{
                    System.out.print("\nYou have entered incorrect Coach Name. Please Enter Correct : ");
                    givenCoach = sc.nextLine();
                }while(!(givenCoach.equalsIgnoreCase("David") || givenCoach.equalsIgnoreCase("John") || givenCoach.equalsIgnoreCase("james") ||
                    givenCoach.equalsIgnoreCase("Mandy") || givenCoach.equalsIgnoreCase("Sammy")));
            }
            scheduledClassesDisplay("","",givenCoach);
        }
    }
    
    
    //Scheduled classes display
    public static void scheduledClassesDisplay(String givenDay, String givenGrade, String coachName){
       
        System.out.println("\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s | %-15s | %-10s | %-20s | %-20s |\n",
                "ClassLessonID","Title", "ClassGrade","ScheduledDay", "Timing", "ScheduledOn", "Duration", "Instructor", "AvailableVacancy");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();       
        
        Set<String> uniqueRecords = new HashSet<>(); 
        for(ClassLesson obj : lessonInfo){
            if (!uniqueRecords.contains(String.valueOf(obj.getClassLessonID()))){
                uniqueRecords.add(String.valueOf(obj.getClassLessonID()));
                if(!givenDay.equalsIgnoreCase("") && obj.getScheduledDay().equalsIgnoreCase(givenDay)){
                     System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s | %-15s | %-10s | %-20s | %-20s |\n", 
                    obj.getClassLessonID(),obj.getTitle(), obj.getClassGrade(),obj.getScheduledDay(), obj.getTiming(), obj.getScheduledOn(), 
                    obj.getDuration(), obj.getInstructor(), obj.getAvailableVacancy());
                }
                if(!givenGrade.equalsIgnoreCase("") && obj.getClassGrade() == Integer.parseInt(givenGrade)){
                    System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s | %-15s | %-10s | %-20s | %-20s |\n",
                    obj.getClassLessonID(),obj.getTitle(), obj.getClassGrade(),obj.getScheduledDay(), obj.getTiming(), obj.getScheduledOn(), 
                    obj.getDuration(), obj.getInstructor(), obj.getAvailableVacancy());
                }
                if(!coachName.equalsIgnoreCase("") && obj.getInstructor().equalsIgnoreCase(coachName)){
                    System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s | %-15s | %-10s | %-20s | %-20s |\n",
                    obj.getClassLessonID(),obj.getTitle(), obj.getClassGrade(),obj.getScheduledDay(), obj.getTiming(), obj.getScheduledOn(), 
                    obj.getDuration(), obj.getInstructor(), obj.getAvailableVacancy());
                }
                if(coachName.equalsIgnoreCase("") && givenDay.equalsIgnoreCase("") && givenGrade.equalsIgnoreCase("")){
                     System.out.printf("| %-15s | %-30s | %-15s | %-15s | %-12s | %-15s | %-10s | %-20s | %-20s |\n",
                    obj.getClassLessonID(),obj.getTitle(), obj.getClassGrade(),obj.getScheduledDay(), obj.getTiming(), obj.getScheduledOn(), 
                    obj.getDuration(), obj.getInstructor(), obj.getAvailableVacancy());
                }
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        if(LoggedUser.IS_BOOKING == 1){
            StudentBooking.book();
        }
        if(LoggedUser.IS_CHANGING == 1){
            StudentBooking.updateBookingWithNewLesson();
        }
    }
    
    
}
