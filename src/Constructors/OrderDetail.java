package Constructors;

public class OrderDetail {

//	private int orderDetailID;
//	private int orderID;
//	private int detoxID;
//	private int quantity;
//	
//	public OrderDetail () {}
//	
//	public OrderDetail (int orderDetailID, int orderID, int detoxID, int quantity) {
//		this.orderDetailID = orderDetailID;
//		this.orderID = orderID;
//		this.detoxID = detoxID;
//		this.quantity = quantity;
//	}
//
//	public int getOrderDetailID() {
//		return orderDetailID;
//	}
//
//	public void setOrderDetailID(int orderDetailID) {
//		this.orderDetailID = orderDetailID;
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
//	public int getDetoxID() {
//		return detoxID;
//	}
//
//	public void setDetoxID(int detoxID) {
//		this.detoxID = detoxID;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	
//	
	private int orderid;
	private int detoxid;
	private int orderdetailid;
	private int quantity;
	
	
	public OrderDetail() {
		
	}
	
	public OrderDetail(int oid,int did,int q) {
		orderid=oid;
		detoxid=did;
		quantity=q;
		
	}
	
	public OrderDetail(int odetailid,int oid,int did,int q) {
		orderdetailid=odetailid;
		orderid=oid;
		detoxid=did;
		quantity=q;
		
	}
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getDetoxid() {
		return detoxid;
	}
	public void setDetoxid(int detoxid) {
		this.detoxid = detoxid;
	}
	public int getOrderdetailid() {
		return orderdetailid;
	}
	public void setOrderdetailid(int orderdetailid) {
		this.orderdetailid = orderdetailid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
