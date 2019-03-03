
package ru.milandr.courses.rjdb.entities.enums;

public enum Area {
    CENTRAL((short) 0),
    NORTHERN((short) 1),
    NORTH_EASTERN((short) 2),
    EASTERN((short) 3),
    SOUTH_EASTERN((short) 4),
    SOUTHERN((short) 5),
    SOUTH_WESTERN((short) 6),
    WESTERN((short) 7),
    NORTH_WESTERN((short) 8),
    ZELENOGRADSKY((short) 9);



    private short value;

    Area(short value) {
        this.value = value;
    }

    public short getValue() {
        return value;
    }

    public static Area parse(short id) {
        Area right = null; // Default
        for (Area item : Area.values()) {
            if (item.getValue() == id) {
                right = item;
                break;
            }
        }
        return right;
    }
}