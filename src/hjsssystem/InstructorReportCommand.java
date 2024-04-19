
package hjsssystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class InstructorReportCommand implements ReportCommand {
    
    @Override
    public void execute() {
        System.out.println("\nDisplaying Instructor Report ...\n");
        
        Scanner  sc = new Scanner(System.in);
        System.out.print("\nEnter Month Number for which you want to generate report : ");
        String month = sc.nextLine();
        
        if(month.equalsIgnoreCase("") || !MainInterface.checkChoice(month) || (Integer.parseInt(month) < 1 || 
                Integer.parseInt(month) > 12)){
            do{
                System.out.print("\nYou can't skip Month Number. Please Enter Valid Month Number (1 to 12) : ");
                month = sc.nextLine();
            }while(month.equalsIgnoreCase("") || !MainInterface.checkChoice(month) || (Integer.parseInt(month) < 1
                    || Integer.parseInt(month) > 12));
        }
        
        List<SubmittedReview> reviewInfo = SubmittedReview.getReviewInfo();
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();        
         
        HashMap<String, Integer> reviews = new HashMap<>();
        HashMap<String, Integer> rows = new HashMap<>();
        HashMap<String, Double> calculate = new HashMap<>();
       
        System.out.println();
       
        for (SubmittedReview obj : reviewInfo){
            for (ClassLesson timetableObj : lessonInfo){
                
                 //Parse class lesson scheduled date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");                
                
                String lessonMonth = "";
                try {
                    LocalDateTime parsedDateTime = LocalDate.parse(timetableObj.getScheduledOn(), formatter).atStartOfDay();
                    lessonMonth = parsedDateTime.format(DateTimeFormatter.ofPattern("M"));
                } catch (DateTimeParseException e) {
                    System.out.println("Error parsing datetime: " + e.getMessage());
                }
                    
                if(timetableObj.getClassLessonID().equalsIgnoreCase(obj.getClassLessonID()) && lessonMonth.equalsIgnoreCase(month)){
                    String instructor = timetableObj.getInstructor();
                    int sumrating = obj.getStarRating();
                    
                    reviews.put(instructor, reviews.getOrDefault(instructor, 0) + sumrating);
                    rows.put(instructor, rows.getOrDefault(instructor, 0) + 1);
                }
            }
        }

        for (String instructor : reviews.keySet()) {
            int findRating = reviews.get(instructor);
            int totalRating = rows.get(instructor);

            if (totalRating > 0) {
                double avg = (double) findRating / totalRating;
                double ans = Math.round(avg * 10.0) / 10.0; 
                calculate.put(instructor, ans);
            }
        }
        if(!calculate.isEmpty()){
            System.out.println("\n--------------------------------------");
            System.out.printf("|%-15s |%-20s| \n", "Instructor", "Average Rating");
            System.out.println("--------------------------------------");
            for (String instructor : calculate.keySet()) {
                double averageRating = calculate.get(instructor);
                System.out.printf("|%-15s| %-20s| \n", instructor, averageRating);
            }
            System.out.println("--------------------------------------");
        }else{
            System.out.println("No Record Exist");
        }
    }
    
}
