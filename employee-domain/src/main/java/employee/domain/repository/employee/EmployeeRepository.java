package employee.domain.repository.employee;

import java.util.Collection;

import employee.domain.model.Employee;


public interface EmployeeRepository {
	Collection<Employee> search(String employeeId);

    Collection<Employee> findAll();
    
    Employee findOne(String todoId);

    void create(Employee todo);

    boolean update(Employee todo);

    void delete(String employeeId);
    
    
}
