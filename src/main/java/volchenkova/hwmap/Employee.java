package volchenkova.hwmap;

import java.util.Objects;

public class Employee {

    private static String name;
    private static String surname;


    public Employee ( String name, String surname ) {
        this.name = name;
        this.surname = surname;
    }
    public static String getName () {
        return name;
    }
    public static String getSurname () {
        return surname;
    }
    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String toString () {
        return  "ФИО: " + this.surname+ " " +
                 this.name;
    }

    @Override
    public boolean equals ( Object obj ) {
        return super.equals ( obj );
    }

    public int hashCode () {
        return Objects.hash ( name, surname);
    }
}