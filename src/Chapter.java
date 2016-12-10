import java.util.HashMap;
import java.util.List;

public class Chapter {
	private int number;
	private int firstArticle;
	private int lastArticle;
	private String title;
	private HashMap<Integer,Article> articles;
	
	public int getNumber() {
		return number;
	}

	public int getFirstArticle() {
		return firstArticle;
	}

	public int getLastArticle() {
		return lastArticle;
	}

	public Chapter(int number,String title, List<Article> articles) {
		this.number = number;
		this.title = title;
		this.firstArticle = articles.get(0).getNumber();
		this.lastArticle = articles.get(articles.size()-1).getNumber();
		this.articles = new HashMap<>();
		for(Article a : articles)
		{
			this.articles.put(a.getNumber(), a);
		}
	}
	
	public void printChapter()
	{
		System.out.println("ROZDZIAL " + number);
		System.out.println(title);
		for(Article a : articles.values())
		{
			a.printArticle();
		}
	}
	
	public void printArticles(int first,int last)
	{
		for(Integer i = first;i<=last;++i)
		{
			articles.get(i).printArticle();
		}
	}
}
