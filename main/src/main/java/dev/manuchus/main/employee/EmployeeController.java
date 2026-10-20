package dev.manuchus.main.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EmployeeController {

    private final List<Employee> data = new ArrayList<>();

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return data;
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee) {
        if (employee.name() == null || employee.name().isBlank()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Name is required"
            );
        }

        data.add(employee);
        return employee;
    }
}