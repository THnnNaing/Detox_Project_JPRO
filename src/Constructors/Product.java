package Constructors;

import java.sql.Blob;

public class Product {
//	private int detoxID;
//	private String name;
//	private int price;
//	private String description;
//	private Blob image;
//	private String size;
//	private String ingredients;
//	private String status;
//	private int quantity;
//	
//	public Product (int i, Blob img, String desc) {
//		this.detoxID = i;
//		this.image = img;
//		this.description = desc;
//	}
//	
//	public Product (int detoxID, String name, int price, String description, Blob image, String size, String ingredients, String status, int quantity) {
//		this.detoxID = detoxID;
//		this.name = name;
//		this.price = price;
//		this.description = description;
//		this.image = image;
//		this.size = size;
//		this.ingredients = ingredients;
//		this.status = status;
//		this.quantity = quantity;
//	}
//	
//	 public Product(int detoxID, String name, String size, int price, int quantity) {
//		 	this.detoxID = detoxID;
//	        this.name = name;
//	        this.size = size;
//	        this.price = price;
//	        this.quantity = quantity;
//	    }
//
//	public Product(String name2, int price2, String desc, byte[] imageData, String size2, String ingre, int qty,
//			String status2) {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Product(String name2, int price2, String description2, byte[] imageBytes, String size2, String ingredient,
//			int quantity2) {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Product(int int1, String string, int int2, String string2) {
//		// TODO Auto-generated constructor stub
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
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Blob getImage() {
//		return image;
//	}
//
//	public void setImage(Blob image) {
//		this.image = image;
//	}
//
//	public String getSize() {
//		return size;
//	}
//
//	public void setSize(String size) {
//		this.size = size;
//	}
//
//	public String getIngredients() {
//		return ingredients;
//	}
//
//	public void setIngredients(String ingredients) {
//		this.ingredients = ingredients;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
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
private int DetoxID;
	
	private String name;
	private int price;
	private String size;
	private String ingredients;
	private byte[] image;
	private String description;
	private int quantity;
	private  String status;
	
	
	

public Product() {
	
}

public Product(int id,String n,int price,String d,String i,String s,int q) {
	this.DetoxID=id;
	name=n;
	this.price=price;
	description=d;
	size=s;
	ingredients=i;
	
	quantity=q;
	
}


public Product(int id,String n,String s,int price,int q) {
	this.DetoxID=id;
	name=n;
	
	
	size=s;
	this.price=price;
	
	quantity=q;
	
}


public Product(int price,byte[] image,String d) {
	
	
	this.price=price;
	
	this.image=image;
	description=d;
	
}




public Product(int id,String n,int price,String s) {
	DetoxID=id;
	name=n;
	this.price=price;
	
	size=s;
	
	
}
public Product(String n,int price,String s,String i,String d,int q) {
	
	name=n;
	this.price=price;
	
	size=s;
	ingredients=i;
	description=d;
	quantity=q;
	
	
}
public Product(int id,String n,int price,int q) {
	DetoxID=id;
	name=n;
	this.price=price;
	quantity=q;
	
	
}
public Product(String n,int price,String s,String i,String d,int q,String status) {
	
	name=n;
	this.price=price;
	
	size=s;
	ingredients=i;
	description=d;
	
	quantity=q;
	this.status=status;
	
}

public Product(String name, int price, String desc, byte[] imageData, String size, String ingre, int qty) {
	this.name=name;
	this.price=price;
	description=desc;
	this.image=imageData;
	this.size=size;
	ingredients=ingre;
	
	
	
	quantity=qty;
}


public Product(byte[] imageData,String name, String size, int price, String ingre) {
	this.image=imageData;
	this.name=name;
	this.size=size;
	this.price=price;
	
	
	
	ingredients=ingre;
	
	
	
	
}




public Product(String name, int price, String desc, byte[] imageData, String size, String ingre,int qty,String s) {
	this.name=name;
	this.price=price;
	description=desc;
	this.image=imageData;
	this.size=size;
	ingredients=ingre;
	quantity=qty;
	status=s;
	
	
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getIngredients() {
	return ingredients;
}
public void setIngredients(String ingredients) {
	this.ingredients = ingredients;
}

public String getImagePath() {
	// TODO Auto-generated method stub
	return null;
}
public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}




public int getDetoxID() {
	return DetoxID;
}

public void setDetoxID(int detoxID) {
	DetoxID = detoxID;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}




}
