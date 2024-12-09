package com.example.SpringDataREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/employees")
    public String employees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "employees";
    }
}
