package com.example.mongologging.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "leafs")
@Data
public class Leaf {
    @Id
    private String id;
    private String login;
    private String password;
}
