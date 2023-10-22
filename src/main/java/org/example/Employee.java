package org.example;

import java.util.Comparator;

public class Employee {
    private int employeeId;
    private String name;
    private String hireDate;
    private double salary;

    public Employee(int employeeId, String name, String hireDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hireDate = hireDate;
        this.salary = 0.0; // Устанавливаем начальную зарплату в 0
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public static Comparator<Employee> dateComparator = (e1, e2) -> {
        String[] date1Parts = e1.hireDate.split("-");
        String[] date2Parts = e2.hireDate.split("-");

        int year1 = Integer.parseInt(date1Parts[0]);
        int year2 = Integer.parseInt(date2Parts[0]);
        if (year1 != year2) {
            return Integer.compare(year1, year2);
        }

        int month1 = Integer.parseInt(date1Parts[1]);
        int month2 = Integer.parseInt(date2Parts[1]);
        if (month1 != month2) {
            return Integer.compare(month1, month2);
        }

        int day1 = Integer.parseInt(date1Parts[2]);
        int day2 = Integer.parseInt(date2Parts[2]);
        return Integer.compare(day1, day2);
    };
}

