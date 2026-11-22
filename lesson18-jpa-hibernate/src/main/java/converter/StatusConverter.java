package converter;

import enumeration.Status;
import jakarta.persistence.AttributeConverter;

public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return status == null ? null : status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(Integer value) {
        return value == null ? null : Status.getName(value);
    }
}
