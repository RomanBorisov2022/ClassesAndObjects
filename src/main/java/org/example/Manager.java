package org.example;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private static double salaryIncrease = 1.2; // 20% повышение для руководителей

    public Manager(int employeeId, String name, String hireDate) {
        super(employeeId, name, hireDate);
    }

    public static void increaseSalary(List<Employee> employees) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) { // Проверка, что сотрудник не является руководителем
                double currentSalary = employee.getSalary();
                double newSalary = currentSalary * salaryIncrease;
                employee.setSalary(newSalary);
            }
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Сотрудник 1", "2023-03-15");
        Employee employee2 = new Manager(2, "Руководитель 1", "2022-08-10");
        Employee employee3 = new Employee(3, "Сотрудник 2", "2024-01-25");
        Employee employee4 = new Manager(4, "Руководитель 2", "2023-11-05");

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        System.out.println("Исходные зарплаты:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.getSalary());
        }

        Manager.increaseSalary(employees);

        System.out.println("\nЗарплаты после повышения:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.getSalary());
        }
    }
}

