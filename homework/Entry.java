package homework;

import java.util.Date;

public class Entry {
    private String firstName;
    private String lastName;
    private String surName;
    private String birthday;
    private String phoneNumber;
    private String gender;
    public Entry(){

    }

    public Entry(String firstName, String lastName, String surName,
                 String birthday, String phoneNumber, String gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surName='" + surName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
