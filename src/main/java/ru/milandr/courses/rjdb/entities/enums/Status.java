package ru.milandr.courses.rjdb.entities.enums;

public enum Status {
    INACTIVE((short) 0),
    ACTIVE((short) 1),
    UNSENT((short) 2),
    REJECTED((short) 3),
    ADMITTED((short) 4),
    PENDING((short ) 5);

    private short value;

    Status(short value) {
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
