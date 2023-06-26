package com.example.testing.entity;

public class Employee {
    private Long id;
    private String name;
    private int age;
    private String address;
    private double salary;
    private double bonus;
    private double penalty;

    public Employee() {
    }

    public Employee(Long id, String name, int age, String address, double salary, double bonus, double penalty) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
        this.bonus = bonus;
        this.penalty = penalty;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
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
