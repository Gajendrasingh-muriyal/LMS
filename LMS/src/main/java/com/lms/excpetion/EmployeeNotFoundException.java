package com.lms.excpetion;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(int userId) throws Exception {
		// TODO Auto-generated constructor stub

		throw new Exception("Employee id Not found which is tried by client: " + userId);
	}

}
