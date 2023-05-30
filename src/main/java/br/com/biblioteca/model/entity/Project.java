package br.com.biblioteca.model.entity;

import br.com.biblioteca.model.enums.RiskEnum;
import br.com.biblioteca.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "projeto", schema = "public")
public class Project extends Identifier {
    
    @NotNull
    @Size(max = 200)
    @Column(nullable=false,name = "nome")
    private String name;

    @Column(name = "data_inicio")
    private LocalDate beginDate;

    @Column(name = "data_previsao_fim")
    private LocalDate expectedEndDate;

    @Column(name = "data_fim")
    private LocalDate endDate;

    @Column(name = "descricao")
    private String description;

    private StatusEnum status = StatusEnum.ANALYSIS_ON_GOING;

    @Column(name = "orcamento")
    private BigDecimal totalBudget;

    @Column(name = "risco")
    private RiskEnum risk;

    @Column(name = "idgerente", nullable=false)
    private Long managerId;

    @ManyToOne
	@JoinColumn(name = "idgerente", insertable = false, updatable = false )
	private Person manager;

    public boolean deletable() {
        return !Arrays.asList(StatusEnum.STARTED,StatusEnum.ON_GOING,StatusEnum.DONE).contains(status);
    }

}
