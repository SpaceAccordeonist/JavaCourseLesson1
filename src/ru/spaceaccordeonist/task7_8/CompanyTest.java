package ru.spaceaccordeonist.task7_8;

import ru.spaceaccordeonist.task7_8.model.Company;
import ru.spaceaccordeonist.task7_8.model.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class CompanyTest {
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<String> surnames = new ArrayList<>();
    static Random rnd = new Random(new Date().getTime());
    static {
        names.add("Aaron");
        names.add("Ada");
        names.add("Bruce");
        names.add("Beatrice");
        names.add("Thomas");
        names.add("Sara");
        names.add("Walter");

        surnames.add("Black");
        surnames.add("Brooks");
        surnames.add("Farrell");
        surnames.add("Fisher");
        surnames.add("Gilson");
        surnames.add("Lewin");
        surnames.add("Page");
    }
    public static void main(String[] args) {
        Company company = new Company("Oracle");

        ArrayList<Employee> employees = new ArrayList<>();
        for(int i = 0; i < 180; i++){
            employees.add(new Employee(names.get(rnd.nextInt(names.size())), surnames.get(rnd.nextInt(surnames.size()))));
        }
        company.hireAll(employees, Company.Positions.OPERATOR, 20000);

        employees.clear();
        for(int i = 0; i < 80; i++){
            employees.add(new Employee(names.get(rnd.nextInt(names.size())), surnames.get(rnd.nextInt(surnames.size()))));
        }
        company.hireAll(employees, Company.Positions.MANAGER, 140000);

        employees.clear();
        for(int i = 0; i < 10; i++){
            employees.add(new Employee(names.get(rnd.nextInt(names.size())), surnames.get(rnd.nextInt(surnames.size()))));
        }
        company.hireAll(employees, Company.Positions.TOP_MANAGER, 210000);

        System.out.println("TOP:");
        company.getTopSalaryStaff(10).forEach(System.out::println);
        System.out.println("\nLOWEST:");
        company.getLowestSalaryStaff(10).forEach(System.out::println);
    }
}
