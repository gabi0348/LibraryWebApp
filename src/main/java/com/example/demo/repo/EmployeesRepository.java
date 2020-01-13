package com.example.demo.repo;

import com.example.demo.model.Employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,Integer> {

    public Employees findByEmail(String email);
}
