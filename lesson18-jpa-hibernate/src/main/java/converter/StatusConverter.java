package converter;

import enumeration.Status;
import jakarta.persistence.AttributeConverter;

public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer dbData) {
        return dbData == null ? null : Status.getName(dbData);
    }
}
