package main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Dao;
import dao.DaoImp;
import model.Department;
import model.Employee;
import model.Meeting;

public class Main {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("hibernate.xml");

		Dao personDAO = ctx.getBean(DaoImp.class);
		
		personDAO.basla();
		Employee e1=new Employee();
		e1.setName("1");
		e1.setSurnmae("1");
		e1.setSalary(1000);
		
		Employee e2=new Employee();
		e2.setName("2");
		e2.setSurnmae("2");
		e2.setSalary(2000);
		
		Employee e3=new Employee();
		e3.setName("3");
		e3.setSurnmae("3");
		e3.setSalary(3000);
		
		Employee e4=new Employee();
		e4.setName("4");
		e4.setSurnmae("4");
		e4.setSalary(4000);
		
		personDAO.save(e1);
		personDAO.save(e2);
		personDAO.save(e3);
		personDAO.save(e4);
		
		
		Department d1=new Department();
		d1.setName("1");
		d1.setDescription("1");
		d1.getEmployee().add(e1);
		d1.getEmployee().add(e2);
		
		Department d2=new Department();
		d2.setName("2");
		d2.setDescription("2");
		d2.getEmployee().add(e3);
		d2.getEmployee().add(e4);
		
		personDAO.saveDepartment(d1);
		personDAO.saveDepartment(d2);
		
		Meeting m1=new Meeting();
		m1.setName("1");
		m1.setDescription("1");
		m1.getDepartment().add(d1);
		m1.getDepartment().add(d2);
		
		Meeting m2=new Meeting();
		m2.setName("2");
		m2.setDescription("2");
		m2.getDepartment().add(d1);
		
		personDAO.saveMeeting(m1);
		personDAO.saveMeeting(m2);
		
		personDAO.bitir();
		
	
		
		
	}

}
