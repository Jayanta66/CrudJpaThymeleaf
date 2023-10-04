package com.example.searchApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.searchApp.bean.Employee;
import com.example.searchApp.service.Impl.EmployeeServiceImpl;

@Controller
public class searchWithKeyword {
	
	
    @Autowired
    private EmployeeServiceImpl service;

//    @GetMapping("/")
//    public String add(Model model) {
//    	List<Employee> listemployee = service.listAll();
//        model.addAttribute("employee", new Employee());
//        return "searchWithKeyword";
//    }

    
    @PostMapping("/searchWithKeyword")
     public String doSearchEmployee(@ModelAttribute("employeeSearchWithKeyWordFormData") Employee formData, Model model) {
            Employee employee = service.getNameWithKeyword(formData.getEname());
            model.addAttribute("employee", employee);
            return "searchWithKeyword";            
     }
    
    @GetMapping({"/searchWithKeyword"})
    public String searchwithkeyword(Model model, @Param("keyword") String keyword) {
		List<Employee> employee = service.listEmployeeWithKeyword(keyword);
		model.addAttribute("employee", employee);
		model.addAttribute("keyword", keyword);
    	
    	return "searchWithKeyword";
		}

}
