package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Department;
import model.Employee;
import model.Meeting;

@Repository
public class DaoImp implements Dao {
	private SessionFactory sessionFactory;
	Session session;
	Transaction transacion;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.openSession();
	}

	public void basla() {
		session = getSession();
		transacion = session.beginTransaction();
	}

	public void bitir() {
		transacion.commit();
		session.close();
	}

	public void save(Employee employee) {
		// TODO Auto-generated method stub

		session.persist(employee);

	}

	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		session.persist(department);

	}

	public void saveMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		session.persist(meeting);

	}

}
