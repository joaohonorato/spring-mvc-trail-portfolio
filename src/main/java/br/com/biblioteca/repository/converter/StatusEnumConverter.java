package br.com.biblioteca.repository.converter;

import br.com.biblioteca.model.enums.StatusEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Objects;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum statusEnum) {
        return statusEnum.getDescription();
    }

    @Override
    public StatusEnum convertToEntityAttribute(String description) {
        if(Objects.isNull(description)) {
            return null;
        }
        return Arrays.stream(StatusEnum.values())
                .filter(statusEnum -> statusEnum.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}