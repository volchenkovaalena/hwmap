package volchenkova.hwmap;

public interface EmployeeService {
    Employee add (String name, String surname);
    void remove (String name, String surname);
    Employee find (String name, String surname);

}
