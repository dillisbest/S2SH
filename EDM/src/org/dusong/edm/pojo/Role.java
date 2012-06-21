package org.dusong.edm.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String remark;
	private Set users = new HashSet(0);

	// Constructors

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", remark=" + remark
				+ ", users=" + users + "]";
	}

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String name, String remark, Set users) {
		this.name = name;
		this.remark = remark;
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

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}