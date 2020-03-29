package com.lms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lms.dto.LeaveDetailsDTO;
import com.lms.entity.EmployeeInfo;
import com.lms.entity.LeaveDetails;
import com.lms.excpetion.EmployeeNotFoundException;
import com.lms.repository.EmployeeRepository;
import com.lms.repository.LeaveRepository;
import com.lms.service.EmployeeInfoSerive;

@RestController
@RequestMapping("/employee")

public class EmployeeLeaveController {

	Logger logger = LoggerFactory.getLogger(EmployeeLeaveController.class);

	@Autowired
	private EmployeeInfoSerive empservice;

	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/jpa/applyleave/{userId}/leaveId")
	public ResponseEntity<Object> ApplyLeave(@PathVariable int userId, @RequestBody LeaveDetails leaveDetails)
			throws EmployeeNotFoundException, Exception {
		// List<LeaveDetails> empDetails = leaveRepository.findByUserId(userId);

		logger.info("Applying leave method started succesfully");

		Optional<EmployeeInfo> emp = employeeRepository.findById(userId);

		logger.debug("Fetching the employee details based on employee Id " + emp);

		if (!emp.isPresent()) {
			throw new EmployeeNotFoundException(userId);
		}

		logger.debug("Map the employee details based on employee Id to the leaveDetails");
		// map the employee to the leave
		leaveDetails.setEmpid(userId);
		// save leaveDetails to the database
		leaveRepository.save(leaveDetails);

		logger.debug("Leave Details saved into the repository succesfully " + leaveDetails);
		// getting the path of the leave and append leaveid of the leaveDetails to the
		// URI
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(leaveDetails.getLeaveId()).toUri();
		logger.debug("Apply leave of employee URL is going to create " + location);

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<LeaveDetailsDTO>> getLeavsByUserId(@PathVariable Integer userId)
			throws EmployeeNotFoundException, Exception {

		logger.info("Fetching the employee leave details based on employee Id");

		return new ResponseEntity<>(empservice.getLeavsByUserId(userId), HttpStatus.OK);

	}

}
