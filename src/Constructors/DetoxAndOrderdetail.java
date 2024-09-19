package Constructors;

public class DetoxAndOrderdetail {
	private int id;
	private String name;
	private String size;
	private int price;
	
	private int quantity;

	
	
	public DetoxAndOrderdetail(){
		
	}
	
public DetoxAndOrderdetail(int id,String n,String s,int q,int p){
	this.id=id;
	name=n;
	size=s;
	quantity=q;
	
	price=p;
		
	}

public DetoxAndOrderdetail(String n,String s,int q,int p){
	
	name=n;
	size=s;
	quantity=q;
	
	price=p;
		
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
