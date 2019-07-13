import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	
	String expression;
	
	public Parser(String expression) {
		this.expression = expression;
	}
	
	public ArrayList<Integer> getNumbers() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		Pattern p = Pattern.compile("\\d*\\d+");
    	Matcher m = p.matcher(expression);
    	try {
    		while(m.find()){
    			numbers.add(Integer.parseInt(m.group()));
    		}
    	} catch (ArithmeticException e) {
    		System.out.println("Only integers are allowed");
		}
    	return numbers;
	}
	public ArrayList<Character> getOperators() {
		ArrayList<Character> operators = new ArrayList<Character>();
    	for(char c : expression.toCharArray()) {
    		if(c=='+' || c=='-' || c=='*' || c=='/') {
    			operators.add(c);
    		}
    	}
    	return operators;
	}
	
	public static int parser(ArrayList<Integer> num, ArrayList<Character> op) {
		int a,b;
		int pl=0,mn=0,st=0,dv=0;
		
		for(char ch: op) {
			switch(ch) {
			case '+':
				pl++;
				break;
			case '-':
				mn++;
				break;
			case '*':
				st++;
				break;
			case '/':
				dv++;
				break;
			}
		}

		while(num.size() > 1) {
			int z;
			while(st >= 1) {
				for(z=0;z<op.size();z++) {
					if(op.get(z) == '*') {
						a = num.get(z);
						b = num.get(z+1);
						num.remove(z);
						num.remove(z);
						op.remove(z);
						if(num.size() == 0) return a*b;
						else num.add(z, a*b);
						st--;
					}
				}
			}
			while(dv >= 1) {
				for(z=0;z<op.size();z++) {
					if(op.get(z) == '/') {
						a = num.get(z);
						b = num.get(z+1);
						num.remove(z);
						num.remove(z);
						op.remove(z);
						if(num.size() == 0) return a/b;
						else num.add(z, a/b);
						dv--;
					}
				}
			}
			while(pl >= 1) {
				for(z=0;z<op.size();z++) {
					if(op.get(z) == '+') {
						a = num.get(z);
						b = num.get(z+1);
						num.remove(z);
						num.remove(z);
						op.remove(z);
						if(num.size() == 0) return a+b;
						else num.add(z, a+b);
						pl--;
					}
				}
			}
			while(mn >= 1) {
				for(z=0;z<op.size();z++) {
					if(op.get(z) == '-') {
						a = num.get(z);
						b = num.get(z+1);
						num.remove(z);
						num.remove(z);
						op.remove(z);
						if(num.size() == 0) return a-b;
						else num.add(z, a-b);
						mn--;
					}
				}
			}
		}
		return num.get(0);
	}
}
