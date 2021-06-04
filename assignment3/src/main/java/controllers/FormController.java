package controllers;

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
	
	@Inject
	OrdersBusinessInterface service;
	
	//@EJB
	//MyTimerService timer;

	public String onSubmit(User user)//submit user's name using the Submit Button
	{
		System.out.println("To check: The user's first name is: " + user.getFirstName() + " and their last name is: " + user.getLastName());
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		service.test();
		//timer.setTimer(10000);
		return "TestResponse.xhtml";
	}
	public String onFlash(User user)//flash user's name using the Flash Button
	{
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		service.test();
		//timer.setTimer(10000);
		return "TestResponse2.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		return service;
	}
}
