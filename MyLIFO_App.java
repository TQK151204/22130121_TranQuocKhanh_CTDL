package Lab_10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;import javax.sound.midi.MidiChannel;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> stack = new Stack<E>();
		for (int i = 0; i < array.length; i++) {
			stack.push(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (char Character : input.toCharArray()) {
			if (Character == '(' || Character == '[' || Character == '{') {
				stack.push((Character == '(') ? ')' : (Character == '{') ? '}' : ']');

			} else if (Character == ')' || Character == ']' || Character == '}') {
				if (stack.isEmpty() || stack.pop() != Character) {
					return false;
				}
			}

		}
		return stack.isEmpty();
	}

	public static int evaluateExpression(String expression) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			if (Character.isDigit(ch)) {
				// If the character is a digit, extract the entire number
				StringBuilder num = new StringBuilder();
				while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
					num.append(expression.charAt(i));
					i++;
				}
				i--; // Move back one step to handle the next character correctly
				operands.push(Integer.parseInt(num.toString()));
			} else if (ch == '(') {
				operators.push(ch);
			} else if (ch == ')') {
				// Evaluate the expression inside the parentheses
				while (!operators.isEmpty() && operators.peek() != '(') {
					operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
				}
				operators.pop(); // Pop the '('
			} else if (isOperator(ch)) {
				// Pop operators with higher or equal precedence and then push the current
				// operator
				while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
					operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
				}
				operators.push(ch);
			}
		}

		// Evaluate the remaining operators
		while (!operators.isEmpty()) {
			operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
		}

		// The result should be the only element left in the operands stack
		return operands.pop();
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static int precedence(char operator) {
		switch (operator) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	private static int applyOperator(char operator, int operand2, int operand1) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			if (operand2 == 0) {
				throw new ArithmeticException("Cannot divide by zero");
			}
			return operand1 / operand2;
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}

	// method stutter that accepts a queue of integers asa parameter and replaces
	// every element of the queue with two copies of thatelement
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E temp = input.poll();
			input.add(temp);
			input.add(temp);
		}
	}

	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<>();

		// Dequeue and push elements onto the stack
		while (!input.isEmpty()) {
			stack.push(input.poll());
		}

		// Enqueue elements from the stack back into the original queue
		while (!stack.isEmpty()) {
			input.offer(stack.pop());
		}

	}

	public static void main(String[] args) {
		String input = "()(())[]{(())}";
		System.out.println(isCorrect(input));

		Queue<Integer> input1 = new LinkedList<>();
		input1.add(1);
		input1.add(2);
		input1.add(3);
		stutter(input1);
		System.out.println(input1);
		String expression = "51 + (54 * (3 + 2))";
		int result = evaluateExpression(expression);
		System.out.println(expression + " = " + result);
		
		Queue<Character> input2 = new LinkedList<>();
		input2.add('a');
        input2.add('b');
        input2.add('c');
        System.out.println(input2);
        mirror(input2);
        
        System.out.println(input2);
        
	}

}
