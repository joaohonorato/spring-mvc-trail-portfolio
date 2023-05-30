package br.com.biblioteca.model.mapper;

import br.com.biblioteca.model.dto.PersonDTO;
import br.com.biblioteca.model.dto.PersonRestDTO;
import br.com.biblioteca.model.entity.Person;
import br.com.biblioteca.model.vo.CpfVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = CpfVO.class)
public interface PersonMapper {

    @Mapping(target="cpf", expression = "java(new CpfVO(entity.getCpf()))")
    PersonDTO toDTO(Person entity);
    @Mapping(target="cpf", expression = "java(dto.getCpf().getValue())")
    Person toEntity(PersonDTO dto);
    Person toEntity(PersonRestDTO dto);

    List<PersonDTO> toDTOList(List<Person> list);

    List<Person> toEntityList(List<PersonDTO> list);

}
