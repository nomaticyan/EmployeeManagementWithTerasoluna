package employee.domain.repository.employee;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import employee.domain.model.Employee;


public interface EmployeeRepository {
	Collection<Employee> search(String employeeId);

    Collection<Employee> findAll();
    
    Employee findOne(String todoId);

    void create(Employee todo);
 
    boolean update(Employee todo);

    void delete(String employeeId);

    List<Employee> findPageBySearchCriteria(
            @Param("criteria") Employee criteria,
            @Param("pageable") Pageable pageable);

    long countBySearchCriteria();
    
}
