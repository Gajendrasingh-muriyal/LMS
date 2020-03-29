package com.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "leave_details")
public class LeaveDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leaveId")
	private int leaveId;

	@Column(name = "username")
	private String username;

	@NotNull(message = "Please provide start date!")
	@Column(name = "from_date")
	private String fromDate;

	@NotNull(message = "Please provide end date!")
	@Column(name = "to_date")
	private String toDate;

	@NotEmpty(message = "Please select type of leave!")
	@Column(name = "leave_type")
	private String leaveType;

	@NotEmpty(message = "Please provide a reason for the leave!")
	@Column(name = "reason")
	private String reason;

	@Column(name = "duration")
	private int duration;

	@Column(name = "ëmployee_id")
	private int userId;

	/**
	 * @return the leaveId
	 */
	public int getLeaveId() {
		return leaveId;
	}

	/**
	 * @param leaveId the leaveId to set
	 */
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the leaveType
	 */
	public String getLeaveType() {
		return leaveType;
	}

	/**
	 * @param leaveType the leaveType to set
	 */
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the empid
	 */
	public int getEmpid() {
		return userId;
	}

	/**
	 * @param empid the empid to set
	 */
	public void setEmpid(int userId) {
		this.userId = userId;
	}

}