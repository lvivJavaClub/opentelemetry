package com.lvivjavaclub.opentelemetry;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Controller {

    private final PersonRepository personRepository;
    private final PersonService personService = new PersonService();

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personRepository.findById(id).orElse(new Person());
    }

    @PostMapping("/person")
    public Long createPerson(@RequestBody Person person) {
        return personRepository.save(person).getId();
    }

    @GetMapping("/person")
    public Person generatePerson() {
        return personRepository.save(personService.generatePerson());
    }
}
