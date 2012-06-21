package org.dusong.edm.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dusong.edm.dao.DepartmentDAO;
import org.dusong.edm.pojo.Department;
import org.dusong.edm.tool.Md5Utils;
import org.dusong.edm.tool.PageBean;

public class DepartmentService {
	private final Log logger = LogFactory.getLog(getClass());
	private DepartmentDAO departmentDao;
	List<Department> departmentList = new ArrayList<Department>();
	Md5Utils md5 = new Md5Utils();
	public DepartmentDAO getDepartmentDao() {
		return departmentDao;
	}
	public void setDepartmentDao(DepartmentDAO departmentDao) {
		this.departmentDao = departmentDao;
	}

	public boolean addDepartment(Department department){
		logger.info("DepartmentService addDepartment");
		List queryList = null;
		queryList = departmentDao.findByName(department.getName());
		if(queryList.size()==0){
			logger.info(department.toString());
			departmentDao.save(department);
			return true;
		}
		return false;
	}
	public boolean delDepartment(Department department){
		logger.info("DepartmentService delDepartment");
		Department u = departmentDao.findById(department.getId());
		if(u!=null){
			logger.info(u.toString());
			departmentDao.delete(u);
			return true;
		}
		return false;
	}
	
	public Department lookDepartment(Department department){
		logger.info("DepartmentService lookDepartment");
		Department u = departmentDao.findById(department.getId());
		if(u!=null){
			logger.info(u.toString());
			return u;
		}
		return null;
	}
	
	public boolean updateDepartment(Department department){
		logger.info("DepartmentService updateDepartment");
		logger.info(department.toString());
		departmentDao.merge(department);
		return true;
	}
	
	public List<Department> getAllDepartments(PageBean pageBean){
		departmentList.clear();
		Department u = new Department();
		logger.info("DepartmentService getAllDepartments");
		List<Object> queryList = null;
		queryList = departmentDao.findAll();
		if(queryList.size()>0){
			Iterator it = queryList.iterator();
			while(it.hasNext()){
				u = (Department)it.next();
				System.out.println(u.toString());
				departmentList.add(u);
			}
			return departmentList;
		}
		return null;
	}
	public List<Department> getDepartmentsByDepartment(Department department){
		departmentList.clear();
		Department u = new Department();
		logger.info("DepartmentService getDepartmentsByDepartment");
		List<Object> queryList = departmentDao.findByExample(department);
		if(queryList.size()>0){
			Iterator it = queryList.iterator();
			while(it.hasNext()){
				u = (Department)it.next();
				System.out.println(u.toString());
				departmentList.add(u);
			}
			return departmentList;
		}
		return null;
	}
}
