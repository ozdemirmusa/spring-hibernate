package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Meeting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Meeting_Department",joinColumns = { @JoinColumn(name = "m_id") }, inverseJoinColumns = {
			@JoinColumn(name = "d_id") })
	private Set<Department> departments = new HashSet<Department>(0);

	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meeting(String name, String description, Set<Department> departments) {
		super();
		this.name = name;
		this.description = description;
		this.departments = departments;
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

	public Set<Department> getDepartment() {
		return departments;
	}

	public void setDepartment(Set<Department> departments) {
		this.departments = departments;
	}

}
