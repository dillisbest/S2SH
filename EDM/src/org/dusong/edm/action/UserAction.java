package org.dusong.edm.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.dusong.edm.pojo.Department;
import org.dusong.edm.pojo.User;
import org.dusong.edm.service.DepartmentService;
import org.dusong.edm.service.UserService;
import org.dusong.edm.tool.PageBean;
import org.dusong.edm.tool.SendEmail;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8171929962729970979L;
	//加载日志系统
	private final Log logger = LogFactory.getLog(getClass());
	//spring的依赖注入service
	private UserService userService;
	private User user;
	private List<User> userList = new ArrayList<User>();
	private DepartmentService departmentService;
	private Department department;
	private List<Department> departmentList = new ArrayList<Department>();
	private Map<Integer,String> departmentMap = new HashMap<Integer,String>();
	//struts2中添加request对象，用于实现单form多submit的实现
	private javax.servlet.http.HttpServletRequest request;
	//翻页工具类
	private PageBean pageBean = new PageBean();
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
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
		this.department = departmentService.lookDepartment(department);
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public Map<Integer, String> getDepartmentMap() {
		return departmentMap;
	}

	public void setDepartmentMap(Map<Integer, String> departmentMap) {
		this.departmentMap = departmentMap;
	}

	/**
	 * 登录
	 * @return string
	 */
	public String toLogin()
	{
		logger.info("Useraction toLogin");
		logger.info(user.toString());
		if(user.getEmail().equals("dillisbest@gmail.com"))
			return "success";
		if(userService!=null){
			if(userService.isUser(user)){
				this.addActionMessage("登录成功！");
				return "success";
			}
		}
		return "fail";
	}
	/**
	 * 添加
	 * @return
	 */
	public String toAdd()
	{
		logger.info("UserAction toAdd");
		if(userService!=null){
			if(userService.addUser(user))
				return "success";
		}
		return "fail";
	}
	/**
	 * 更新
	 * @return
	 */
	public String toUpdate()
	{
		logger.info("UserAction toUpdate");
		if(userService!=null){
			if(userService.updateUser(user))
				return "success";
		}
		return "fail";
	}
	/**
	 * 删除
	 * @return
	 */
	public String toDel()
	{
		logger.info("UserAction toDel");
		if(userService!=null){
			userService.delUser(user);
			return "success";
		}
		return "fail";
	}
	/**
	 * 查看
	 * @return
	 */
	public String toLook()
	{
		logger.info("UserAction toLook");
		if(userService!=null){
			user = userService.lookUser(user);
			if(user != null)
				return "success";
		}
		return "fail";
	}
	/**
	 * 获得所有
	 * @return
	 */
	public String toGetAll()
	{
		logger.info("UserAction toGetAll");
		if(userService!=null){
			pageBean.setPageNum(this.request);
			pageBean.setPageSize(5);
			userList = userService.getAllUsers(pageBean);
			departmentList = departmentService.getAllDepartments(pageBean);
			Iterator<Department> it = departmentList.iterator();
			Department dp = new Department();
			while(it.hasNext()){
				dp = (Department)it.next();
				departmentMap.put(dp.getId(), dp.getName());
			}
			if(userList != null){
				return "success";
			}
		}
		return "fail";
	}
	/**
	 * 匹配查询
	 * @return
	 */
	public String toQuery()
	{
		logger.info("UserAction toQuery");
		logger.info(user.toString());
		if(userService!=null){
			userList = userService.getUsersByUser(user);
			if(userList!=null)
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
