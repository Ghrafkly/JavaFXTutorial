package com.example.keeptoo.models;

import javafx.beans.property.SimpleStringProperty;

public class Member {
    SimpleStringProperty Name;
    SimpleStringProperty Mobile;
    SimpleStringProperty Email;
    SimpleStringProperty Action;

    public Member(String name, String mobile, String email, String action) {
        Name = new SimpleStringProperty(name);
        Mobile = new SimpleStringProperty(mobile);
        Email = new SimpleStringProperty(email);
        Action = new SimpleStringProperty(action);
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getMobile() {
        return Mobile.get();
    }

    public void setMobile(String phone) {
        this.Mobile.set(phone);
    }

    public String getEmail() {
        return Email.get();
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public String getAction() {
        return Action.get();
    }

    public void setAction(String action) {
        this.Action.set(action);
    }
}
