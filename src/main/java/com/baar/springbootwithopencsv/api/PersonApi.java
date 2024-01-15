package com.baar.springbootwithopencsv.api;

import com.baar.springbootwithopencsv.dto.PersonDto;
import com.baar.springbootwithopencsv.service.PersonServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/persons")

public class PersonApi {
    private final PersonServiceImpl personService;

    public PersonApi(PersonServiceImpl personService) {
        this.personService = personService;

    }

    @GetMapping("/")
    public String getMessage() {
        return "Hello there!";
    }

    @GetMapping("/get/all/persons")
    public List<PersonDto> getPersons() {
        return personService.getPersons();
    }
}
