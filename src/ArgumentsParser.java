
public class ArgumentsParser {
	
	public static UserOptions parse(String[] args)
	{
		UserOptions parsed = new UserOptions(args);
		return parsed;
	}
}
