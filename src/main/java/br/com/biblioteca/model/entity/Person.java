package br.com.biblioteca.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "pessoa", schema = "public")
public class Person extends Identifier {

    @NotNull
    @Size(max = 100)
    @Column(nullable=false,name = "nome")
    private String name;

    @Column(name = "datanascimento")
    private LocalDate birthDate;

    @CPF
    private String cpf;

    @Column(name = "funcionario")
    private Boolean isEmployee;
}
