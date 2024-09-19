package Constructors;

import java.sql.Date;

public class Staff {
	private int id;
	private String name;
	private String email;
	private String gender;
	private String phno;
	private String NRC;
	private String position;
	private String address;
	private Date dob;
	
	//no argument constructor 
	public Staff() {	}
	
	public Staff (int id, String name, String gender, String phno, String position) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phno = phno;
		this.position = position;
	}
	
	//argument constructor
	public Staff (int id, String name, String email, String gender, String phno, String NRC, String position, String address, Date dob) {
		this.id = id; 
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.phno = phno;
		this.NRC = NRC; 
		this.position = position;
		this.address = address;
		this.dob = dob;
	}
	

	
	public Staff(String name, String email, String gender, String nrc, String position, String address, Date dob) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.phno = phno;
		this.NRC = NRC; 
		this.position = position;
		this.address = address;
		this.dob = dob;
	}

	

	//getter setter 
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

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getNRC() {
		return NRC;
	}

	public void setNRC(String nRC) {
		NRC = nRC;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}


	
	
	
}
