package Constructors;

import java.sql.Date;

public class Order {
//	private int orderID;
//	private Date orderDate;
//	private String order_note;
//	private int customerID;
//	private int staffID;
//	
//	public Order () {}
//	
//	public Order (int orderID, Date orderDate, String order_note, int customerID, int staffID) {
//		this.orderID = orderID;
//		this.orderDate = orderDate;
//		this.order_note = order_note;
//		this.customerID = customerID;
//		this.staffID = staffID;
//	}
//
//	public int getOrderID() {
//		return orderID;
//	}
//
//	public void setOrderID(int orderID) {
//		this.orderID = orderID;
//	}
//
//	public Date getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}
//
//	public String getOrder_note() {
//		return order_note;
//	}
//
//	public void setOrder_note(String order_note) {
//		this.order_note = order_note;
//	}
//
//	public int getCustomerID() {
//		return customerID;
//	}
//
//	public void setCustomerID(int customerID) {
//		this.customerID = customerID;
//	}
//
//	public int getStaffID() {
//		return staffID;
//	}
//
//	public void setStaffID(int staffID) {
//		this.staffID = staffID;
//	}
//	
	private int orderID;
	private Date orderDate;
	private String order_note;
	private int customerID;
	private int staffID;
	private String Sname;
	private String Cname;
	private String note;
	
	public Order () {}
	
	public Order(int oid,String cn,String sn,Date d) {
		orderID=oid;
		Cname=cn;
		Sname=sn;
		orderDate=d;
		
	}
	
	
	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Order (int orderID, Date orderDate, String order_note, int customerID, int staffID) {
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.order_note = order_note;
		this.customerID = customerID;
		this.staffID = staffID;
	}
	public Order ( Date orderDate,  int customerID, int staffID) {
		
		this.orderDate = orderDate;
		
		this.customerID = customerID;
		this.staffID = staffID;
	}
	public Order (  String customer, String staff,Date orderDate) {
		
		
		
			Cname= customer;
		Sname = staff;
		this.orderDate = orderDate;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrder_note() {
		return order_note;
	}

	public void setOrder_note(String order_note) {
		this.order_note = order_note;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	
	

	
}
