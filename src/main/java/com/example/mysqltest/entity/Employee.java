package com.example.mysqltest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String address;
    @Column
    private double salary;
    @Column
    private double bonus;
    @Column
    private double penalty;

}
