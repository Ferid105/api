package com.example.person;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Setter
@Getter
 public class PersonDTO {

 private int Id;

 private String name;

 private String surname;

 private String patron;

 private String sex;

 private Integer nationality_id;

 private Integer place_of_birth_id;
// @DateTimeFormat(pattern = "dd/mm/yyyy")
// private LocalDate dateOfBirth;

 private String cardNo;
 private String personalNo;
// @DateTimeFormat(pattern = "dd/mm/yyyy")
// private LocalDate dateOfExpiry;

 private Integer blood_group_id;

}
