package org.dusong.edm.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dusong.edm.pojo.Department;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * Department entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.dusong.edm.pojo.Department
 * @author MyEclipse Persistence Tools
 */

public class DepartmentDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(DepartmentDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String REMARK = "remark";
	public static final String CONN_NAME = "connName";
	public static final String CONN_PHONE = "connPhone";
	public static final String ADDRESS = "address";

	protected void initDao() {
		// do nothing
	}

	public void save(Department transientInstance) {
		log.debug("saving Department instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Department persistentInstance) {
		log.debug("deleting Department instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Department findById(java.lang.Integer id) {
		log.debug("getting Department instance with id: " + id);
		try {
			Department instance = (Department) getHibernateTemplate().get(
					"org.dusong.edm.pojo.Department", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Department instance) {
		log.debug("finding Department instance by example");
		try {
			String queryString = "from Department as d where d.name like '%"+
			instance.getName()+"%' and d.address like '%"+ 
			instance.getAddress() +"%' and d.connName like '%"+
			instance.getConnName()+"%' and d.connPhone like '%"+
			instance.getConnPhone()+"%' and d.remark like '%"+
			instance.getRemark()+"%'";
			System.out.println("HQL:"+queryString);
			//List results = getHibernateTemplate().findByExample(instance);
			List results = getHibernateTemplate().find(queryString);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Department instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Department as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByConnName(Object connName) {
		return findByProperty(CONN_NAME, connName);
	}

	public List findByConnPhone(Object connPhone) {
		return findByProperty(CONN_PHONE, connPhone);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findAll() {
		log.debug("finding all Department instances");
		try {
			String queryString = "from Department";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Department merge(Department detachedInstance) {
		log.debug("merging Department instance");
		try {
			Department result = (Department) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Department instance) {
		log.debug("attaching dirty Department instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Department instance) {
		log.debug("attaching clean Department instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DepartmentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DepartmentDAO) ctx.getBean("DepartmentDAO");
	}
}