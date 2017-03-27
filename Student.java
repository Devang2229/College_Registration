/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1w17;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

/**
 *
 * @author janid
 */
public abstract class Student extends Person 
    {
    
        //declaring am instance variable
        protected LocalDate enrollmentDate;
        protected int studentNumber;
        protected String courseName;
        protected int collegeEnrollment;
        protected boolean goodStanding;



            
     /**
    This is constructor.
    **/      
    public Student(String firstName, String lastName,  String streetAddress,
            String city, String province, String postalCode,  LocalDate Birthday, 
            String courseName,int studentNumber, LocalDate enrollmentDate)
   
    {
            super(firstName, lastName, streetAddress, city,  province, postalCode, Birthday);
            this.enrollmentDate = enrollmentDate;
            this.studentNumber = studentNumber;
            this.courseName = courseName;
            this.collegeEnrollment = collegeEnrollment;
            

            setBirthday(Birthday);
            setStudentNumber();
            reinstateStudent();
        
     }// contructor ended
        
    
    /**
    This method will validate that the birthday will be in the range of 14 years to 90 years and 
    if not the age is 
    **/
     public void setBirthday(LocalDate birthday)
     
     {
       if(LocalDate.now().getYear() - birthday.getYear() > 14 && LocalDate.now().getYear() - birthday.getYear() < 90) {
           this.Birthday = birthday;
       } else
           throw new IllegalArgumentException();
       
     }
     
   
    /**
     This method will return the year the student enrolled in the college.
     **/
    public int getYearsAtCollege()
        {
          
            Period timeSpan = Period.between(enrollmentDate, LocalDate.now());
             return timeSpan.getYears();
         
        }
    
    
    /**
    This method will return true if the student is in good standing that is having
    greater than 50 or less than 100 marks or else return false if in bad standing.
    **/
    public boolean inGoodStanding()
        {
           
            return this.goodStanding;

        }
    
    /**
    This method will validate the student number is positive and greater than 0. 
    **/
    public void setStudentNumber()
        {

          if (studentNumber > 0) 
              this.studentNumber = studentNumber;
          else 
             throw new IllegalArgumentException("The student Number must be greater than 0. "); 
         }
     
  
    /**
    This method will return the year when the student enrolled in the college.
    **/
    public int getYearEnrolled()
        {   
            
           return enrollmentDate.getYear();
           
        }
    
    /**
     * This method will updates the instance variable holding whether or not the student is in good standing to be true
     **/
    public void reinstateStudent()
        {
            
           this.goodStanding = true;
        
        }
    
    
    /**
    This method will suspend the student and update the instance variable holding the student status to false
    **/
    public boolean suspendStudent()
    {
       goodStanding = false;
       
       return goodStanding;
           
    }
   
     
   
        @Override
     public String toString()
        {
            return firstName + " " + lastName + ", " + "student number is" + " " + studentNumber ;
        }

   
}