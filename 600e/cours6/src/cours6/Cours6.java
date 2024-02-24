package cours6;

import cours6.syntax.lexer.Lexer;
import java.io.*;

public class Cours6 {

	public static void main(String[] args) throws FileNotFoundException {

		new Lexer(new PushbackReader(new FileReader(args[0]), 1024));
		
	}

}
