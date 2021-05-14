package com.gleb.interview.model;

public enum QType {
    text("text"),
    single("single"),
    multiple("multiple");

    private final String type;

    QType(String role) {
        this.type = role;
    }

    public String getType() {
        return type;
    }

    public static QType getTypeByName(String name) {
        for (QType t: values()) {
            if (t.getType().equals(name)) {
                return t;
            }
        }

        throw new IllegalArgumentException("No type found with name: [" + name + "]");
    }
}
