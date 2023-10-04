package com.example.searchApp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.searchApp.bean.Employee;
import com.example.searchApp.repository.EmployeeRepository;
import com.example.searchApp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
    private EmployeeRepository repo;

	@Override
	public List<Employee> listAll() {
	        return repo.findAll();
	}

	@Override
	public Employee get(long id) {
        return repo.findById(id).get();

	}

	@Override
	public List<Employee> listEmployeeWithKeyword(String keyword) {

		if(keyword !=null) {
			return repo.search(keyword);
		}
		
		return repo.findAll();
	}

	@Override
	public Employee getNameWithKeyword(String ename) {
		return repo.findNameWithKeyword(ename).get();
	}

}
