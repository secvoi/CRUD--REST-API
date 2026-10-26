package dev.manuchus.main.employee;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    // что то не то здесь делаю , надо пересмотреть логику
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    //Здесь перепревязать под PostgreSQL ну позже
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        
        return employeeService.getEmployees();
    }


    //Добавить ещё надо обработки 200 , 201 и ещё чёта
    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody CreateEmployeeRequest request ) {

        return employeeService.create(request);
    }
}