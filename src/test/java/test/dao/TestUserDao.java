package test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;

public class TestUserDao {
	private UserDao dao;
	
	@Before
	public void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		dao = ac.getBean("userDao",UserDao.class);
	}
	
	@Test
	public void test1(){
		User user = dao.findByName("demo");
		System.out.println(user);
	}
}
