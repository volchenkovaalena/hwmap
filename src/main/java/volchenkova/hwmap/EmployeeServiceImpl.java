package volchenkova.hwmap;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final Map <String, Employee> storage = new HashMap<> (  );


    @Override
    public Employee add ( String name, String surname ) {
        Employee employee = new Employee (  name, surname );
        if (storage.containsKey ( name + surname )){
            throw new EmployeeExistException ( "такой сотрудник уже есть в базе" );
        }
        storage.put ( name + surname, employee );
        return employee;
    }

    @Override
    public void remove ( String name, String surname ) {
        if (!storage.containsKey ( name + surname )) {
            throw new EmployeeNotFoundException ( "такого сотрудника не существует" );
        }
        storage.remove ( name + surname );

    }

    @Override
    public Employee find ( String name, String surname ) {
        if (!storage.containsKey ( name + surname )) {
            throw new EmployeeNotFoundException ( "такого сотрудника не существует" );
        }
        return storage.get ( name + surname );
    }
}
