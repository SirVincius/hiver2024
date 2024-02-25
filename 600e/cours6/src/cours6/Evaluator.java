package cours6;

import cours6.syntax.analysis.*;
import cours6.syntax.node.*;

public class Evaluator extends DepthFirstAdapter {
	
	private Evaluator() {
	}
	
	public static int evaluate(Node tree) {
		Evaluator evaluator = new Evaluator()
;		return evaluator.eval(tree);
	}
	
	private Integer currentResult;
	
	private void visit(Node node) {
		
		if ( node != null) {
			node.apply(this);
		}
		
	}
	
	int eval(Node node) {
		
		visit(node);
		int result = this.currentResult;
		currentResult = null;
		
		return result;
		
	}
	
	@Override
	public void caseANumTerm(ANumTerm node) {
		String text = node.getNum().getText();
		try {
			this.currentResult = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			System.out.println("Mauvais format pour le nombre " + node.getNum().getLine());
		}
	}
	
	
	@Override
	public void caseAAddExp(AAddExp node) {
	
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		this.currentResult = left + right;
		
	}
	
	@Override
	public void caseASubExp(ASubExp node) {
		
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		this.currentResult = left - right;
		
	}
	
	@Override
	public void caseAMultExp(AMultExp node) {
		
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		currentResult = left * right;
		
	}
	
	public void caseADivExp(ADivExp node) {
		
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		currentResult = left / right;
		
	}
	
}
