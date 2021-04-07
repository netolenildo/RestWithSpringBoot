package br.com.erudio.Controller;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.Services.PersonService;
import br.com.erudio.data.vo.v2.PersonVOV2;
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
    public PersonVO findById(@PathVariable(value="id") Long id) {
        return personService.findById(id);
    }

    @GetMapping
    public List<PersonVO> findAll(){
        return personService.findAll();
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person){
        return personService.create(person);
    }

    @PostMapping("/v2")
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
        return personService.createV2(person);
    }

    @PutMapping
    public PersonVO updatePerson(@RequestBody PersonVO person){
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
