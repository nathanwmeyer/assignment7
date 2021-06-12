package controllers;

import java.sql.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean 
@ViewScoped
public class FormController {

	Connection conn = null;
	
	@Inject
	OrdersBusinessInterface service;
	
	@EJB
	MyTimerService timer;

	public String onSubmit(User user)//submit user's name using the Submit Button
	{
		System.out.println("To check: The user's first name is: " + user.getFirstName() + " and their last name is: " + user.getLastName());
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		service.test();
		timer.setTimer(10000);
		try {
			getAllOrders();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "TestResponse.xhtml";
	}
	public String onFlash(User user)//flash user's name using the Flash Button
	{
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		service.test();
		timer.setTimer(10000);
		try {
			getAllOrders();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "TestResponse2.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return service;
	}
	
	private void getAllOrders() throws SQLException
	{
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
			if (conn != null) System.out.println("Success");
			
			Statement statement = conn.createStatement();
			String sqlCommand = "SELECT * FROM testapp.ORDERS";
			ResultSet result = statement.executeQuery(sqlCommand);
			
			while (result.next()) {
				int id = result.getInt("ID");
				String productName = result.getString("PRODUCT_NAME");
				Float price = result.getFloat("PRICE");
				System.out.println("ID: " + id);
				System.out.println("Product Name: " + productName);
				System.out.println("Price: " + price);
			}
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failiure");
		} finally {
			conn.close();
		}
	}
}
