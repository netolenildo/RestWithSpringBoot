package br.com.erudio.converter.mocks;

import br.com.erudio.data.Model.Person;
import br.com.erudio.data.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntity(){
        return mockEntity(0);
    }

    public PersonVO mockVO(){
        return mockVO(0);
    }

    public List<Person> mockEntityList(){
        List<Person> people = new ArrayList<>();
        for(int i = 0; i < 14; i++){
            people.add(mockEntity(i));
        }
        return people;
    }

    public List<PersonVO> mockVOList(){
        List<PersonVO> people = new ArrayList<>();
        for(int i = 0; i < 14; i++){
            people.add(mockVO(i));
        }
        return people;
    }

    private Person mockEntity(Integer number){
        Person person = new Person();
        person.setId(number.longValue());
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(number % 2 == 0 ? "Male" : "Female");
        person.setLastName("Last Name Test" + number);
        return person;
    }

    private PersonVO mockVO(Integer number){
        PersonVO person = new PersonVO();
        person.setId(number.longValue());
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(number % 2 == 0 ? "Male" : "Female");
        person.setLastName("Last Name Test" + number);
        return person;
    }
}
