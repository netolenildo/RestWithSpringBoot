package br.com.erudio.Controller;

import br.com.erudio.data.vo.PersonVO;
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
    public PersonVO findById(@PathVariable(value="id") Long id) {
        return personService.findById(id);
    }

    @GetMapping
    public List<PersonVO> findAll(){
        return personService.findAll();
    }

    @PostMapping
    public PersonVO createPersonVO(@RequestBody PersonVO person){
        return personService.create(person);
    }

    @PutMapping
    public PersonVO updatePersonVO(@RequestBody PersonVO person){
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
