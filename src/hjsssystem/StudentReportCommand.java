
package hjsssystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentReportCommand implements ReportCommand {
    
    
    @Override
    public void execute() {
        System.out.println("\nDisplaying Student Report ...\n");
        
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

        List<StudentBooking> bookingInfo = StudentBooking.getStudentBookingInfo();
        List<ClassLesson> lessonInfo = ClassLesson.getLessonInfo();        
        List<Student> studentInfo = Student.getStudentInfo();
       
        System.out.println();

        HashMap<String, int[]> students = new HashMap<>();
        Set<String> uniqueLearnerCode = new HashSet<>();             
        for (int j = 0; j < bookingInfo.size(); j++) {

            for (int i = 0; i < studentInfo.size(); i++) {
                String monthNumber = "";
                for (ClassLesson classObj : lessonInfo) {

                    if(classObj.getClassLessonID().equalsIgnoreCase(bookingInfo.get(j).getClassLessonID())){
                        //Parse timetable classOn field
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");                

                        try {
                            LocalDateTime parsedDateTime = LocalDate.parse(classObj.getScheduledOn(), formatter).atStartOfDay();
                            monthNumber = parsedDateTime.format(DateTimeFormatter.ofPattern("M"));
                        } catch (DateTimeParseException e) {
                            System.out.println("Error parsing datetime: " + e.getMessage());
                        }
                        break;
                    }
                }

                String uniqueKey = String.valueOf(studentInfo.get(i).getStudentRollNo()) + bookingInfo.get(j).getStudentBookingID();

                if (!uniqueLearnerCode.contains(uniqueKey)) {
                    uniqueLearnerCode.add(uniqueKey);

                    if (studentInfo.get(i).getStudentRollNo().equalsIgnoreCase(bookingInfo.get(j).getStudentID()) && 
                            monthNumber.equalsIgnoreCase(month)) {

                        String uniqueCode = studentInfo.get(i).getStudentRollNo();
                        int[] counter = students.getOrDefault(uniqueCode, new int[3]);

                        if (bookingInfo.get(j).getBookingStatus().equalsIgnoreCase(StudentBooking.BOOKED) 
                                || bookingInfo.get(j).getBookingStatus().equalsIgnoreCase(StudentBooking.CHANGE)) {
                            counter[0]++;
                        }
                        if (bookingInfo.get(j).getBookingStatus().equalsIgnoreCase(StudentBooking.CANCEL)) {
                            counter[1]++;
                        }
                        if (bookingInfo.get(j).getBookingStatus().equalsIgnoreCase(StudentBooking.ATTEND)) {
                            counter[2]++;
                        }
                        students.put(uniqueCode, counter);
                    }
                }
            }
        }
        
        if(!students.isEmpty()){
            int record =1;
            for (Map.Entry<String, int[]> entry : students.entrySet()) {
                String rollNo = entry.getKey();
                int[] counter = entry.getValue();

                //User details
                String firstName = "";
                String lastName = "";
                int studentGrade = 0;
                int age = 0;
                for (int i = 0; i < studentInfo.size(); i++) {
                   if(studentInfo.get(i).getStudentRollNo().equalsIgnoreCase(rollNo)){
                       firstName = studentInfo.get(i).getFirstName();
                       lastName = studentInfo.get(i).getLastName();
                       studentGrade = studentInfo.get(i).getCurrentGradeLevel();
                       age = studentInfo.get(i).getAge();
                   }
                }
                System.out.println("\n\nStudent : "+record);

                System.out.println("\nFirst Name : "+ firstName+"\tLast Name : "+lastName+"\tCurrent Grade : "+studentGrade+""
                        + "\tAge : "+age+" yrs.\n");
                
                System.out.println("\nNo Of Booked Lessons : "+counter[0]);
                System.out.println("No Of Cancelled Lessons : "+counter[1]);
                System.out.println("No Of Attended Lessons : "+counter[2]);
                
                System.out.println("\nClass Details as follows : ");
                System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("|%-15s| %-30s| %-12s| %-15s| %-15s| %-15s| %-15s|\n",
                        "ClassLessonID", "Title", "Timing", "Scheduled On","Class Grade","Instructor","Booking Status");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------");

                for (int j = 0; j < bookingInfo.size(); j++) {
                    if(bookingInfo.get(j).getStudentID().equalsIgnoreCase(rollNo)){
                        //Class Detail
                        String title = "";
                        String timing = "";
                        String scheduledOn = "";
                        String instructor = "";
                        int gradeLevel = 0;
                        for (ClassLesson classObj : lessonInfo) {
                            if(classObj.getClassLessonID().equalsIgnoreCase(bookingInfo.get(j).getClassLessonID())){
                                title = classObj.getTitle();
                                timing = classObj.getTiming();
                                instructor = classObj.getInstructor();
                                scheduledOn = classObj.getScheduledOn();
                                gradeLevel = classObj.getClassGrade();
                            }
                        }
                        System.out.printf("|%-15s| %-30s |%-12s| %-15s| %-15s| %-15s| %-15s|\n",
                        bookingInfo.get(j).getClassLessonID(), title, timing, scheduledOn,gradeLevel,
                        instructor,bookingInfo.get(j).getBookingStatus());
                    }
                }               
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                record++;
            }

        }else{
             System.out.println("No Record Exist");
        }
    }
}