package com.triosss.userservice.dto;

import org.springframework.http.HttpStatus;

public class UserDto {
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
    private String emailId;
    private String contactNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +

                ", emailId='" + emailId + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
