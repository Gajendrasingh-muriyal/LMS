package com.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.lms.dto.LeaveDetailsDTO;
import com.lms.entity.EmployeeInfo;
import com.lms.entity.LeaveDetails;
import com.lms.excpetion.EmployeeNotFoundException;
import com.lms.excpetion.LeavesNotAvailableException;
import com.lms.excpetion.UserNotFoundException;
import com.lms.repository.EmployeeRepository;
import com.lms.repository.LeaveRepository;

@Service
public class EmployeeInfoSeriveImpl implements EmployeeInfoSerive {

	Logger logger = LoggerFactory.getLogger(EmployeeInfoSeriveImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LeaveRepository leaveRepository;

	/**
	 * Method is used to fetch leaves of particular user id
	 * 
	 * @throws Exception
	 * @throws UserNotFoundException        when user not exist
	 * @throws LeavesNotAvailableException  when leaves not available
	 * @throws LeaveIdNotAvailableException when leave id doesn't exist
	 * @throws LeavesNotAvailableException  when leaves not available
	 * @throws InvalidToDateException       when client enters invalid To date
	 * @throws InvalidFromDateException     when client enters invalid To date
	 */
	@Transactional
	public List<LeaveDetailsDTO> getLeavsByUserId(Integer userId) throws LeavesNotAvailableException, Exception {
		logger.info("Get Leaves of Employee By Id method invoked");

		Optional<EmployeeInfo> emp = employeeRepository.findById(userId);

		logger.debug("Employee  Id fetched succesfuly from the repository " + emp);

		if (!emp.isPresent()) {
			throw new EmployeeNotFoundException(userId);
		}

		List<LeaveDetails> leaves = leaveRepository.findByUserId(userId);

		logger.debug("Employee  Leaves fetched succesfuly from the leaverepository " + leaves);

		if (CollectionUtils.isEmpty(leaves)) {
			throw new LeavesNotAvailableException(userId);
		}

		return leaves.stream().map(leave -> {
			LeaveDetailsDTO leaveDTO = new LeaveDetailsDTO();
			logger.debug("LeaveDetailsDTO object details before copying" + leaveDTO);
			BeanUtils.copyProperties(leave, leaveDTO);
			logger.debug("LeaveDetailsDTO object details after copying" + leave);
			return leaveDTO;
		}).collect(Collectors.toList());

	}

}