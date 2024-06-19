package pe.edu.vg.app.service;

import pe.edu.vg.app.model.Person;
import pe.edu.vg.app.repository.PersonRepository;
import pe.edu.vg.app.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
        
        person.setName(personDetails.getName());
        person.setLastName(personDetails.getLastName());
        person.setDocumentType(personDetails.getDocumentType());
        person.setDocumentNumber(personDetails.getDocumentNumber());
        person.setPhone(personDetails.getPhone());
        person.setRole(personDetails.getRole());
        person.setStatus(personDetails.getStatus());

        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
        personRepository.delete(person);
    }

    public Person changeStatus(Long id, String status) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
        person.setStatus(status);
        return personRepository.save(person);
    }
}