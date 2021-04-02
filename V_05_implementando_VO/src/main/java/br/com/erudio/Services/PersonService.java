package br.com.erudio.Services;

import br.com.erudio.Converter.DozerConverter;
import br.com.erudio.data.Model.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.erudio.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public PersonVO findById(Long id){
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll(){
        return DozerConverter.parseObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person){
        Person obj = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));

        obj.setFirstName(person.getFirstName());
        obj.setLastName(person.getLastName());
        obj.setAddress(person.getAddress());
        obj.setGender(person.getGender());

        return DozerConverter.parseObject(personRepository.save(obj), PersonVO.class);
    }

    public void delete(Long id){
        Person obj = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        personRepository.delete(obj);
    }
}
