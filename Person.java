/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1w17;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author janid
 */
public abstract class Person {
    
    //instantiazing the local variables
    protected String firstName, lastName, fulladdress, streetAddress, city, province, postalCode;
    protected  LocalDate Birthday;
    protected int age, yearBorn;
    
    /**
    This is the constructor for class Persons
    **/
    public Person(String firstName, String lastName, String streetAddress, 
            String city, String province, String postalCode, LocalDate Birthday)
          {
             
              this.firstName = firstName;
              this.lastName = lastName;
              this.streetAddress = streetAddress;
              this.city = city;
              this.province = province;
              this.Birthday = Birthday;
              this.postalCode = postalCode;
              this.fulladdress = fulladdress;
              setYearBorn();
              setAge();
              testInvalidPerson();
            
           } //contructor ended
    
    
    /**
     * This method returns the age of person in years. It will get the current year and subtract from the user birth date 
     * and display it in years. Example You are "19 years" old.
     **/
    public void setAge()
        {
           
            Calendar today = Calendar.getInstance();
             this.age = (today.get(Calendar.YEAR) - getYearBorn() - 1);

        }
    
   
    public String getFirstName()
        {
            return firstName;
        }

    public String getLastName() 
        {
            return lastName;
        }

    public String getStreetAddress()
        {
            return streetAddress;
        }

    public String getCity() 
        {
            return city;
        }

    public String getProvince()
        {
            return province;
        }

    public String getPostalCode() 
        {
            return postalCode;
        }

    public LocalDate getBirthday() 
        {
            return Birthday;
        }

    public int getAge() 
        {
            return age;
        }

    public int getYearBorn() 
        {
            return yearBorn;
        }
    public String getFulladdress()
        {
            return fulladdress;
        }
    
    public void setFulladdrerss(String fulladdress)
        {
            this.fulladdress = fulladdress;
        }
 
    
    public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }

    public void setLastName(String lastName)
        {
            this.lastName = lastName;
        }

    public void setStreetAddress(String streetAddress)
        {
            this.streetAddress = streetAddress;
        }

    public void setCity(String city) 
        {
            this.city = city;
        }

    public void setProvince(String province)
        {
            this.province = province;
        }

        /**
         This will convert the character to uppercase and store it as instance variable and validate whether 
         the length of postalCode is six if not it will throw an Exception.
         **/
      public void setPostalCode(String postalCode) 
             {

               postalCode = postalCode.toUpperCase();
              if(postalCode.matches("[ABCEGHJKLMNPRSTVXY][0-9][ABCEGHJKLMNPRSTVWXYZ][0-9][ABCDEGHJKLMNPRSTVWXYZ][0-9]"))
                   
                
               this.postalCode = postalCode;
                 else
                    throw new IllegalArgumentException("The invalid postal code should have thrown an exception");
              }

    public void setBirthday(LocalDate birthDate) 
        {
            this.age = age;
        }

    public void setYearBorn() 
        {
            this.yearBorn = Birthday.getYear();
        }

    
    /**
        This is the method that validate the persons class whether it is valid or not.
    **/
    public void testInvalidPerson() 
        {

             postalCode = postalCode.toUpperCase();
             if(postalCode.length() == 6 )
                 this.postalCode = postalCode;
             else
                 throw new IllegalArgumentException("The invalid postal code should have thrown an exception");

        }

    
    /**
    This method will accepts Street, city , province and postal code as an arguments.
     * @param streetName
     * @param city
     * @param province
     * @param PostalCode
    **/
    public void changeAddress(String streetName, String city, String province, String PostalCode)
        {
            setStreetAddress(streetName);
            setCity(city);
            setProvince(province);
            setPostalCode(PostalCode);

        }
    
    
    /**
    This method will return full address which includes street address , city , province and postal code.
    **/
    public String getFullAddress()
            
        {
            fulladdress =   getStreetAddress() + ", " + getCity() + ", " + getProvince()+ ", "+ getPostalCode();
            return fulladdress;
        }

    
    /**
        This method will return first name and last name as a string
    **/
    @Override
    public  String toString()
        {
            return firstName + " " + lastName;
        }

   
}
