package ru.spaceaccordeonist.task9;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEmployeesCount(){
        return employees.size();
    }

    public void hire(Employee employee){
        if(employee != null && employee.isFilled())
            employees.add(employee);
    }
    public void hireAll(List<Employee> employees){
        employees.forEach(this::hire);
    }

    public void fire(Employee employee){
        if(employee != null)
            employees.remove(employee);
    }

    public void fireAll(List<Employee> employees){
        employees.forEach(this::fire);
    }

    public List<Employee> getAllEmployees() {return new ArrayList<>(employees);}
    public void handleEmployees(EmployeeProcess processing){
        processing.process(employees);
    }
}
