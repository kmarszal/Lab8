import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserOptions {
	private int FirstArticle;
	private int LastArticle;
	private int Chapter;
	private String Path;
	private boolean articles;
	
	public int getFirstArticle()
	{
		return FirstArticle;
	}
	
	public int getLastArticle()
	{
		return LastArticle;
	}
	
	public int getChapter()
	{
		return Chapter;
	}
	
	public String getPath()
	{
		return Path;
	}
	
	public boolean getIfArticles()
	{
		return articles;
	}
	
	public UserOptions(String[] args) throws IllegalArgumentException
	{
		Pattern path1 = Pattern.compile("[C-Z]:/.+");
		Pattern path2 = Pattern.compile("[/].+");
		Pattern articles = Pattern.compile("\\d+-\\d+");
		Pattern chapter = Pattern.compile("\\d+");
		boolean bpath=false,barticles=false,bchapter=false;
		for(String arg : args)
		{
			Matcher mpath1 = path1.matcher(arg);
			Matcher mpath2 = path2.matcher(arg);
			Matcher marticles = articles.matcher(arg);
			Matcher mchapter = chapter.matcher(arg);
			if(!bpath && (mpath1.matches() || mpath2.matches())) {
				Path = arg;
				bpath = true;
			}
			if(!barticles && marticles.matches())
			{
				FirstArticle = Integer.parseInt(arg.substring(0, arg.indexOf('-')));
				LastArticle = Integer.parseInt(arg.substring(arg.indexOf('-') + 1));
				if(FirstArticle < 1 || FirstArticle > 243) throw new IllegalArgumentException("Pierwszego podanego artykułu nie ma w konstytucji, spróbuj podać wartość z przedziału 1 - 243");
				if(LastArticle < 1 || LastArticle > 243) throw new IllegalArgumentException("Ostatniego podanego artykułu nie ma w konstytucji, spróbuj podać wartość z przedziału 1 - 243");
				if(FirstArticle > LastArticle) throw new IllegalArgumentException("Nieprawidłowy przedział artykułów, spróbuj podać numer pierwszego artykułu mniejszy niż ostatniego");
				barticles = true;
			}
			if(!bchapter && mchapter.matches())
			{
				Chapter = Integer.parseInt(arg);
				if(Chapter < 1 || Chapter > 13) throw new IllegalArgumentException("Podanego rozdziału nie ma w konstytucji, spróbuj podać wartość z przedziału 1 - 13");
				bchapter = true;
			} 
		}
		if(!barticles && !bchapter) throw new IllegalArgumentException("Nie podano numeru rozdziału ani przedziału artykułów, poprawna składnia to \"n\" dla rozdziałów i \"n-m\" dla przedziałów artykułów");
		if(!bpath) throw new IllegalArgumentException("Nie podano ścieżki lub podano ją nieprawidłowo");
		if(barticles) this.articles = true;
		else this.articles = false;
	}
}

