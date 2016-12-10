import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
	public static String[] concatenate(String first, String second) {
		String[] strings = new String[2];
		String part1 = first.substring(first.lastIndexOf(' ') + 1);
		part1 = part1.substring(0, part1.length() - 1);
		String part2 = new String();
		if(second.contains(" ")) part2 = second.substring(0, second.indexOf(' '));
		else part2 = second;
		first = first.substring(0, first.lastIndexOf(' '));
		if(second.contains(" ")) second = second.substring(second.indexOf(' '));
		strings[0] = first;
		if(second.contains(" ")) strings[1] = part1 + part2 + second;
		else strings[1] = part1+part2;
		return strings;
	}

	public static boolean endsWithDash(String line) {
		return line.charAt(line.length() - 1) == '-';
	}
	
	public static Types test(String tested)
	{
		if(tested==null) return Types.ToDelete;
		Pattern Data = Pattern.compile("[\\d]{0,4}-[0-1][\\d]-[0-3][\\d]");
		Pattern Article = Pattern.compile("Art\\..*");
		Pattern Chapter = Pattern.compile("Rozdział\\s[MDCLXVI]+");
		Pattern Subchapter = Pattern.compile("[A-Z[ĄŻŹĘĆŃŁÓ][\\s]]+");
		Pattern Kancelaria = Pattern.compile("﻿[©].*");
		Pattern Char = Pattern.compile(".");
		Matcher mData = Data.matcher(tested);
		Matcher mKancelaria = Kancelaria.matcher(tested);
		Matcher mChapter = Chapter.matcher(tested);
		Matcher mSubchapter = Subchapter.matcher(tested);
		Matcher mArticle = Article.matcher(tested);
		Matcher mChar = Char.matcher(tested);
		if(mArticle.matches()) return Types.Article;
		if(mData.matches() || mKancelaria.matches() || mChar.matches()) return Types.ToDelete;
		if(mSubchapter.matches()) return Types.Subchapter;
		if(mChapter.matches()) return Types.Chapter;
		if(tested.equals("©Kancelaria Sejmu")) return Types.ToDelete;
		else return Types.Text;
	}
	
	public static int romanToDec(String roman)
	{
		int dec=0;
		return dec;
	}

}

