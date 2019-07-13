import java.util.Scanner;
import java.util.ArrayList;

public class Main extends Parser {

	public Main(String expression) {
		super(expression);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers;
		ArrayList<Character> operators;
		
		System.out.print("Enter expression: ");
		String exp = sc.nextLine();
		sc.close();
		
		Parser parser = new Parser(exp);
		
		numbers = parser.getNumbers();
    	operators = parser.getOperators();
    	
    	System.out.println("Answer = " + parser(numbers, operators));    	
	}
}
