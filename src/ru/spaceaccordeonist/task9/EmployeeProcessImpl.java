package ru.spaceaccordeonist.task9;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EmployeeProcessImpl implements EmployeeProcess {
    @Override
    public void process(List<Employee> employees) {
        //Поднимаем зарплату тем, кто родился позже 85 года
        employees.stream()
                .filter(employee -> employee.getBirthDate()
                        .after(new GregorianCalendar(1985, Calendar.JANUARY, 1).getTime()))
                .forEach(employee -> employee.setSalary(employee.getSalary() + 10000));
    }
}
