package dev.EpixInc.Epix.Enums;

public enum TypeOfItemEnum {
    MOVIE("Movie"),
    SERIES("Series");

    private final String toString;

    private TypeOfItemEnum(String toString){
        this.toString = toString;
    }

    @Override
    public String toString(){
        return toString;
    }
}
