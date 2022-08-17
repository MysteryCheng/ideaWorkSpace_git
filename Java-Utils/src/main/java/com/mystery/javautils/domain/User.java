package com.mystery.javautils.domain;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer id;
    private String name;

    private String role;
    private String registration;
    private String creditCode;
    private String residence;
    private String legalRepresentative;
    private String contact;
    private String email;
    private String officePhone;
    private String mobilePhone;
    private String mailAddr;
    private String hash;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMailAddr() {
        return mailAddr;
    }

    public void setMailAddr(String mailAddr) {
        this.mailAddr = mailAddr;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", registration='" + registration + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", residence='" + residence + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", mailAddr='" + mailAddr + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}
