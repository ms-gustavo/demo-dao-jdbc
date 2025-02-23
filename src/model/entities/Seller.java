package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Seller implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String email;
	private Date birthdate;
	private Double baseSalary;
	
	private Department department;

	public Seller() {
	}
	
	public Seller(Integer id, String name, String email, Date birthdate, Double baseSalary, Department department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	
}
