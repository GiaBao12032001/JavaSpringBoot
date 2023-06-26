package com.example.testing.dto;

public class SalaryDTO {
    private double salary;
    private double bonus;
    private double penalty;

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
}
