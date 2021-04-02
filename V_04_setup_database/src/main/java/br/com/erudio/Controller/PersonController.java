package br.com.erudio.Controller;

import br.com.erudio.Model.Person;
import br.com.erudio.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public Person findById(@PathVariable(value="id") Long id) {
        return personService.findById(id);
    }

    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
        return personService.create(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
