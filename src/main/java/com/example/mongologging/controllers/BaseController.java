package com.example.mongologging.controllers;

import com.example.mongologging.entity.Leaf;
import com.example.mongologging.entity.LoginRequest;
import com.example.mongologging.services.LeafService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/users/")
public class BaseController {
    private final LeafService leafService;

    @Autowired
    public BaseController(LeafService leafService) {
        this.leafService = leafService;
    }

    @PostMapping("login")
    public String logging(@RequestBody LoginRequest loginRequest) {
        Leaf current = leafService.getUser(loginRequest.getLogin());
        if (current.getPassword().equals(loginRequest.getPassword())) {
            String id = current.getId();
            return "redirect:/api/users/" + id;
        } else {
            return "redirect:/api/users/login";
        }
    }

    @PatchMapping("login")
    public String addUser(@RequestBody Leaf leaf) {
        return leafService.addUser(leaf);
    }

    @GetMapping("{id}")
    public ArrayList<String> getNotes(@PathVariable("id") String id) {
        return leafService.getNotes(id);
    }

    @PostMapping("{id}")
    public String postNote(@PathVariable("id") String id, @RequestBody String note) {
        return leafService.postNote(id, note);
    }
}
