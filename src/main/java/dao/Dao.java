package dao;

import model.Department;
import model.Employee;
import model.Meeting;

public interface Dao {
	void basla();
	void bitir();
	void save(Employee employee);
	void saveDepartment(Department department);
	void saveMeeting(Meeting meeting);



}
