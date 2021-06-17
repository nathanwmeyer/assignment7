package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Order")
public class Order {

	//list of variables
	private String orderNumber;
	private String productName;
	
	private float price;
	private int quantity;
	private int id;
	
	public Order()//default constructor
	{
		this.id = 0;
		this.orderNumber = "";
		this.productName = "";
		this.price = 0;
		this.quantity = 0;
	}
	
	public Order(int id, String orderNumber, String productName, float price, int quantity) {//parameterized constructor
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	//Getter and Setter methods
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
