package volchenkova.hwmap.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import volchenkova.hwmap.exception.InvalidNameException;
import volchenkova.hwmap.model.Employee;
import volchenkova.hwmap.exception.EmployeeExistException;
import volchenkova.hwmap.exception.EmployeeNotFoundException;
import volchenkova.hwmap.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map <String, Employee> storage = new HashMap<> (  );


    @Override
    public Employee add ( String name, String surname, int salary, int departmentID ) {
        validateNames ( name, surname );
        Employee employee = new Employee (  capitalize (name), capitalize (surname), salary, departmentID );
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

    @Override
    public Collection<Employee> findAll () {
        return Collections.unmodifiableCollection (storage.values() );
    }

    private void  validateNames (String...names){
        for(String name: names) {
            if ( isAlpha ( name ) ) {
                throw new InvalidNameException ( "Имя неккоректно написано" );
            }
        }
    }


}
