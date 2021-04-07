package br.com.erudio.Converter.Custom;

import br.com.erudio.data.Model.Person;
import br.com.erudio.data.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonConverter {

    public PersonVOV2 convertEntityToVO(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }

    public Person convertVOToEntity(PersonVOV2 vo){
        Person person = new Person();
        person.setId(vo.getId());
        person.setAddress(vo.getAddress());
        person.setFirstName(vo.getFirstName());
        person.setLastName(vo.getLastName());
        person.setGender(vo.getGender());
        return person;
    }
}
