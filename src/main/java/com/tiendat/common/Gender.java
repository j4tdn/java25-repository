package com.tiendat.common;

import java.util.Map;

public enum Gender {
    MALE(1),
    FEMALE(0);

    private int value;

    private static Map<Integer, Gender> map = Map.of(0, FEMALE,
            1, MALE);

    Gender(int value) {
        this.value = value;
    }

    public static Gender get(int value) {
        return map.get(value);
    }
}
