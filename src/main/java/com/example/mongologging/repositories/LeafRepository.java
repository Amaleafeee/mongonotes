package com.example.mongologging.repositories;

import com.example.mongologging.entity.Leaf;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeafRepository extends MongoRepository<Leaf, String> {


    Leaf findByLogin(String login);
}
