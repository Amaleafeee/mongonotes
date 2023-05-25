package com.example.mongologging.services;

import com.example.mongologging.entity.Leaf;
import com.example.mongologging.entity.Note;
import com.example.mongologging.repositories.LeafRepository;
import com.example.mongologging.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LeafService {
    private final LeafRepository leafRepository;
    private final NoteRepository noteRepository;

    @Autowired
    private MongoOperations operations;

    @Autowired
    public LeafService(LeafRepository leafRepository, NoteRepository noteRepository) {
        this.leafRepository = leafRepository;
        this.noteRepository = noteRepository;
    }

    public Leaf getUser(String login) {
        return leafRepository.findByLogin(login);
    }

    public String addUser(Leaf leaf) {
        Leaf currentLeaf = leafRepository.findByLogin(leaf.getLogin());
        if (currentLeaf == null) {
            leafRepository.save(leaf);
            Note newNote = new Note(leaf.getId());
            newNote.getNotes().add("∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽");
            noteRepository.save(newNote);
            return "User added!";
        } else {
            return "This login is already taken";
        }
    }

    public ArrayList<String> getNotes(String id) {
        return noteRepository.findByNumber(id).getNotes();
    }

    public String postNote(String id, String note) {
        Note current = noteRepository.findByNumber(id);
        current.getNotes().add(note);
        current.getNotes().add("∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽∽");
        Query query = new Query(Criteria.where("number").is(id));
        Update update = new Update().set("notes", current.getNotes());
        operations.updateFirst(query, update, Note.class);
        return "NoteAdded";
    }
}

