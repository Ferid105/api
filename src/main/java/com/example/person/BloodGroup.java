package com.example.person;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
//@Table
@Entity
public class BloodGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blood_group_id")
    private int id;
    private String name;
    @OneToMany(mappedBy = "bloodGroup")
    private List<Person> blood;


}
