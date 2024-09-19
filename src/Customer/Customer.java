package Customer;

import java.sql.Date;

public class Customer {
	private int id;
	private String name;
	private String email;
	private String gender;
	private String address;
	private String phno;
	private Date dob;
	
	
	public Customer() {}
	
	public Customer(String n,String e,String g,String a, String phno,Date d) {
		this.id=id;
		name=n;
		email=e;
		gender=g;
		address=a;
		this.phno=phno;
		dob=d;	
	}
	public Customer(String n) {
		
		name=n;
		
	}
	

//	 "No", "Name", "Gender", "Phone Number", "Email
	public Customer( int id,String name, String gender,String phno, String email) {
		this.id = id;
		this.name = name;
		this.gender = gender; 
		this.phno = phno;
		this.email = email;
	}

	
	public Customer(int id, String name, String email, String gender, String address,String phno,Date dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender; 
		this.address=address;
		
		this.phno = phno;
		this.dob=dob;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
