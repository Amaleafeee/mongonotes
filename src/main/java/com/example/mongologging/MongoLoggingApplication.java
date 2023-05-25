package com.example.mongologging;

import com.example.mongologging.repositories.LeafRepository;
import com.example.mongologging.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoLoggingApplication {

    @Autowired
    LeafRepository leafRepository;

    @Autowired
    NoteRepository noteRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoLoggingApplication.class, args);
    }

}
