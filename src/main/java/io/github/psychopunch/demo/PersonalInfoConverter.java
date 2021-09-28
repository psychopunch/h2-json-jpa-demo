package io.github.psychopunch.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public class PersonalInfoConverter implements AttributeConverter<PersonalInfo, String> {

    private final ObjectMapper objectMapper;

    public PersonalInfoConverter() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Override
    public String convertToDatabaseColumn(PersonalInfo attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PersonalInfo convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, PersonalInfo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
