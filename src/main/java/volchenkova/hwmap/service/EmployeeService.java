package volchenkova.hwmap.service;

import volchenkova.hwmap.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add ( String name, String surname, int salary, int departmentID);
    void remove (String name, String surname);
    Employee find (String name, String surname);


    Collection<Employee> findAll ();
}
