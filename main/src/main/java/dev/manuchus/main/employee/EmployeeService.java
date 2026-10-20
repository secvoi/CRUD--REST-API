package dev.manuchus.main.employee;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service  
public class EmployeeService {
    public final  AtomicInteger nextId = new AtomicInteger(1);
    public final ConcurrentHashMap<Integer, Employee > map = new ConcurrentHashMap<>();

    public Employee create(CreateEmployeeRequest request) {
        int id = nextId.getAndIncrement();
        Employee newEmployee = new Employee(request.name(), request.position(), id);

        return newEmployee;
    
}
}
