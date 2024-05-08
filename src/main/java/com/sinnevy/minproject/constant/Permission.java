package com.sinnevy.minproject.constant;

public enum Permission {

    ADMIN(1, "admin"),
    CHECK(2, "check"),
    INPUT(3, "input");

    private int key;
    private String value;

    Permission(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static Permission getPermission(String value) {
        for (Permission enums : Permission.values()) {
            if (enums.value.equals(value)) {
                return enums;
            }
        }
        return null;
    }

}
