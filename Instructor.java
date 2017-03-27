/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1w17;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author janid
 */
public  abstract class Instructor extends Person

{
    
            //instance variables
            public int employeeNumber;
            public LocalDate hireDate;
            public ArrayList <String> courses = new ArrayList<>();

            //contructor
            public Instructor(String firstName, String lastName,  String streetAddress,
                    String city, String province, String postalCode,  LocalDate Birthday,
                    int employeeNumber, LocalDate hireDate )
            {
                super(firstName, lastName, streetAddress, city,  province, postalCode, Birthday);
                
                
                /*
                This will validate the employee number is greater than zero and if not throw an exception
                */
                if(employeeNumber > 0)
                    {
                        this.employeeNumber = employeeNumber;
                    }
                else 
                    throw new IllegalArgumentException();
                
                this.hireDate = hireDate;
                
                
                courses = new ArrayList<>();
               

               }//end of the contructor

            
            
            /**
             * This method will receive the course code as a string
             * and covert them to uppercase and store in the list of teachable courses.
             */
            public void addTeachableCourse(String courseCode)
            {
                courses.add(courseCode.toUpperCase());
               
            }
            
            
            
             public ArrayList<String> getCourses()
                {
                     return courses;
                }
            
              public ArrayList<String> getTeachableCourses()
              {
                 return courses;
              }

            /*
            This recieves course code as an argument and returns true if the instructor has that course in the teachable subjects or
            false otherwise.
            */
            public boolean canTeach(String courseCode)
            {
                if(courses.contains(courseCode.toUpperCase())){
                    return true;
                }else 
                    return false;
             
            }
            
            
            /*
            This method will return the employee number as validated in the contructor.
            */
            public  int getEmployeeNum()
            {
                return employeeNumber;
            }
     
            /*
            This method validate to add courses to the list of courses an Instructor teaches.
      
            */
             public void addCourseToAbilities(String courseCode)
             {
              
                 this.courses.add(courseCode);
                
             }
             
       
            
        public int getEmployeerNumber() 
           {
               return employeeNumber;
           }

       public LocalDate getHireDate()  
           {
               return hireDate;
           }

     
    
    /*
    This method will return the number of years the instructor worked at the college.
    */
        public int getYearsAtCollege()
           {
            
                Period timeSpan = Period.between(hireDate, LocalDate.now());
                return timeSpan.getYears();
         
            }
     
     
     /**
      * This method sets the birthday of the instructor if it is between 18 - 100 years and
      * if not it is throwing an illegalArgumentException.
     * @param birthday
      */
     public void setBirthday( LocalDate birthday)
          
            
  {
       if(LocalDate.now().getYear() - birthday.getYear() > 18 && LocalDate.now().getYear() - birthday.getYear()<100) 
       {
           this.Birthday = birthday;
       } else
           throw new IllegalArgumentException();
       
   }
   
     
     /**
      * This method will set the hire date and will validate that the instructor was
      * hired in last 80 years dynamically and if not then throw an exception.
     * @return 
      */
     public void setHireDate(LocalDate dateHired)
     {  
         if(((LocalDate.now().getYear() - dateHired.getYear()) < 80) && LocalDate.ofYearDay(2017,11).isAfter(dateHired) )
             this.hireDate = dateHired;
         else 
             throw new IllegalArgumentException();
         
     }
   
     
  @Override
  public String toString()
    {
          return firstName + " " +  lastName + " " + employeeNumber + ".";
    }

}



