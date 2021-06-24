package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.*;

@ManagedBean
@SessionScoped
public class User {
//parameters
	@NotNull() @Size(min=5, max=15)
private String firstName;
	@NotNull() @Size(min=5, max=15)
private String lastName;

public User()//Default Constructor
{
	firstName = "Nathan";
	lastName = "Meyer";
}

//Getter and Setter methods
public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

@PostConstruct
public void init() {
	//Get the logged in Principle
	Principal principle=
			FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
	if(principle == null)
	{
		setFirstName("Unknown");
		setLastName("");
	}
	else
	{
		setFirstName(principle.getName());
		setLastName("");
	}
}
}

