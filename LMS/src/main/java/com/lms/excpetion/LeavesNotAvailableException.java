package com.lms.excpetion;

public class LeavesNotAvailableException extends RuntimeException {

	public LeavesNotAvailableException(Integer userId) throws Exception {
		// TODO Auto-generated constructor stub

		throw new Exception("Leave is not available for the requested employee: " + userId);
	}

}
