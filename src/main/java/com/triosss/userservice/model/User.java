package com.triosss.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = 0;
    private String name;
    private String username;
    private String userType;
    private LocalDate createdTime = LocalDate.now();
    private LocalDate modifiedTime;
    private String password;
    @NotNull(message = "email must be entered")
    @Email(message = "please enter a valid email id")
    @Pattern(regexp = "^[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.com$",message = "enter a valid email id")
    private String emailId;

    @NotNull(message = "Contact number must be entered")
    @Pattern(regexp = "^\\d{10}", message = "enter 10- digit contact number")
    private String contactNo;
    private LocalDate passwordExpiry;
    private String address;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public LocalDate getModifiedTime() {
        return modifiedTime;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public LocalDate getPasswordExpiry() {
        return passwordExpiry;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setCreatedTime() {
        this.createdTime = LocalDate.now();
    }

    public void setModifiedTime(LocalDate modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setPasswordExpiry(LocalDate passwordExpiry) {
        this.passwordExpiry = passwordExpiry;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", userType='" + userType + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", password='" + password + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", passwordExpiry=" + passwordExpiry +
                ", address='" + address + '\'' +
                '}';
    }
}
