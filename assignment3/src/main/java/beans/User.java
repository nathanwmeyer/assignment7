package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.*;

@ManagedBean
@ViewScoped
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
}

