package employee.app.employee;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import employee.app.employee.EmployeeForm.EmployeeCreate;
import employee.domain.model.Account;
import employee.domain.model.Employee;
import employee.domain.service.employee.EmployeeService;
import employee.domain.service.userdetails.SampleUserDetails;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@Inject
	Mapper beanMapper;

	@ModelAttribute
	public EmployeeForm setUpForm() {
		EmployeeForm form = new EmployeeForm();
		return form;
	}

	@Inject
	EmployeeService employeeService;

	/*
	 * @InitBinder("employeeForm") public void customizeBinding (WebDataBinder
	 * binder) { SimpleDateFormat dateFormatter = new
	 * SimpleDateFormat("yyyy-MM-dd"); dateFormatter.setLenient(false);
	 * binder.registerCustomEditor(Date.class, "birthdate", new
	 * CustomDateEditor(dateFormatter, true)); }
	 */
	
	@RequestMapping
	public String view(@AuthenticationPrincipal SampleUserDetails userDetails, // (1)
			Model model) {
		// (2)
		Account account = userDetails.getAccount();
		model.addAttribute(account);
		Collection<Employee> employee = employeeService.findAll();
		System.out.println("Employee Name  =" + employee.toString());
		model.addAttribute("employees", employee);

		return "employee/search";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@AuthenticationPrincipal SampleUserDetails userDetails, // (1)
			Model model) {
		// (2)
		Account account = userDetails.getAccount();
		model.addAttribute(account);
		model.addAttribute("EmployeeForm", new EmployeeForm());
		return "employee/register";
	}

	/*
	 * @RequestMapping(value = "create", method = RequestMethod.POST) public String
	 * create(@ModelAttribute("employeeForm") EmployeeForm employeeForm,
	 * BindingResult bindingResult, Model model, RedirectAttributes attributes,
	 * 
	 * @AuthenticationPrincipal SampleUserDetails userDetails) {
	 * System.out.println("In create method"); System.out.println("Name =" +
	 * employeeForm.toString()); if (bindingResult.hasErrors()) { return
	 * view(userDetails, model); }
	 * 
	 * Employee employee = beanMapper.map(employeeForm, Employee.class);
	 * model.addAttribute("employees", employee);
	 * System.out.println("Employee model:" + employee.toString()); try {
	 * employeeService.create(employee); } catch (BusinessException e) {
	 * model.addAttribute(e.getResultMessages()); return view(userDetails, model); }
	 * 
	 * attributes.addFlashAttribute(ResultMessages.success().add(ResultMessage.
	 * fromText("Created successfully!"))); return view(userDetails, model); }
	 */
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@ModelAttribute("employeeForm") EmployeeForm employeeForm,
			BindingResult bindingResult, Model model, RedirectAttributes attributes,
			@AuthenticationPrincipal SampleUserDetails userDetails) {

		System.out.println("Model="+ model.toString());
		System.out.println("In create method");
		System.out.println("Name =" + employeeForm.toString());
		if (bindingResult.hasErrors()) {
			return view(userDetails, model);
		}

		Employee employee = beanMapper.map(employeeForm, Employee.class);
		model.addAttribute("employees", employee);
		System.out.println("Employee model:" + employee.toString());
		try {
			employeeService.create(employee);
		} catch (BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return view(userDetails, model);
		}

		attributes.addFlashAttribute(ResultMessages.success().add(ResultMessage.fromText("Created successfully!")));
		return view(userDetails, model);
	}


	@RequestMapping(value = "/confirmForm" , method = RequestMethod.POST)
	public String submitForm(@Validated({ Default.class, EmployeeCreate.class }) @ModelAttribute("employeeForm") EmployeeForm employeeForm, Model model, BindingResult bindingResult, @AuthenticationPrincipal SampleUserDetails userDetails) {
		System.out.println("Model="+ model.toString());
		if (bindingResult.hasErrors()) {
			return view(userDetails, model);
		}
		if ("1".equals(employeeForm.getDepartmentId())) {
			employeeForm.setDepartmentName("System Development");
		} else if ("2".equals(employeeForm.getDepartmentId())) {
			System.out.println("I am Here");
			employeeForm.setDepartmentName("Infra");
		} else if ("3".equals(employeeForm.getDepartmentId())) {
			employeeForm.setDepartmentName("HR");
		} else {
			employeeForm.setDepartmentName("Finance");
		}
		
		if ("1".equals(employeeForm.getLevelId())) {
			employeeForm.setLevelName("N1");
		} else if ("2".equals(employeeForm.getLevelId())) {
			employeeForm.setLevelName("N2");
		} else if ("3".equals(employeeForm.getLevelId())) {
			employeeForm.setLevelName("N3");
		} else if ("4".equals(employeeForm.getLevelId())){
			employeeForm.setLevelName("N4");
		} else if ("5".equals(employeeForm.getLevelId())){
			employeeForm.setLevelName("N5");
		} else {
			employeeForm.setLevelName("Beginner");
		}
		
		if ("1".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("JSE");
		} else if ("2".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("SE");
		} else if ("3".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("SSE");
		} else if ("4".equals(employeeForm.getPositionId())){
			employeeForm.setPositionName("TL");
		} else if ("5".equals(employeeForm.getPositionId())){
			employeeForm.setPositionName("PL");
		} else if ("6".equals(employeeForm.getPositionId())){
			employeeForm.setPositionName("PM");
		} else if ("7".equals(employeeForm.getPositionId())){
			employeeForm.setPositionName("Junior HR");
		} else {
			employeeForm.setPositionName("Senior HR");
		}
		model.addAttribute("employeeForm", employeeForm);
		System.out.println("employeeForm=" + employeeForm.toString());
		
		return "employee/confirm";
	}
}
