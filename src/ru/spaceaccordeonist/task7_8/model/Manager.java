package ru.spaceaccordeonist.task7_8.model;

public class Manager implements EmployeePosition {
    private double profit = Math.random() * 25000 + 115000;

    public double getProfit() {
        return profit;
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + Math.round(0.05* profit);
    }
}
