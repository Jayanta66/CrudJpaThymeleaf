package com.example.searchApp.service;

import java.util.List;

import com.example.searchApp.bean.Employee;

public interface EmployeeService {
	public List<Employee> listAll();
	
	public Employee get(long id);
	
	public Employee getNameWithKeyword(String ename);

	
	public List<Employee> listEmployeeWithKeyword(String keyword);
}
