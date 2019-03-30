package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	@OneToMany
	private List<Employee> employees = new ArrayList<Employee>();
	@ManyToMany(mappedBy="departments")
	private Set<Meeting> meeting = new HashSet<Meeting>(0);

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name, String description, List<Employee> employees, Set<Meeting> meeting) {
		super();
		this.name = name;
		this.description = description;
		this.meeting = meeting;
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employees) {
		this.employees = employees;
	}

	public Set<Meeting> getMeeting() {
		return meeting;
	}

	public void setMeeting(Set<Meeting> meeting) {
		this.meeting = meeting;
	}

}
