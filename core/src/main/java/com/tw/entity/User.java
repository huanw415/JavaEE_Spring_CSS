package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/7/15.
 */
//Id INT AUTO_INCREMENT primary key,
//Name VARCHAR(50) NOT NULL,
//Password VARCHAR(100) NOT NULL,
//EmployeeId INT,
//FOREIGN KEY (EmployeeId) REFERENCES EMPLOYEE(Id)
@Entity
@Table(name = "user")
public class User {

    private int id;
    private String name;
//    private String gender;
//    private String email;
//    private int age;
    private String password;
    private Employee employee;

    public User() {
    }

    public User(String name, String password, Employee employee) {
        this.name = name;
        this.password = password;
        this.employee = employee;
    }

    //    public User(String name, String gender, String email, int age, String password) {
//        this.name = name;
////        this.gender = gender;
////        this.email = email;
////        this.age = age;
//        this.password = password;
//    }

    public User(int id, String name, String gender, String email, int age, String password) {
        this.id = id;
        this.name = name;
//        this.gender = gender;
//        this.email = email;
//        this.age = age;
        this.password = password;
    }

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Column(name = "Gender")
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    @Column(name = "Email")
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    @Column(name = "Age")
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EmployeeId")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
