package ru.spaceaccordeonist.task7_8.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private String name;
    private List<Employee> employees = new ArrayList<>();
    private double income = 0;

    public enum Positions{OPERATOR, TOP_MANAGER, MANAGER}

    public Company(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getEmployeesCount(){
        return employees.size();
    }

    public void hire(Employee employee, Positions position, double salary){
        employee.setPosition(createPosition(position));
        employee.setBaseSalary(salary);
        employees.add(employee);
        if(position == Positions.MANAGER){
            Manager manager = (Manager)employee.getPosition();
            income += manager.getProfit();
        }
    }
    public void hireAll(List<Employee> employees, Positions position, double salary){
        employees.forEach(employee -> hire(employee, position, salary + Math.round(salary * Math.random()/3)));
    }

    public void fire(int id){
        if (id < employees.size())
            employees.remove(id);
    }

    public double getIncome(){
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count){
        if(count > 0){
            List<Employee> sorted = employees.stream()
                    .sorted((employee1, employee2) -> (int)(employee2.salary - employee1.salary))
                    .collect(Collectors.toList());
            if(count < sorted.size())
                return sorted.subList(0, count);
            else
                return sorted;
        }
        return new ArrayList<>();
    }

    public List<Employee> getLowestSalaryStaff(int count){
        if(count > 0){
            List<Employee> sorted = employees.stream()
                    .sorted((employee1, employee2) -> (int)(employee1.salary - employee2.salary))
                    .collect(Collectors.toList());
            if(count < sorted.size())
                return sorted.subList(0, count);
            else
                return sorted;
        }
        return new ArrayList<>();
    }

    private EmployeePosition createPosition(Positions position){
        switch (position){
            case OPERATOR:
                return new Operator();
            case MANAGER:
                return new Manager();
            default:
                return new TopManager(this);
        }
    }
}
