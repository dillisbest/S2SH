package org.dusong.edm.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dusong.edm.dao.UserDAO;
import org.dusong.edm.pojo.User;
import org.dusong.edm.tool.Md5Utils;
import org.dusong.edm.tool.PageBean;

public class UserService {
	//加载日志系统
	private final Log logger = LogFactory.getLog(getClass());
	//spring的依赖注入dao层
	private UserDAO userDao;
	
	List<User> userList = new ArrayList<User>();
	//md5加密工具类
	Md5Utils md5 = new Md5Utils();
	
	public UserDAO getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	/**
	 * 判断是否为特定对象
	 * @param user
	 * @return
	 */
	public boolean isUser(User user){
		logger.info("UserService isUser");
		List findList = null;
		findList = userDao.findByEmail(user.getEmail());
		if(findList.size()!=1){
			return false;
		}
		User queryUser = (User)findList.get(0);
		if(!queryUser.getUsername().equals(user.getUsername()) || !queryUser.getPassword().equals(md5.getMd5(user.getPassword()))){
			return false;
		}
		return true;
	}
	/**
	 * 增加
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		logger.info("UserService addUser");
		List queryList = null;
		queryList = userDao.findByEmail(user.getEmail());
		if(queryList.size()==0){
			logger.info(user.toString());
			user.setPassword(md5.getMd5(user.getPassword()));
			logger.info(user.toString());
			userDao.save(user);
			return true;
		}
		return false;
	}
	/**
	 * 删除
	 * @param user
	 * @return
	 */
	public boolean delUser(User user){
		logger.info("UserService delUser");
		User u = userDao.findById(user.getId());
		if(u!=null){
			logger.info(u.toString());
			userDao.delete(u);
			return true;
		}
		return false;
	}
	/**
	 * 查看
	 * @param user
	 * @return
	 */
	public User lookUser(User user){
		logger.info("UserService lookUser");
		User u = userDao.findById(user.getId());
		if(u!=null){
			logger.info(u.toString());
			return u;
		}
		return null;
	}
	/**
	 * 更新
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user){
		logger.info("UserService updateUser");
		logger.info(user.toString());
		user.setPassword(md5.getMd5(user.getPassword()));
		logger.info(user.toString());
		userDao.merge(user);
		return true;
	}
	/**
	 * 获取所有
	 * @param pageBean
	 * @return
	 */
	public List<User> getAllUsers(PageBean pageBean){
		userList.clear();
		User u = new User();
		logger.info("UserService getAllUsers");
		List<Object> queryList = null;
		queryList = userDao.findAll();
		if(queryList.size()>0){
			Iterator it = queryList.iterator();
			while(it.hasNext()){
				u = (User)it.next();
				System.out.println(u.toString());
				userList.add(u);
			}
			return userList;
		}
		return null;
	}
	/**
	 * 匹配查询
	 * @param user
	 * @return
	 */
	public List<User> getUsersByUser(User user){
		userList.clear();
		User u = new User();
		logger.info("UserService getUsersByUser");
		List<Object> queryList = userDao.findByExample(user);
		if(queryList.size()>0){
			Iterator it = queryList.iterator();
			while(it.hasNext()){
				u = (User)it.next();
				System.out.println(u.toString());
				userList.add(u);
			}
			return userList;
		}
		return null;
	}
}
