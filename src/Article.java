import java.util.List;

public class Article {
	private int number;
	
	public int getNumber() {
		return number;
	}

	private List<String> text;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (number != other.number)
			return false;
		return true;
	}

	public Article(int number,List<String> text) {
		this.number = number;
		this.text = text;
	}

	public void printArticle() {
		System.out.println("Art. " + number);
		for (String s : text) {
			System.out.println(s);
		}
	}
}
