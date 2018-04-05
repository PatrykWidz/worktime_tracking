package pl.coderslab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entity.Employee;
import pl.coderslab.repository.EmployeeRepository;

@Controller
@RequestMapping("/employee")
public class EmployeeControler {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@ModelAttribute("employees")
	public List<Employee> employees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/all")
	public String loadAll() {
		
		return "employees";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "addEmployeeForm";
	}
	
	@PostMapping("/add")
	public String save(@ModelAttribute Employee employee) {
		
		employeeRepository.save(employee);
		
		return "redirect: /worktime-tracking/employee/all";
	}
}
