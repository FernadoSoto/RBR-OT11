package pe.edu.vg.app.controller;

import pe.edu.vg.app.model.Person;
import pe.edu.vg.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        return ResponseEntity.ok(personService.updatePerson(id, personDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Person> changeStatus(@PathVariable Long id, @RequestBody String status) {
        return ResponseEntity.ok(personService.changeStatus(id, status));
    }
}