public class Calculator{
	int start;
	int end;
	public static double eval(String expression){
		Linked stack = new Linked();
		String[] splitStr = expression.split(" ");
		for (int i =0; i<splitStr.length; i++){
			if(!"+-/*%".contains(splitStr[i])){
				stack.push(Double.parseDouble(splitStr[i]));
			}else{
				if(splitStr[i].equals("+")){
					stack.push(stack.pop() + stack.pop());
				}
				if(splitStr[i].equals("-")){
					stack.push(- stack.pop() + stack.pop());
				}
				if(splitStr[i].equals("*")){
					stack.push(stack.pop() * stack.pop());
				}
				if(splitStr[i].equals("/")){
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b / a);
				}
				if(splitStr[i].equals("%")){
					double a = stack.pop();
					double b = stack.pop();
					stack.push(b % a);
				}
			}
		}
		return stack.pop();
	}
	public static void main(String[] args){
		System.out.println(Calculator.eval("10 2.0 +"));
		System.out.println(Calculator.eval("11 3 - 4 + 2.5 *"));
		System.out.println(Calculator.eval("8 2 + 99 9 - * 2 + 9 -"));
		System.out.println(Calculator.eval("10 2.0 /"));
		System.out.println(Calculator.eval("10 2.0 %"));
	}
}
