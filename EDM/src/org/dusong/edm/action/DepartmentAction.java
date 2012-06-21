package org.dusong.edm.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.dusong.edm.pojo.Department;
import org.dusong.edm.service.DepartmentService;
import org.dusong.edm.tool.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5838067199279932840L;
	/**
	 * 
	 */
	private final Log logger = LogFactory.getLog(getClass());
	private DepartmentService departmentService;
	private Department department;
	private List<Department> departmentList = new ArrayList<Department>();
	private javax.servlet.http.HttpServletRequest request;
	private PageBean pageBean = new PageBean();
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	
	public String toAdd()
	{
		logger.info("DepartmentAction toAdd");
		if(departmentService!=null){
			if(departmentService.addDepartment(department))
				return "success";
		}
		return "fail";
	}
	public String toUpdate()
	{
		logger.info("DepartmentAction toUpdate");
		if(departmentService!=null){
			if(departmentService.updateDepartment(department))
				return "success";
		}
		return "fail";
	}
	public String toDel()
	{
		logger.info("DepartmentAction toDel");
		if(departmentService!=null){
			departmentService.delDepartment(department);
			return "success";
		}
		return "fail";
	}
	public String toLook()
	{
		logger.info("DepartmentAction toLook");
		if(departmentService!=null){
			department = departmentService.lookDepartment(department);
			if(department != null)
				return "success";
		}
		return "fail";
	}
	public String toGetAll()
	{
		logger.info("DepartmentAction toGetAll");
		if(departmentService!=null){
			pageBean.setPageNum(this.request);
			pageBean.setPageSize(5);
			departmentList = departmentService.getAllDepartments(pageBean);
			if(departmentList != null){
				return "success";
			}
		}
		return "fail";
	}

	public String toQuery()
	{
		logger.info("DepartmentAction toQuery");
		logger.info(department.toString());
		if(departmentService!=null){
			departmentList = departmentService.getDepartmentsByDepartment(department);
			if(departmentList!=null)
				return "success";
		}
		return "fail";
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
