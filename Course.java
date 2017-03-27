
package assignment1w17;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author janid
 */
public class Course
/**
 *this is instance variables
 */
{
   
    protected String courseCode, courseName, description, room;
    protected Instructor Instructor;
    protected DayOfWeek courseDay;
    protected LocalTime startTime;
    protected int duration;  
    protected int maxStudents;
   
    private ArrayList<Student>Students = new ArrayList<>();
   /**
    * Constructor
    */    
public Course(String courseCode, String courseName, String Description, String room, Instructor Instructor
                    , DayOfWeek courseDay, LocalTime startTime, int duration, int maxStudents  )    
    {
        
          
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.description = Description;
            this.room = room;
            this.maxStudents = maxStudents;
            this.startTime = startTime;
            this.courseDay = courseDay;
            this.duration = duration;
            setProf(Instructor);
            setMaxNumberOfStudents(maxStudents);
            setDayOfClass(courseDay);
            setStartTime(startTime);
            
            
    }    //end of the constructor
    

    /**
     * This method will this checks if the student is currently in good standing and 
     * if there is space in the class. 
     * If a student cannot be added, it should throw an InvalidStudentException
     * @param student
     * @throws InvalidStudentException 
     */
    public void addStudent(Student student) throws InvalidStudentException
    {
        if(student.inGoodStanding() && Students.size() < maxStudents)
            Students.add(student);
        else 
            throw new IllegalArgumentException();
                   
    }
    
    /**
     * This method will show the average number of years
     * students registered in the class have been at the college
     * @return 
     */
     public double averageStudentTimeAtCollege()
     {
         double sum =0;
         for(Student Student: Students)
        {
                sum = LocalDate.now().getYear()-Student.getYearEnrolled();

        }
         return (sum/Students.size());
     }
     
     /**
      * getter methods 
      * @return 
      */
    public String getCourseCode() 
    {
        return this.courseCode;
    }

    public String getCourseName() 
    {
        return this.courseName;
    }
    
    
      public DayOfWeek getDayOfClass()
        {
            return this.courseDay;
        }


    public String getDescription() 
    {
        return this.description;
    }
 
    public int getDuration() 
    {
        return this.duration;
    }
    
    public int getMaxNumberOfStudents()
    {
       return this.maxStudents;
    }
    
    
     public int getNumberOfStudentsEnrolled()
    {
        return Students.size();
    }
  
 
    public Instructor getProf()
    {
        return this.Instructor;
    }
    
     public String getRoom()
     {
        return this.room;
     }

    
    public LocalTime getStartTime() 
    {
        return this.startTime;
    }
  

     
    public  ArrayList<Student> getStudents()
    {
        return this.Students;
    }
    
    
    public void setStduents(ArrayList<Student> Students)
    {
        this.Students = Students;
    }
    
    /**
     * This method accepts a DayOfWeek as an argument and validates that the day is Monday-Friday and sets the class day. 
     * If it is Saturday or Sunday, an IllegalArgumentException is thrown
     * @param day 
     */
     public void setDayOfClass(DayOfWeek day)
        {
             if(day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY){
                 throw new IllegalArgumentException();
 
             }
                else
                    this.courseDay = day;        

        }
     /**
      * This method validates to be in the range of 10-50 and set the instance variable. 
      * If it is outside of the range, it should throw an IllegalArgumentException
      * @param maxStudents 
      */
     public void setMaxNumberOfStudents(int maxStudents)
    {
        if(maxStudents  >= 10 && maxStudents <= 50)
        {
            this.maxStudents = maxStudents;
        }
        else 
            throw new IllegalArgumentException();
    }
    
     /**
      * This method will receive an Instructor as an argument.  The Instructor should be validated to ensure it can teach the course code of this course. 
      * If the Instructor cannot teach the course, an IllegalArgumentException should be thrown
      * @param Instructor 
      */
     public  void  setProf(Instructor Instructor)
        {
            if(Instructor.canTeach(courseCode))
            {
                this.Instructor = Instructor;
            }
            else 
                throw new IllegalArgumentException();     
        }
    
    
    /**
     *This method will accepts a LocalTime instance and validates if it is between 8:00 am and 6:00 pm. 
     * If the start time is not valid, an IllegalArgumentException should be thrown
     */
    public void setStartTime(LocalTime time)
    {
        if(time.isAfter(LocalTime.of(18,00)) || time.isBefore(LocalTime.of(8,00)))
           {
               throw new IllegalArgumentException();  
           }
               else
                   this.startTime=time;

     }
    
    /**
     * This method will return a String with the Student’s registered in the course. 
     * Each Student should use their “toString” method and put a new line character between Students. 
     * @return 
     */
    public String showClassList()
{
         String result= "";
         

        for(int i=0;i<Students.size();i++)
        {
            result += result+ Students.get(i).toString() + "%n";
        }
        return result;
        
        
}
    
    /**
     * returns a String with the course name, a space and then the course code
     * @return 
     */
    @Override
    public String toString()
    {
        return courseName + " " + courseCode;
    }
}
