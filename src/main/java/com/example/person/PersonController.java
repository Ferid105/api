package com.example.person;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    private PersonRepository repository;

    @Autowired
    private NationalityRepository natRepository;
    @Autowired
    private BloodGroupRepository bldRepository;
    @Autowired
    private PlaceOfBirthRepository pofRepository;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    List<PersonDTO> findAll() {
//        return repository.findAll();
      return   personService.getAllPersons();
    }
    @Autowired
    private PersonService service;

//    @PostMapping("/student-record")
//    public ResponseEntity createPersonRecord(@RequestBody Request request)     {
//        boolean recordCreated = service.createPersonRecord(new
//                PersonDTOMapper().mapToModel(request));
//        if (recordCreated) return new ResponseEntity(HttpStatus.CREATED);
//        return new ResponseEntity(HttpStatus.BAD_REQUEST);
//
   // }



    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/persons")
    PersonDTO newPerson(@RequestBody PersonDTO dto) {
        return personService.createNewPerson(dto);
    }
    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPrsById(@PathVariable(value = "id") Integer id){
//            throws ResourceNotFoundException {
//        Person person = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("person not found for this id :: " + id));
//        return ResponseEntity.ok().body(person);
      return  personService.getPrsById(id);
    }
    @PutMapping("/persons/{id}")
      public ResponseEntity<PersonDTO> updatePrs(@PathVariable Integer id, @RequestBody PersonDTO dto) {
     //       Person updatePerson = repository.findById(id)
   //                 .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id: " + id));
    //    updatePerson.setName(updatePerson.getName());
     //   repository.save(updatePerson);
           // return ResponseEntity.ok(updatePerson);
      return  ResponseEntity.ok(personService.updatePrs(id,dto));
        }


    @PatchMapping("/persons/{id}")
    public ResponseEntity<Person> updatePrsPartially(@PathVariable Integer id, @PathVariable String name) {
//        try {
//            Person person = repository.findById(id).get();
//            person.setName(name);
//            //  return new ResponseEntity<Person>(repository.save(person), HttpStatus.OK);
           return  personService.updatePrsPartially(id, name);
     //   } catch (Exception e) {
      //      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     //   }
    }

    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
//        if(repository.existsById(id))
//        repository.deleteById(id);
    }
}
