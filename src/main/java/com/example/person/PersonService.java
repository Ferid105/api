package com.example.person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PersonService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private NationalityRepository natRepository;
    @Autowired
    private BloodGroupRepository bldRepository;
    @Autowired
    private PlaceOfBirthRepository pofRepository;
    @Autowired
    private PersonRepository repository;

    List<PersonDTO>  getAllPersons(){
           return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

        PersonDTO createNewPerson(PersonDTO dto) {
//            Person entity = new Person();
//            entity.setName(dto.getName());
//            entity.setSurname(dto.getSurname());
//            entity.setPatron(dto.getPatron());
//            entity.setPersonalNo(dto.getPersonalNo());
//            Nationality nationality = natRepository.getReferenceById(dto.getNationality_id());
//            entity.setNationality(nationality);
//            BloodGroup bloodGroup= bldRepository.getReferenceById(dto.getBlood_group_id());
//            entity.setBloodGroup(bloodGroup);
//            PlaceOfBirth placeOfBirth=pofRepository.getReferenceById(dto.getPlace_of_birth_id());
//            entity.setPlaceOfBirth(placeOfBirth);
//            entity.setSex(dto.getSex());

            Person entity = modelMapper.map(dto, Person.class);

            repository.save(entity);
            dto.setId(entity.getId());
            return dto;
        }
    public ResponseEntity<Person> getPrsById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        Person person = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("person not found for this id :: " + id));
        return ResponseEntity.ok().body(person);
    }

    public  PersonDTO updatePrs(@PathVariable Integer id, @RequestBody PersonDTO prsDetails) {
        Person updatePerson = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not exist with id: " + id));
        updatePerson.setName(prsDetails.getName());
        repository.save(updatePerson);
        return prsDetails;
    }

    public ResponseEntity<Person> updatePrsPartially(@PathVariable Integer id, @PathVariable String name) {
        try {
            Person person = repository.findById(id).get();
            person.setName(name);
            return new ResponseEntity<Person>(repository.save(person), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    void deletePerson(@PathVariable Integer id) {
        if(repository.existsById(id))
            repository.deleteById(id);
    }
    private PersonDTO convertToDto(Person entity) {
        PersonDTO dto = modelMapper.map(entity, PersonDTO.class);
        return dto;
    }

    private Person convertToEntity(PersonDTO dto) {
        Person entity = modelMapper.map(dto, Person.class);
        return entity;
    }

}
