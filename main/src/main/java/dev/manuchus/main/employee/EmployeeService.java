package dev.manuchus.main.employee;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

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

}
