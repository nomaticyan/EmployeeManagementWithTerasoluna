package employee.domain.service.employee;

import java.util.Collection;

import employee.domain.model.Employee;

public interface EmployeeService {

    Collection<Employee> findAll();
    
    Collection<Employee> search(String todoId);
    
    Employee findOne(String todoId);

    Employee create(Employee emp);

    Employee finish(String employeeId);

    void delete(String employeeId);



}
