package com.ing.vacancy.codingchallenge.data.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @SequenceGenerator(name="user-sequence-generator", sequenceName = "USER_SEQUENCE", allocationSize = 1)
    @GeneratedValue(generator="user-sequence-generator")
    private Long id;

    private String username;

    private String password;

    private String title;

    private String firstName;

    private String lastName;

    private String gender;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}
