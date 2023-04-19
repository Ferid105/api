package com.example.person;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table
public class PlaceOfBirth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_of_birth_id")
    private int id;
    private String name;
    @OneToMany(mappedBy = "placeOfBirth")
    private List<Person> birth;
}
