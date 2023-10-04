package com.example.searchApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.searchApp.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findById(long id);
	
	Optional<Employee> findNameWithKeyword(String ename);

	@Query("SELECT e FROM Employee e WHERE CONCAT(e.ename, ' ', e.mobile, ' ', e.salary, ' ') LIKE %?1%")
	public List<Employee> search(String keyword);
}
