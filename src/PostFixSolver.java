import java.util.Scanner;

/**
 * The PostFixSolver class uses the MyStack class to evaluate a postfix expression, 
 * or state if the syntax is invalid. 
 * 
 * The class has a method called "solvePostFixExpression(String expression)".
 * It also has a main method that allows a user to type an expression and have it solved.
 * This program tells a user if an expression is invalid, as well as return the result if the expression is
 * valid. This program does not crash as a result of any user input, and instead prints meaningful error
 * messages before prompting the user again. The user can type "quit" to exit the program.
 * @author sgb
 *
 */
public class PostFixSolver {

	private MyStack<Double> stack;
	/** 
	 * no argument constructor
	 */
	public PostFixSolver() {
		stack = new MyStack<Double>();
	}

	public double solvePostFixExpression(String expression) {
		expression = expression.trim();
		String[] stringArray = expression.split("\\s");
		double solution = calculate(stringArray);
		return solution;
	}

	private double calculate(String[] stringArray) {
		//Initialize variables to hold operands
		double op1 = 0.0;
		double op2 = 0.0;
		
		//For each element in the expression (stringArray) do one of two things:
		
		//1). If the element is a number then push it to a stack,
		//or 2). if the element is an operator then pop off the numbers 
		//in the stack, operate on them, and then push the result back to the stack.
		
		//Exception Handling:
		
		//Throw an exception if there's a non-operator or non-number element in the expression.
		//Throw an exception if this method's for loop exits and the stack has more than one 
		//number in it.
		String errorMessage = "Not a valid Postfix expression, please try again";
		
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i].matches("\\+|\\-|\\*|\\/")) {
				if (stringArray[i].matches("\\+")) {
					op2 = stack.pop();
					op1 = stack.pop();
					stack.push(op1 + op2);
				} else if (stringArray[i].matches("\\-")) {
					op2 = stack.pop();
					op1 = stack.pop();
					stack.push(op1 - op2);
				} else if (stringArray[i].matches("\\*")) {
					op2 = stack.pop();
					op1 = stack.pop();
					stack.push(op1 * op2);
				} else if (stringArray[i].matches("\\/")) {
					op2 = stack.pop();
					op1 = stack.pop();
					stack.push((double) op1 / op2);
				}
			} else if (stringArray[i].matches("[-\\d.]+|[\\d.]+")) {
				stack.push(Double.parseDouble(stringArray[i]));
			} else {
				throw new IllegalArgumentException(errorMessage);
			}
		}
		if (stack.size() > 1) {
			throw new IllegalArgumentException(errorMessage);
		}
		return stack.pop();
	}
	/**
	 * main() method. Operates the Postfix calculator for the user.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String expression = new String();
		System.out.println("Enter a valid, whitespace delimited, Postfix expression "
				+ "using the following symbols: " + "\n" + "'+' for addition, '-' for subtraction, "
				+ "'*' for multiplication, and '/' for division." + "\n" + "Enter 'quit' to exit.");
		while (true) {
			try {
				PostFixSolver pfs = new PostFixSolver();
				expression = in.nextLine();
				if (expression.equalsIgnoreCase("quit")) {
					break;
				} else {
					double solution = pfs.solvePostFixExpression(expression);
					System.out.println("= " + solution);
					System.out.println("Enter another expression or 'quit' to exit: ");
				}
			} catch (IllegalArgumentException iae) {
				System.out.println(iae.getMessage());
			}
		}
		in.close();
	}
}
