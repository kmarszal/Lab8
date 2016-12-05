import java.util.List;

public class Article {
	private List<String> text;

	public Article() {

	}

	public void printArticle() {
		for (String s : text) {
			System.out.println(s);
		}
	}

}
