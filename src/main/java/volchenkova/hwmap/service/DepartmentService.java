package volchenkova.hwmap.service;

import org.springframework.stereotype.Service;
import volchenkova.hwmap.model.Employee;

import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {


    Employee findEmployeeWithMinSalary ( int departmentID );

    Employee findEmployeeWithMaxSalary ( int departmentID );

    Map<Integer, List<Employee>> findAllEmployeesByName( );

    Map<Integer, List<Employee>> findAllEmployeesSortedByName ( int departmentID );
}
