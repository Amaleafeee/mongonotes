package com.example.mongologging.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "notes")
@Data
public class Note {
    private String number;
    private ArrayList<String> notes;

    public Note(String number) {
        this.number = number;
        this.notes = new ArrayList<>();
    }
}
