package org.dusong.edm.pojo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Role role;
	private Department department;
	private String email;
	private String password;
	private String username;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Role role, Department department, String email,
			String password, String username) {
		this.role = role;
		this.department = department;
		this.email = email;
		this.password = password;
		this.username = username;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [department=" + department + ", email=" + email + ", id="
				+ id + ", password=" + password + ", role=" + role
				+ ", username=" + username + "]";
	}

	
}