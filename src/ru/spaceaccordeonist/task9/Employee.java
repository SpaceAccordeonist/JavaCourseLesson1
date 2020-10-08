package ru.spaceaccordeonist.task9;

import java.text.DateFormat;
import java.util.Date;

public class Employee {
    private String name;
    private String surname;
    private Date birthDate;
    private String homeAddress;
    private String phoneNumber;
    private int salary;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isFilled(){
        return name != null && surname != null && birthDate != null && homeAddress != null;
    }

    @Override
    public String toString() {
        return "{ name: " + name + "\n" +
                "surname: " + surname + "\n" +
                "birthDate: " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(birthDate) + "\n" +
                "homeAddress: " + homeAddress + "\n" +
                "phoneNumber: " + phoneNumber + "\n" +
                "salary: " + salary + " }";
    }
}