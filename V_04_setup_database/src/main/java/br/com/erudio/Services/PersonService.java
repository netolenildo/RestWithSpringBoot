package br.com.erudio.Services;

import br.com.erudio.Model.Person;
import br.com.erudio.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.erudio.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person findById(Long id){
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person update(Person person){
        Person obj = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        obj.setFirstName(person.getFirstName());
        obj.setLastName(person.getLastName());
        obj.setAddress(person.getAddress());
        obj.setGender(person.getGender());
        return personRepository.save(obj);
    }

    public void delete(Long id){
        Person obj = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        personRepository.delete(obj);
    }
}
