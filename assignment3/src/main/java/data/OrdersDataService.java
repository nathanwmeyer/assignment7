package data;

import beans.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrdersDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class OrdersDataService implements DataAccessInterface {

	Connection conn = null;
    /**
     * Default constructor. 
     */
    public OrdersDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @throws SQLException 
	 * @see DataAccessInterface#findAll()
     */
    public List<Order> findAll() {
    	try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			if (conn != null) System.out.println("Success");
			
			Statement statement = conn.createStatement();
			String sqlCommand = "SELECT * FROM testapp.ORDERS";
			ResultSet result = statement.executeQuery(sqlCommand);
			List<Order> orders = new ArrayList<Order>();
			while (result.next()) {
				int id = result.getInt("ID");
				String orderNumber = result.getString("ORDER_NO");
				String productName = result.getString("PRODUCT_NAME");
				Float price = result.getFloat("PRICE");
				int quantity = result.getInt("QUANTITY");
				orders.add(new Order(id, orderNumber, productName, price, quantity));
			}
			result.close();
			return orders;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failiure");
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    }

}
