package org.mishra.aop.main;

import org.mishra.aop.dao.DAOImpl;
import org.mishra.aop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		//ShapeService shapeService=context.getBean("shapeService", ShapeService.class);
		DAOImpl dao=context.getBean("dao",DAOImpl.class);
		//shapeService.getCircle();
		dao.getAllUsersName();
	}
}
