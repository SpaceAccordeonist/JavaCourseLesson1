package ru.spaceaccordeonist.task7_8.model;

public class Employee {
    protected String name;
    protected String surname;
    protected double salary;
    protected EmployeePosition position;

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

    public double getTotalSalary() {
        return salary;
    }

    public void setBaseSalary(double salary) {
        this.salary = position.calcSalary(salary);
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name + " " + surname +
                " " + position.getJobTitle() + " " + salary;
    }
}