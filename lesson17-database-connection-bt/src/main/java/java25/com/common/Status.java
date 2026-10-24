package java25.com.common;

import java.util.Map;

public enum Status {
    Active(1),
    Disabled(0);

    private int value;

    private static Map<Integer, Status> VALUE_ENUM_MAP = Map.of(1, Active,
            0, Disabled);

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Status getName(int value) {
        return VALUE_ENUM_MAP.get(value);
    }
}
