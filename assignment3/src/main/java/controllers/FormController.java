package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.User;

@ManagedBean 
@ViewScoped
public class FormController {

	public String onSubmit(User user)//submit user's name using the Submit Button
	{
		System.out.println("To check: /nThe user's first name is: " + user.getFirstName() + "/nand their last name is: " + user.getLastName());
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	public String onFlash(User user)//flshg user's name using the Flash Button
	{
		FacesContext context = FacesContext.getCurrentInstance();
		user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("user", user);
		return "TestResponse2.xhtml";
	}
}
