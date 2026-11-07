package dev.manuchus.main.employee;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
public class EmployeeController {


    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    //Здесь перепревязать под PostgreSQL ну позже
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        
        return employeeService.getEmployees();
    }


    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee(@Valid @RequestBody CreateEmployeeRequest request ) {

        return employeeService.create(request);
    }


    @DeleteMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeer(@PathVariable("id") int id)
    {
        employeeService.deleteEmployeer(id);
    }    
    
    @GetMapping("/employees/{id}")
    public Employee getMethodName(@PathVariable("id") int id) {
        return employeeService.getEmployeer(id);
    }
    




}