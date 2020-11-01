package com.ing.vacancy.codingchallenge.data.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ADDRESS")
public class Address {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

    private String street;

    private String city;

    private String state;

    private Integer postcode;
}
