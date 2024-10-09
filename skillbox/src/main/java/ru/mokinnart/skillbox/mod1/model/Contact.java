package ru.mokinnart.skillbox.mod1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Contact {
    private String fullName;
    private String phoneNumber;
    @Getter
    private String email;
    @Override
    public String toString() {
        return String.join("|", fullName, phoneNumber, email);
    }
}