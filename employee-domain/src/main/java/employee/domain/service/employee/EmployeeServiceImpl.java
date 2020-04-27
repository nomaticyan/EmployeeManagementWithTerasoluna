package employee.domain.service.employee;

import java.util.Collection;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;
import employee.domain.model.Employee;
import employee.domain.repository.employee.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;
    
    @Override
    @Transactional(readOnly = true) 
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }
    
    @Override
    public Collection<Employee> search(String employeeId) {
    	Collection<Employee> todo = employeeRepository.search(employeeId);
        if (todo == null) {
            ResultMessages messages = ResultMessages.error();
            messages.add(ResultMessage
                    .fromText("[E404] The requested Todo is not found. (id="
                            + employeeId + ")"));
            throw new ResourceNotFoundException(messages);
        }
        return todo;
    }

	@Override
	public Employee create(Employee emp) {
		employeeRepository.create(emp);
        /* REMOVE THIS LINE IF YOU USE JPA
            todoRepository.save(todo); // 10
           REMOVE THIS LINE IF YOU USE JPA */
		return emp;
	}

	@Override
	public Employee finish(String employeeId) {
		return null;
	}

	@Override
	public void delete(String employeeId) {
		employeeRepository.delete(employeeId);
	}

	@Override
	public Employee findOne(String employeeId) {
		return employeeRepository.findOne(employeeId);
	}



}
