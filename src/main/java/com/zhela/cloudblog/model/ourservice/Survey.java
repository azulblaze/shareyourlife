package com.zhela.cloudblog.model.ourservice;

import java.util.Date;

public class Survey {
	
	public static final String STATUS_CAREAT = "CREATE";
	public static final String STATUS_PROCESS = "PROCESS";
	public static final String STATUS_OVERDUE = "OVERDUE";
	public static final String STATUS_STOP = "STOP";

	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.id
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private Long id;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.account
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String account;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.title
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String title;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.description
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String description;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.permission
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String permission;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.permission_param
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String permissionParam;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.view_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String viewTime;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.answer_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private Integer answerTime;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.result_permission
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String resultPermission;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.result_template
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String resultTemplate;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.status
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private String status;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.start_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private Date startTime;
	/**
	 * This field was generated by Apache iBATIS ibator. This field corresponds to the database column survey.end_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	private Date endTime;

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.id
	 * @return  the value of survey.id
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.id
	 * @param id  the value for survey.id
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.account
	 * @return  the value of survey.account
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.account
	 * @param account  the value for survey.account
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.title
	 * @return  the value of survey.title
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.title
	 * @param title  the value for survey.title
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.description
	 * @return  the value of survey.description
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.description
	 * @param description  the value for survey.description
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.permission
	 * @return  the value of survey.permission
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.permission
	 * @param permission  the value for survey.permission
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.permission_param
	 * @return  the value of survey.permission_param
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getPermissionParam() {
		return permissionParam;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.permission_param
	 * @param permissionParam  the value for survey.permission_param
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setPermissionParam(String permissionParam) {
		this.permissionParam = permissionParam;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.view_time
	 * @return  the value of survey.view_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getViewTime() {
		return viewTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.view_time
	 * @param viewTime  the value for survey.view_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.answer_time
	 * @return  the value of survey.answer_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public Integer getAnswerTime() {
		return answerTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.answer_time
	 * @param answerTime  the value for survey.answer_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setAnswerTime(Integer answerTime) {
		this.answerTime = answerTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.result_permission
	 * @return  the value of survey.result_permission
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getResultPermission() {
		return resultPermission;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.result_permission
	 * @param resultPermission  the value for survey.result_permission
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setResultPermission(String resultPermission) {
		this.resultPermission = resultPermission;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.result_template
	 * @return  the value of survey.result_template
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getResultTemplate() {
		return resultTemplate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.result_template
	 * @param resultTemplate  the value for survey.result_template
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setResultTemplate(String resultTemplate) {
		this.resultTemplate = resultTemplate;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.status
	 * @return  the value of survey.status
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.status
	 * @param status  the value for survey.status
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.start_time
	 * @return  the value of survey.start_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.start_time
	 * @param startTime  the value for survey.start_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method returns the value of the database column survey.end_time
	 * @return  the value of survey.end_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method sets the value of the database column survey.end_time
	 * @param endTime  the value for survey.end_time
	 * @ibatorgenerated  Thu Dec 16 15:38:55 CST 2010
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}