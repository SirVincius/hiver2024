package cours6;

import cours6.syntax.analysis.*;
import cours6.syntax.node.*;

public class Evaluator extends DepthFirstAdapter {
	
<<<<<<< HEAD
	private Evaluator() {
	}
	
	public static int evaluate(Node tree) {
		Evaluator evaluator = new Evaluator()
;		return evaluator.eval(tree);
=======
	public static int evaluate(Node tree) {
		Evaluator evaluator = new Evaluator();
		return evaluator.eval(tree);
>>>>>>> a3f0b03 (.)
	}
	
	private Integer currentResult;
	
	private void visit(Node node) {
		
		if ( node != null) {
			node.apply(this);
		}
		
	}
	
	private int eval(Node node) {
		
		if (this.currentResult != null)
			throw new InternalError();
		
		visit(node);
		
		if(this.currentResult == null)
			throw new InternalError();
		
		int result = this.currentResult;
		currentResult = null;
		
		return result;
		
	}
	
	private void setResult(int value) {
		if (this.currentResult != null)
			throw new InternalError();
		
		this.currentResult = value;
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
		
		setResult(left + right);
		
	}
	
	@Override
	public void caseASubExp(ASubExp node) {
		
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		setResult(left - right);
		
	}
	
	@Override
	public void caseAMultExp(AMultExp node) {
<<<<<<< HEAD
		
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		currentResult = left * right;
		
	}
	
	public void caseADivExp(ADivExp node) {
		
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		currentResult = left / right;
		
=======
	
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		setResult(left * right);
	
	}
	
	@Override
	public void caseADivExp(ADivExp node) {
	
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		setResult(left / right);
	
	}
	
	@Override
	public void caseAModExp(AModExp node) {
	
		int left = eval(node.getLeft());
		int right = eval(node.getRight());
		
		setResult(left % right);
	
	}
	
	@Override
	public void caseASignExp(ASignExp node) {
	
		int term = eval(node.getTerm());
		
		setResult(-term);
	
>>>>>>> a3f0b03 (.)
	}
	
}
