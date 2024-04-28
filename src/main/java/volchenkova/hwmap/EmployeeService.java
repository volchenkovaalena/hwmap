package volchenkova.hwmap;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeService {
    Employee add (String name, String surname, int salary, int departmentID);
    void remove (String name, String surname);
    Employee find (String name, String surname);


    Collection<Employee> findAll ();
}
