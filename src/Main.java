
public class Main {

	public static void main(String[] args) {
		try{
			UserOptions uo = ArgumentsParser.parse(args);
			Constitution c = new Constitution(uo.getPath());
			if(uo.getIfArticles()==false) c.printChapter(uo.getChapter());
			else c.printArticles(uo.getFirstArticle(), uo.getLastArticle());
		}
		catch (IllegalArgumentException ex)
		{
			System.out.println(ex);
		}
	}

}

