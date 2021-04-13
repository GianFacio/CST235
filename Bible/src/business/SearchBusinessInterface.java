package business;

import javax.ejb.Local;

@Local
public interface SearchBusinessInterface 
{
	public String findVerse(String link);
}