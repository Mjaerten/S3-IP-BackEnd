package dev.EpixInc.Epix.Enums;

public enum TypeOfItemEnum {
    MOVIE("Movie"),
    SERIES("Series");

    private final String toString;

    private TypeOfItemEnum(String toString){
        this.toString = toString;
    }

    public String toString(){
        return toString;
    }
}
