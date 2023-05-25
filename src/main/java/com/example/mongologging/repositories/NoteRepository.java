package com.example.mongologging.repositories;

import com.example.mongologging.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    Note findByNumber(String number);
}
