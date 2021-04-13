package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Scripture 
{

	String scripture;
	
	public Scripture() 
	{
		this.scripture = this.getScripture();
	}
	
	public Scripture(String scripture) 
	{
		this.scripture = scripture;
	}
	
	public String getScripture() 
	{
		return scripture;
	}

	public void setScripture(String scripture) 
	{
		this.scripture = scripture;
	}
}
