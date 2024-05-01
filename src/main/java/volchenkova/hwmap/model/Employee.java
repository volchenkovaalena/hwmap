package volchenkova.hwmap.model;

import java.util.Objects;

public class Employee {

    private  String name;
    private  String surname;
    private  int salary;
    private int departmentID;


    public Employee ( String name, String surname, int salary, int departmentID ) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.departmentID =departmentID;
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