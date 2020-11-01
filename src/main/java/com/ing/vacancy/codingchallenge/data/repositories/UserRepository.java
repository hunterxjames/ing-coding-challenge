package com.ing.vacancy.codingchallenge.data.repositories;

import com.ing.vacancy.codingchallenge.data.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
