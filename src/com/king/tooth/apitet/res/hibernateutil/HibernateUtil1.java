package com.king.tooth.apitet.res.hibernateutil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateUtil1 {
	
	
	/**
	 * hiberante的sessionFactory
	 */
	private static final SessionFactory sessionFactory;
	static{
		sessionFactory = SpringContextHelper.getBean(SessionFactory.class);
	}
	
	/**
	 * 【推荐使用】获得当前session，如果有则获取，否则创建一个新的
	 * <p>这样创建出来的session不需要手动关闭，但是它需要在一个事务中</p>
	 * <p>TODO 内部实现暂时改为openSession()，以后加入声明式事务，再改回来</p>
	 * @return
	 */
	public static Session getCurrentSession() {
//		Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		return session;
	}
	
	/**
	 * 获得session对象，不论是否有，都创建一个新的
	 * <p>这样创建出来的session需要手动关闭</p>
	 * @return
	 */
	public static Session openSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

	/**
	 * 获取sessionFactory对象
	 * @return
	 */
	static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	

}
