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
    public List<Order> findAll() {//return all orders
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

	@Override
	public Order findById(int id) {//find an order by its id
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			if (conn != null) System.out.println("Success");
			
			Statement statement = conn.createStatement();
			String sqlCommand = "SELECT * FROM testapp.ORDERS WHERE ID = " + id + ";";
			ResultSet result = statement.executeQuery(sqlCommand);
			Order order = null;
			while(result.next()) {
				int ID = result.getInt("ID");
				String orderNumber = result.getString("ORDER_NO");
				String productName = result.getString("PRODUCT_NAME");
				Float price = result.getFloat("PRICE");
				int quantity = result.getInt("QUANTITY");
				order = new Order(ID, orderNumber, productName, price, quantity);
			}
			result.close();
			return order;
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

	@Override
	public void create(Order order) {//create and insert a new order
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			Statement statement = conn.createStatement();
			String sqlCommand = "INSERT INTO testapp.ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES('" + order.getOrderNumber() + "','" + order.getProductName() + "', " + order.getPrice() + ", " + order.getQuantity() + ");";
			statement.executeUpdate(sqlCommand);
			System.out.println("Order Created");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failiure during Insertion");
		}
	}

	@Override
	public void update(Order order, Order update) {//update an existing order
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			Statement statement = conn.createStatement();
			String sqlCommand = "UPDATE testapp.ORDERS "
					+ "SET ORDER_NO = '"  + update.getOrderNumber() + "', PRODUCT_NAME = '" + update.getProductName() + "', PRICE = " + update.getPrice() + ", QUANTITY = " + update.getQuantity()
					+ " WHERE ORDER_NO = '" + order.getOrderNumber() + "' AND PRODUCT_NAME = '" + order.getProductName() + "' AND PRICE = " + order.getPrice() + "::float8::numeric::money AND QUANTITY = " + order.getQuantity() + ";";
			statement.executeUpdate(sqlCommand);
			System.out.println("Order Updated");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failiure during deletion");
		}
	}

	@Override
	public void delete(Order order) {//remove an existing order
		// TODO Auto-generated method stub
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			Statement statement = conn.createStatement();
			String sqlCommand = "DELETE FROM testapp.ORDERS WHERE ORDER_NO = '" + order.getOrderNumber() + "' AND PRODUCT_NAME = '" + order.getProductName() + "' AND PRICE = " + order.getPrice() + "::float8::numeric::money AND QUANTITY = " + order.getQuantity() + ";";
			statement.executeUpdate(sqlCommand);
			System.out.println("Order Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failiure during deletion");
		}
	}

}
