package com.lms.service;

import java.util.List;

import com.lms.dto.LeaveDetailsDTO;
import com.lms.excpetion.EmployeeNotFoundException;

public interface EmployeeInfoSerive {

	public List<LeaveDetailsDTO> getLeavsByUserId(Integer userId) throws EmployeeNotFoundException, Exception;

	// public LeaveResponse applyLeave(Integer empId, LeaveRequest leaveRequest);

}