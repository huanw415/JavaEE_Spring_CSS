package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/16/15.
 */
@Entity
@Table(name="employee")
public class Employee {

    private int id;
    private String name;
    private String role;
    private String gender;
    private String email;
    private int age;

    public Employee() {
    }

    public Employee(String name, String role, String gender, String email, int age) {
        this.name = name;
        this.role = role;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }

    public Employee(int id, String name, String role, String gender, String email, int age) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }

    @Id
    @Column(name="Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="Role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name="Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name="Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="Age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
