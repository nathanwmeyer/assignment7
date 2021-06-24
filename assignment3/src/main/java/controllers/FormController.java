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
	
	public String onLogoff() {
		//Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		//Redirect to a protected page (so we get a full HTTP Request) to get to Login Page
		return "TestResponse.xhtml?faces-redirect=true";
	}
	
	public OrdersBusinessInterface getService() {
		return service;
	}
	
	public String onSendOrder() {//send an order and insert it into the database
		
		Order order = new Order(1, "12345677890", "Test Order", 10.00f, 5);
		service.sendOrder(order);
		return "OrderResponse.xhtml";
	}
}
