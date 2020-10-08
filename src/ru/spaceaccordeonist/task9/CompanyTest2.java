package ru.spaceaccordeonist.task9;

import java.util.*;
import java.util.stream.Collectors;

public class CompanyTest2 {
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

        List<Employee> employees = new ArrayList<>();
        Employee temp;
        for(int i = 0; i < 5; i++){
            temp = new Employee(names.get(rnd.nextInt(names.size())), surnames.get(rnd.nextInt(surnames.size())));
            temp.setBirthDate(new GregorianCalendar(
                    1950 + rnd.nextInt(50),
                        rnd.nextInt(Calendar.DECEMBER),
                        rnd.nextInt(28)).getTime());
            temp.setHomeAddress("Moscow, ...");
            temp.setPhoneNumber(String.valueOf(1000000 + rnd.nextInt(8999999)));
            temp.setSalary(20000 + rnd.nextInt(10000));
            employees.add(temp);
        }
        System.out.println();
        company.hireAll(employees);

        System.out.println("All employees: \n");
        company.getAllEmployees().forEach(employee -> System.out.println(employee.toString() + "\n"));
        System.out.println("-------------");
        company.handleEmployees(empl ->{
            empl = empl.stream()
                    .filter(employee -> employee.getPhoneNumber().charAt(0) == '9')
                    .collect(Collectors.toList()); //Выбираем всех, у кого номер начиначется с 9
            company.fireAll(empl);  //Увольняем их
        });
        company.handleEmployees(new EmployeeProcess() {
            @Override
            public void process(List<Employee> employees) {
                //Переселяем всех с именем Aaron в США
                employees.stream()
                        .filter(employee -> employee.getName().equals("Aaron"))
                        .forEach(employee -> employee.setHomeAddress("Miami, ..."));
            }
        });

        company.handleEmployees(new EmployeeProcessImpl());

        System.out.println("Handled employees: \n");
        company.getAllEmployees().forEach(employee -> System.out.println(employee.toString() + "\n"));
        System.out.println("-------------");
    }
}
