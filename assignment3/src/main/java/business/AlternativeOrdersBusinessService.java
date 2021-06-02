package business;

import javax.ejb.Local;
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
public class AlternativeOrdersBusinessService implements OrdersBusinessInterface {

    /**
     * Default constructor. 
     */
    public AlternativeOrdersBusinessService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
    	System.out.println("Hello from the AlternativeOrdersBusinessService");
    }

}
