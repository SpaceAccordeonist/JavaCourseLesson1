package ru.spaceaccordeonist.task7_8.model;

public class TopManager implements EmployeePosition {
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + ((company.getIncome() > 10000000) ? baseSalary*1.5 : 0);
    }
}
