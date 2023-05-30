package br.com.biblioteca.model.dto;

import br.com.biblioteca.model.enums.RiskEnum;
import br.com.biblioteca.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class ProjectDTO {

    private Long id;

    @NotEmpty
    private String name;
   
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate beginDate;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate expectedEndDate;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate endDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Min(value = 0)
    private BigDecimal totalBudget;

    @Enumerated(EnumType.STRING)
    private RiskEnum risk;
    
    @NotNull
    private Long managerId;

    private PersonDTO manager;

}
