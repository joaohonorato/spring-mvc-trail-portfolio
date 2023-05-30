package br.com.biblioteca.controller;

import br.com.biblioteca.model.dto.PersonDTO;
import br.com.biblioteca.model.dto.PersonRestDTO;
import br.com.biblioteca.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
@Validated
public class PersonController {

    private final PersonService service;

    @PostMapping
    public ResponseEntity<PersonDTO> merge(@RequestBody @Valid PersonRestDTO dto) {
		return ResponseEntity.ok(service.save(dto));
    }
}