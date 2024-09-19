package Order;

public class DetailOrder {
	private int orderid;
	private int detoxid;
	private int orderdetailid;
	private int quantity;
	
	
	public DetailOrder() {
		
	}
	
	public DetailOrder(int oid,int did,int q) {
		orderid=oid;
		detoxid=did;
		quantity=q;
		
	}
	
	public DetailOrder(int odetailid,int oid,int did,int q) {
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
