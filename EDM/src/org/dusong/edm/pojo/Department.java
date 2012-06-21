package org.dusong.edm.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remark;
	private String connName;
	private String connPhone;
	private String address;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** full constructor */
	public Department(String name, String remark, String connName,
			String connPhone, String address, Set users) {
		this.name = name;
		this.remark = remark;
		this.connName = connName;
		this.connPhone = connPhone;
		this.address = address;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getConnName() {
		return this.connName;
	}

	public void setConnName(String connName) {
		this.connName = connName;
	}

	public String getConnPhone() {
		return this.connPhone;
	}

	public void setConnPhone(String connPhone) {
		this.connPhone = connPhone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Department [address=" + address + ", connName=" + connName
				+ ", connPhone=" + connPhone + ", id=" + id + ", name=" + name
				+ ", remark=" + remark + ", users=" + users + "]";
	}

}