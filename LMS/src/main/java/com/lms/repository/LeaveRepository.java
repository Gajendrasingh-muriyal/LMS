package com.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.entity.LeaveDetails;

@Repository(value = "leaveManageRepository")

public interface LeaveRepository extends JpaRepository<LeaveDetails, Integer> {

	public List<LeaveDetails> findByUserId(Integer userId);

	public Optional<LeaveDetails> findByLeaveIdAndUserId(Integer leaveId, Integer userId);

}