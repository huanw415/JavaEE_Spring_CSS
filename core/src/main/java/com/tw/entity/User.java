package com.tw.entity;

import javax.persistence.*;

/**
 * Created by hgwang on 7/7/15.
 */
@Entity
@Table(name = "user")
public class User {

    private int id;
    private String name;
    private String password;
    private Employee employee;

    public User() {
    }

    public User(String name, String password, Employee employee) {
        this.name = name;
        this.password = password;
        this.employee = employee;
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
