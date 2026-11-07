package dev.manuchus.main.employee;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service  
public class EmployeeService {
    private  final  AtomicInteger nextId = new AtomicInteger(1);
    private final ConcurrentHashMap<Integer, Employee > map = new ConcurrentHashMap<>();
    // надо ещё проверку сделать , потому что если будет проблема с Employee то просто id останется пустым и будет пробел в БД


    public Employee create(CreateEmployeeRequest request) {
        int id = nextId.getAndIncrement();
        Employee newEmployee = new Employee(request.name(), request.position(), id);
        map.put(id, newEmployee);
        return newEmployee;
    }

    public List<Employee> getEmployees() {
        
        return new ArrayList<>(map.values());

    }


    public Employee getEmployeer(int id)
    {
        if (id <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
            "ID must be positive"
            );
        }
        Employee employeer = map.get(id);

        if (employeer == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Employee with ID " + id + " not found"
            );
        }

        return employeer;
    }

    public void  deleteEmployeer(int id)
    {
        if (id <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
            "ID must be positive"
            );
        }

        Employee employeer = map.remove(id);

       if (employeer == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Employee with ID " + id + " not found"
            );
        }

        
    }



}
