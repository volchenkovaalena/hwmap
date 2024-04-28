package volchenkova.hwmap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController ( EmployeeService employeeService ) {
        this.employeeService = employeeService;
    }
    @GetMapping ("/add")
    public  Employee addEmployee ( @RequestParam String name, @RequestParam String surname, @RequestParam int salary, @RequestParam int departmentID) {
        return employeeService.add ( name, surname, salary, departmentID );
    }

    @GetMapping ("/remove")
    public void removeEmployee ( @RequestParam String name, @RequestParam String surname ) {
        employeeService.remove ( name, surname );
    }

    @GetMapping ("/find")
    public  Employee findEmployee ( @RequestParam String name, @RequestParam String surname ) {
        return employeeService.find ( name, surname );
    }
}



