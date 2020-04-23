package employee.app.employee;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import employee.domain.model.Account;
import employee.domain.service.userdetails.SampleUserDetails;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@RequestMapping
    public String view(
            @AuthenticationPrincipal SampleUserDetails userDetails, // (1)
            Model model) {
        // (2)
        Account account = userDetails.getAccount();
        model.addAttribute(account);
        return "employee/search";
    }
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(
            @AuthenticationPrincipal SampleUserDetails userDetails, // (1)
            Model model) {
        // (2)
        Account account = userDetails.getAccount();
        model.addAttribute(account);
        return "employee/register";
    }
}


