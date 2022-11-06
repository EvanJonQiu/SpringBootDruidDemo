package com.example.demo.model.secondary;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "login_log")
public class SecondaryLoginLog implements Serializable {
	
	private static final long serialVersionUID = -6316739048244522104L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "login_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginTime;
	
	@Column(name = "message")
	private String message;
	
	public SecondaryLoginLog() {}
	
	public SecondaryLoginLog(String username, Date loginTime, String msg) {
		this.setUsername(username);
		this.setLoginTime(loginTime);
		this.setMessage(msg);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
