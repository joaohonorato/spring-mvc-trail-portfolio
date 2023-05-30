package br.com.biblioteca.model.mapper;

import br.com.biblioteca.model.dto.PersonDTO;
import br.com.biblioteca.model.dto.PersonRestDTO;
import br.com.biblioteca.model.entity.Person;
import br.com.biblioteca.model.vo.CpfVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T21:22:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 13.0.14 (Azul Systems, Inc.)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDTO toDTO(Person entity) {
        if ( entity == null ) {
            return null;
        }

        PersonDTO.PersonDTOBuilder personDTO = PersonDTO.builder();

        personDTO.id( entity.getId() );
        personDTO.name( entity.getName() );
        personDTO.birthDate( entity.getBirthDate() );
        personDTO.isEmployee( entity.getIsEmployee() );

        personDTO.cpf( new CpfVO(entity.getCpf()) );

        return personDTO.build();
    }

    @Override
    public Person toEntity(PersonDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Person.PersonBuilder person = Person.builder();

        person.name( dto.getName() );
        person.birthDate( dto.getBirthDate() );
        person.isEmployee( dto.getIsEmployee() );

        person.cpf( dto.getCpf().getValue() );

        return person.build();
    }

    @Override
    public Person toEntity(PersonRestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Person.PersonBuilder person = Person.builder();

        person.name( dto.getName() );
        person.isEmployee( dto.getIsEmployee() );

        return person.build();
    }

    @Override
    public List<PersonDTO> toDTOList(List<Person> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonDTO> list1 = new ArrayList<PersonDTO>( list.size() );
        for ( Person person : list ) {
            list1.add( toDTO( person ) );
        }

        return list1;
    }

    @Override
    public List<Person> toEntityList(List<PersonDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Person> list1 = new ArrayList<Person>( list.size() );
        for ( PersonDTO personDTO : list ) {
            list1.add( toEntity( personDTO ) );
        }

        return list1;
    }
}
