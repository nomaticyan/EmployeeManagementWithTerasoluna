package employee.domain.service.employee;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import employee.domain.model.Employee;

public interface EmployeeService {

    Page<Employee> findAll(Employee criteria, Pageable pageable);
    
    Collection<Employee> search(String todoId);
    
    Employee findOne(String todoId);

    Employee create(Employee emp);

    Employee finish(String employeeId);

    void delete(String employeeId);



}
