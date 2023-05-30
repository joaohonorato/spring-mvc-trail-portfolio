package br.com.biblioteca.model.dto;

import br.com.biblioteca.model.vo.CpfVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class PersonDTO {

    private Long id;
    
    @NotBlank
    private String name;

    private LocalDate birthDate;

    @CPF
    private CpfVO cpf;

    @NotNull
    private Boolean isEmployee;
}
