package com.evad.websocketchatonetoone.Service;

import com.evad.websocketchatonetoone.Data.Status;
import com.evad.websocketchatonetoone.Data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {


    List<User> findAllByStatus(Status status);
}
