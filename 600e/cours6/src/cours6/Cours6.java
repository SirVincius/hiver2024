package cours6;

import cours6.syntax.lexer.Lexer;
import cours6.syntax.lexer.LexerException;
import cours6.syntax.parser.Parser;
import cours6.syntax.parser.ParserException;
import cours6.syntax.node.*;

import java.io.*
;
public class Cours6 {

	public static void main(String[] args) throws ParserException, LexerException, IOException {

		Parser parser = new Parser(new Lexer(new PushbackReader(new FileReader(args[0]), 1024)));
		
		Node tree = parser.parse();
		
		Evaluator evaluator = new Evaluator();
		tree.apply(evaluator);
		
		System.out.println(evaluator.currentResult);
	}

}
