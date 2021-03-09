package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@ManagedBean
@ViewScoped
public class User
{
	@NotNull(message = "Please enter a First name")
	@Size (min = 2, max = 15, message = "You must enter a name 5 to 15 characters")
	String firstName;
	
	@NotNull(message = "Please enter a Last name")
	@Size (min = 2, max = 15, message = "You must enter a name 5 to 15 characters")
	String lastName;
	
	public User() 
	{
		this.firstName = "";
		this.lastName = "";
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
}
