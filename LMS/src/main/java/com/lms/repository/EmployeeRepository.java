package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.EmployeeInfo;

public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Integer> {

}