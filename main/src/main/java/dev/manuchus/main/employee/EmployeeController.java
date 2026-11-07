package dev.manuchus.main.employee;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

    // что то не то здесь делаю , надо пересмотреть логику
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    //Здесь перепревязать под PostgreSQL ну позжеы
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        
        return employeeService.getEmployees();
    }


    //Добавить ещё надо обработки 200 , 201 и ещё чёта
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee(@Valid @RequestBody CreateEmployeeRequest request ) {

        return employeeService.create(request);
    }
}