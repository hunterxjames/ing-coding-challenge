package com.ing.vacancy.codingchallenge.data.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="USERS_ROLES")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
}
