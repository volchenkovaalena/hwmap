package volchenkova.hwmap;

import java.util.Objects;

public class Employee {

    private static String name;
    private static String surname;

    private static int salary;
    private static int departmentID;


    public Employee ( String name, String surname ) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.departmentID = departmentID;
    }
    public  String getName () {
        return name;
    }
    public  String getSurname () {
        return surname;
    }

    public int getSalary() {return salary;}
    public int getDepartmentID(){return  departmentID;}
    public void setSurname ( String surname ) {
        this.surname = surname;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String toString () {
        return  "ФИО: " + this.surname+ " " +
                 this.name + " " + this.salary + " " + this.departmentID;
    }

    @Override
    public int hashCode () {
        return Objects.hash (name,surname );
    }

    @Override
    public boolean equals ( Object obj ) {
        return super.equals ( obj );
    }
}