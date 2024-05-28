package com.example.crudRestDemo.controller;

import com.example.crudRestDemo.entity.Employee;
import com.example.crudRestDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        // get employees from db
        List<Employee> employeeList = employeeService.findAll();

        // add to the spring model
        model.addAttribute("employees", employeeList);

        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model model) {

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // save employee
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:list";

    }
}
