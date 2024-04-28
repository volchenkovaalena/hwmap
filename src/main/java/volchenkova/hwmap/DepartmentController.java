package volchenkova.hwmap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class DepartmentController implements DepartmentService{
    private final DepartmentService departmentService;

    public DepartmentController ( DepartmentService departmentService ) {
        this.departmentService = departmentService;
    }
    @GetMapping ("/min-salary")
    public Employee findEmployeeWithMinSalary( @RequestParam int departmentID ) {
        return departmentService.findEmployeeWithMinSalary(departmentID);
    }

    @GetMapping ("/max-salary")
    public Employee findEmployeeWithMaxSalary( @RequestParam int departmentID ) {
        return departmentService.findEmployeeWithMaxSalary(departmentID);
    }


    @GetMapping ("/all")
    public Map<Integer, List <Employee>> findAllEmployeesByName(){
        return departmentService.findAllEmployeesByName();
    }

    @GetMapping(path = "/all", params = {"departmentID"})
    public Map<Integer, List<Employee>> findAllEmployeesSortedByName( @RequestParam int departmentID) {
        return departmentService.findAllEmployeesSortedByName();
    }

}
