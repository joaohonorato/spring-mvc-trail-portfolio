package br.com.biblioteca.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusEnum {
    ANALYSIS_ON_GOING("em análise"),
    ANALYSIS_DONE("análise realizada"),
    ANALYSIS_APPROVED("análise aprovada"),
    STARTED("iniciado"),
    PLANED("planejado"),
    ON_GOING("em andamento"),
    DONE("encerrado"),
    CANCELED("cancelado") ;

    @Getter private final String description;
}
