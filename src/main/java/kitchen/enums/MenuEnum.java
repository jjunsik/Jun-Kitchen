package main.java.kitchen.enums;

public enum MenuEnum {
    KOREAN("한식"), WESTERN("양식"), CHINESE("중식"), JAPANESE("일식");

    private final String name;

    MenuEnum (String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
