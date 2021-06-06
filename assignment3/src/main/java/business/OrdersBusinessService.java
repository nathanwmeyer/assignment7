package business;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.*;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Alternative
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
public class OrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders;
	
    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	orders = Arrays.asList(
    	        new Order("0011", "Product K", 
    	                35.00f, 10),
    	        new Order("0012", "Product L", 
    	                28.00f, 8),
    	        new Order("0013", "Product M", 
    	                21.00f, 6),
    	        new Order("0014", "Product N", 
    	                14.00f, 4),
    	        new Order("0015", "Product O", 
    	                7.00f, 2)
    	        );
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("Hello from the OrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		this.orders = orders;
	}

}
