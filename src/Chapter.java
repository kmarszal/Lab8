import java.util.List;

public class Chapter {
	private List<Article> articles;
	
	public Chapter()
	{
		
	}
	
	public void printChapter()
	{
		for(Article a : articles)
		{
			a.printArticle();
		}
	}
}
