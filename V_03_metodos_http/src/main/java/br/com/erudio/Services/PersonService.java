package br.com.erudio.Services;

import br.com.erudio.Model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person findById(Long id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Fulano");
        person.setLastName("de Tal");
        person.setAddress("Natal - Rio Grande do Norte - Brasil");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll(){
        List<Person> people = new ArrayList<>();
        for(int i = 0; i<8; i++){
            Person person = mockPerson(i);
            people.add(person);
        }
        return people;
    }

    public Person create(Person person){
        return person;
    }

    public Person update(Person person){
        return person;
    }

    public void delete(Long id){

    }

    private Person mockPerson(int count){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Fisrt Name" + count);
        person.setLastName("Last Name" + count);
        person.setAddress("Some adress in Brasil" + count);
        person.setGender("Male");
        return person;
    }
}
