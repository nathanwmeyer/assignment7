package controllers;

import java.sql.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;
import data.DataAccessInterface;

@ManagedBean 
@ViewScoped
public class FormController {

	Connection conn = null;
	
	@Inject
	OrdersBusinessInterface service;
	
	@EJB
	DataAccessInterface server;
	
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
		server.create(new Order(0, "123456789", "new order", 10.00f, 10));
		server.update(new Order(0, "123456789", "new order", 10.00f, 10), new Order(0, "987654321", "editedOrder", 20.00f, 5));
		Order findThis = server.findById(11);
		System.out.println("found item, id: " + findThis.getId() + " order number: " + findThis.getOrderNumber() + " product name: " + findThis.getProductName() + " price: $" + findThis.getPrice() + " quantity: " + findThis.getQuantity());
		server.delete(new Order(0, "987654321", "editedOrder", 20.00f, 5));
		return "TestResponse.xhtml";
	}
	public String onFlash(User user)//flash user's name using the Flash Button
	{
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		service.test();
		timer.setTimer(10000);
		server.create(new Order(0, "123456789", "new order", 10.00f, 10));
		server.update(new Order(0, "123456789", "new order", 10.00f, 10), new Order(0, "987654321", "editedOrder", 20.00f, 5));
		Order findThis = server.findById(11);
		System.out.println("found item, id: " + findThis.getId() + " order number: " + findThis.getOrderNumber() + " product name: " + findThis.getProductName() + " price: $" + findThis.getPrice() + " quantity: " + findThis.getQuantity());
		server.delete(new Order(0, "987654321", "editedOrder", 20.00f, 5));
		return "TestResponse2.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return service;
	}
	
	
}
