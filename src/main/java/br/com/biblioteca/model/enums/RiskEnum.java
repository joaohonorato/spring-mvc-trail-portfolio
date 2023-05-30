package br.com.biblioteca.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RiskEnum {

    BAIXO_RISCO("baixo risco"),
    MEDIO_RISCO("médio risco"),
    ALTO_RISCO("alto risco");

    @Getter private final String classification;

}
