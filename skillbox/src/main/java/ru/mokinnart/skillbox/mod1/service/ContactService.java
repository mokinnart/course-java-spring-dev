package ru.mokinnart.skillbox.mod1.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import ru.mokinnart.skillbox.mod1.model.Contact;

// @Service
public class ContactService {
    @Getter
    private final List<Contact> contacts = new ArrayList<>();
    @Value("${contact.file.path}")
    private String contactFilePath;
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
    public void deleteContactByEmail(String email) {
        contacts.removeIf(contact -> contact.getEmail().equals(email));
    }
    public void saveContactsToFile() throws IOException {
        try (var writer = new BufferedWriter(new FileWriter(contactFilePath))) {
            for (var contact : contacts) {
                writer.write(contact.toString().replace(" | ", ";") + "\n");
            }
        }
    }
    public void loadContactsFromFile() throws IOException {
        try (var reader = new BufferedReader(new FileReader(contactFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                var parts = line.split(";");
                if (parts.length == 3) {
                    addContact(new Contact(parts[0], parts[1], parts[2]));
                }
            }
        }
    }
}