package Order;

import java.sql.Date;

public class Invoice {
		private int sId;
		
		
	
	
	 private int detoxID;
	    private int orderid;
	    private String detoxName;
	    private String size;
	    private int price;
	    private int quantity;
	    private double amount;

	    public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		public Invoice() {
			
		}

		public Invoice(int detoxID, int orderid, String detoxName, String size, int price, int quantity) {
	        this.detoxID = detoxID;
	        this.orderid = orderid;
	        this.detoxName = detoxName;
	        this.size = size;
	        this.price = price;
	        this.quantity = quantity;
	    }
		
		public Invoice( int id,String detoxName, String size, int price, int quantity,double amount) {
			 this.detoxID = id;
			 
	        this.detoxName = detoxName;
	        this.size = size;
	        this.price = price;
	        this.quantity = quantity;
	        this.amount=amount;
	    }
		public Invoice( String detoxName,  int price,String size, int quantity,double amount) {
			
			 
	        this.detoxName = detoxName;
	      
	        this.price = price;
	        this.size = size;
	        this.quantity = quantity;
	        this.amount=amount;
	    }
	    public Invoice(int detoxID, String detoxName, String size, int price, int quantity) {
	        this.detoxID = detoxID;
	       
	        this.detoxName = detoxName;
	        this.size = size;
	        this.price = price;
	        this.quantity = quantity;
	    }

	    public Invoice( String detoxName, String size, int price, int quantity) {
	       
	       
	        this.detoxName = detoxName;
	        this.size = size;
	        this.price = price;
	        this.quantity = quantity;
	    }
	    public Invoice(int detoxID, int quantity) {
		       
	    	 this.detoxID = detoxID;
	       
	        this.quantity = quantity;
	    }
	public void setSize(String size) {
		this.size = size;
	}


	public void setPrice(int price) {
		this.price = price;
	}





	public int getDetoxID() {
		return detoxID;
	}





	public void setDetoxID(int detoxID) {
		this.detoxID = detoxID;
	}





	public int getOrderID() {
		return orderid;
	}





	public void setOrderID(int orderid) {
		this.orderid = orderid;
	}





	public String getDetoxName() {
		return detoxName;
	}





	public void setDetoxName(String detoxName) {
		this.detoxName = detoxName;
	}





	public int getQuantity() {
		return quantity;
	}





	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}





	public String getSize() {
		return size;
	}





	public int getPrice() {
		return price;
	}
	
	
}
