package pl.coderslab.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import pl.coderslab.entity.Employee;
import pl.coderslab.repository.EmployeeRepository;

@Controller
public class UserPanelController {

	@Autowired
	private EmployeeRepository employeeRepo; //TODO: It should be renamed to user, employee is a role
	
	@ModelAttribute("currentDate")
	public LocalDate currentDate() {
		LocalDate currentDate = LocalDate.now();
		return currentDate;
	}
	
	
	@GetMapping("/user/{id}/panel")
	public String userPanel(@PathVariable Long id, Model model) {
		
		Employee employee = employeeRepo.findById(id).get();
		
		model.addAttribute("employee", employee);
		
		return "userPanel";
	}
}
