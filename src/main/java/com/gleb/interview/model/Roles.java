package com.gleb.interview.model;

public enum Roles {
    admin("admin"),
    guest("guest");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static Roles getRoleByName(String name) {
        for (Roles r : values()) {
            if (r.getRole().equals(name)) {
                return r;
            }
        }

        throw new IllegalArgumentException("No role found with name: [" + name + "]");
    }
}
