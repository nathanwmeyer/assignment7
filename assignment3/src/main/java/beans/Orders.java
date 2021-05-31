package beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.*;

@ManagedBean(name="orders") 
@ViewScoped

public class Orders implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private static List<Order> orderList;
    
    public Orders() {//default constructor with dummy data
    	orderList = Arrays.asList(
        new Order("0001", "Product A", 
                20.00f, 1),
        new Order("0002", "Product B", 
                10.00f, 2),
        new Order("0003", "Product C", 
                5.00f, 4),
        new Order("0004", "Product D", 
                4.00f, 5),
        new Order("0005", "Product E", 
                2.00f, 10)
        );
    }
    
    
    //getter and setter methods
    public List<Order> getOrderList() {
    	 
        return orderList;
 
    }
    
    public void setOrderList(List<Order> orderList) {
    	this.orderList = orderList;
    }
}
