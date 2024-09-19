package Order;

public class OrderDetail {
	
	 private int orderDetail_ID;
	    private int orderID;
	    private int detoxID;
	    private int quantity;

	    // No-argument constructor
	    public OrderDetail() {}

	    // Argument constructor
	    public OrderDetail(int orderDetail_ID, int orderID, int detoxID, int quantity) {
	        this.orderDetail_ID = orderDetail_ID;
	        this.orderID = orderID;
	        this.detoxID = detoxID;
	        this.quantity = quantity;
	    }

	    public int getOrderDetail_ID() {
	        return orderDetail_ID;
	    }

	    public void setOrderDetail_ID(int orderDetail_ID) {
	        this.orderDetail_ID = orderDetail_ID;
	    }

	    public int getOrderID() {
	        return orderID;
	    }

	    public void setOrderID(int orderID) {
	        this.orderID = orderID;
	    }

	    public int getDetoxID() {
	        return detoxID;
	    }

	    public void setDetoxID(int detoxID) {
	        this.detoxID = detoxID;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }
	    
	    // Method to save detoxID
	    public void saveDetoxID(int detoxID) {
	        this.detoxID = detoxID;
	    }
	    
	    public static int calculateTotalQuantityByDetoxID(OrderDetail[] orderDetails, int detoxID) {
	        int totalQuantity = 0;
	        for (OrderDetail orderDetail : orderDetails) {
	            if (orderDetail.getDetoxID() == detoxID) {
	                totalQuantity += orderDetail.getQuantity();
	            }
	        }
	        return totalQuantity;
	    }

}
