package cours6;

import cours6.syntax.analysis.*;
import cours6.syntax.node.ANumTerm;
import cours6.syntax.node.TPlus;

public class Evaluator extends DepthFirstAdapter {
	
	@Override
	public void caseANumTerm(ANumTerm node) {
		String text = node.getNum().getText();
		try {
			Integer.parseInt(text);
		} catch (NumberFormatException e) {
			System.out.println("Mauvais format pour le nombre " + node.getNum().getLine());
		}
	}

	@Override
	public void caseTPlus(TPlus node) {
		
		
		
	}
	
}
