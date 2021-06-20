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
    	        new Order(6, "0006", "Product F", 
    	                5.00f, 5),
    	        new Order(7, "0007", "Product G", 
    	                10.00f, 4),
    	        new Order(8, "0008", "Product H", 
    	                15.00f, 3),
    	        new Order(9, "0009", "Product I", 
    	                20.00f, 2),
    	        new Order(10, "0010", "Product J", 
    	                25.00f, 1)
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

	@Override
	public void sendOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
