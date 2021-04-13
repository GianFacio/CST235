package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class Search {

	String Name = "";
	String Chapter = "";
	String Verse = "";
	
	public Search(){
		this.Name = this.getName();
		this.Chapter = this.getChapter();
		this.Verse = this.getVerse();
	}
	
	public Search(String Name, String Chapter, String Verse)
	{
		this.Name = Name;
		this.Chapter = Chapter;
		this.Verse = Verse;
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String Name) 
	{
		this.Name = Name;
	}

	public String getChapter() {
		return Chapter;
	}

	public void setChapter(String Chapter) 
	{
		this.Chapter = Chapter;
	}

	public String getVerse() 
	{
		return Verse;
	}

	public void setVerse(String Verse) 
	{
		this.Verse = Verse;
	}
	
}