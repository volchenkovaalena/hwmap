package volchenkova.hwmap;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;

    public DepartmentServiceImpl ( EmployeeService employeeService ) {
        this.employeeService = employeeService;
    }

    /**
     *
     * @return Находит сотрудника с минимальной зарплатой
     */
    @Override
    public Employee findEmployeeWithMinSalary ( int departmentID ) {
        return employeeService
                .findAll()
                .stream()
                .filter ( e -> e.getDepartmentID () = departmentID)
                .min( comparingInt ( Employee::getSalary ))
                .orElseThrow (EmployeeNotFoundException::new);;
    }

    /**
     *
     * @return Возвращает сотрудника с максимальной зарплатой
     */
    @Override
    public Employee findEmployeeWithMaxSalary ( int departmentID ) {
        return employeeService
                .findAll()
                .stream()
                .filter ( e -> e.getDepartmentID () = departmentID)
                .max ( comparingInt ( Employee::getSalary ))
                .orElseThrow (EmployeeNotFoundException::new);;
    }

    /**
     *
     * @return  Возвращать всех сотрудников с разделением по отделам
     */

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesByName (  ) {
        return employeeService
                .findAll()
                .stream()
                .sorted (comparing (Employee::getSurname)
                        .thenComparing ( Employee::getName ))
                .collect ( groupingBy ( Employee::getDepartmentID ));
    }

    /**
     *
     * @return Возвращает всех сотрудников отдела
     */

    @Override
    public Map<Integer, List<Employee>> findAllEmployeesSortedByName (int departmentID) {
        return employeeService
                .findAll()
                .stream()
                .filter ( e -> e.getDepartmentID () = departmentID )
                .sorted (comparing (Employee::getSurname)
                        .thenComparing ( Employee::getName ))
                .collect ( toList());
    }

}
