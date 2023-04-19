package com.example.person;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table
public class Nationality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nationality_id")
    private int id;
    private String name;
    @OneToMany(mappedBy = "nationality")
    private List<Person> nation;
}
