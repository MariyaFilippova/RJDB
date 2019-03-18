package ru.milandr.courses.rjdb.entities.enums;

public enum Dependency {
    RESPONSE((short)1),
    OFFER((short)2);


    private short value;

    Dependency(short value) {
        this.value = value;
    }

    public short getValue() {
        return value;
    }

    public static Status parse(short id) {
        Status right = null; // Default
        for (Status item : Status.values()) {
            if (item.getValue() == id) {
                right = item;
                break;
            }
        }
        return right;
    }
}
