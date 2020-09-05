package com.example.blog.model;

public enum Category {
    DEV("Programming"),
    DEV_OPS("Administration"),
    TESTING("Testing");
    private String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
