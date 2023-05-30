package br.com.biblioteca.repository;

import br.com.biblioteca.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByIsEmployeeIsTrue();
    
}
