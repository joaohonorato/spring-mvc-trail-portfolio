package br.com.biblioteca.repository.converter;

import br.com.biblioteca.model.enums.RiskEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Objects;

@Converter(autoApply = true)
public class RiskEnumConverter implements AttributeConverter<RiskEnum, String> {

    @Override
    public String convertToDatabaseColumn(RiskEnum statusEnum) {

        return statusEnum.getClassification();
    }

    @Override
    public RiskEnum convertToEntityAttribute(String classification) {
        if(Objects.isNull(classification)) {
            return null;
        }
        return Arrays.stream(RiskEnum.values())
                .filter(riskEnum -> riskEnum.getClassification().equalsIgnoreCase(classification))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}