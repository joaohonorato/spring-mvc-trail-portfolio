package br.com.biblioteca.service;

import br.com.biblioteca.model.dto.PersonDTO;
import br.com.biblioteca.model.dto.PersonRestDTO;
import br.com.biblioteca.model.mapper.PersonMapper;
import br.com.biblioteca.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {
 
    private final PersonRepository repository;
    private final PersonMapper mapper;
    @Transactional(readOnly = true)
    public PersonDTO save(@Valid PersonRestDTO personDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(personDTO)));
    }

    public List<PersonDTO> findEmployees() {
        return mapper.toDTOList(repository.findAllByIsEmployeeIsTrue());
    }
}
