package volchenkova.hwmap;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {


    Employee findEmployeeWithMinSalary ( int departmentID );

    Employee findEmployeeWithMaxSalary ( int departmentID );

    Map<Integer, List<Employee>> findAllEmployeesByName();

    Map<Integer, List<Employee>> findAllEmployeesByName ( int departmentID );


    Map<Integer, List<Employee>> findAllEmployeesSortedByName ( int departmentID );
}
