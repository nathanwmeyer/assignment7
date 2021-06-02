package business;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Local;
import beans.*;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * Session Bean implementation class AlternativeOrdersBusinessService
 */
@Alternative
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders;
	
    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	orders = Arrays.asList(
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

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("Hello from the AnotherOrdersBusinessService");
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
