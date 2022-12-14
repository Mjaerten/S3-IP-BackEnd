package dev.EpixInc.Epix.Enums;

public enum TypeOfUserEnum {

    CHILD("Child"),
    PARENT("Parent"),
    ADMINISTRATOR("Administrator");

    private final String toString;

    private TypeOfUserEnum(String toString){
        this.toString = toString;
    }

    @Override
    public String toString(){
        return toString;
    }
}

