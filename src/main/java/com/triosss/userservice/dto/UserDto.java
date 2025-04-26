package com.triosss.userservice.dto;

import org.springframework.http.HttpStatus;

public class UserDto {
    private String name;
    private HttpStatus status = HttpStatus.OK;
    private String emailId;
    private String contactNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
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
                ", status=" + status +
                ", emailId='" + emailId + '\'' +
                ", contactNo='" + contactNo + '\'' +
                '}';
    }
}
