package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import data.OrdersDataService;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {

    @EJB
    OrdersDataService service;
	/**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
    	
		
    	if (message instanceof Message)
         {
             try {
            	 ObjectMessage objectMessage = (ObjectMessage) message;
                 Order order = new Order();
                 order = (Order)objectMessage.getObject();
                 send(order);
                 System.out.println("ON Message method:  "+ order.getOrderNumber());

             }
             catch (JMSException e) {
                 e.printStackTrace();
             }
         };
    }

    public void send(Order order) {
    	Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			Statement statement = conn.createStatement();
			String sql = String.format("INSERT INTO  testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('%s', '%s', %f, %d)", order.getOrderNumber(), order.getProductName(), order.getPrice(), order.getQuantity());
			statement.executeUpdate(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}
