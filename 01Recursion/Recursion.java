public class Recursion{
	public int fact(int n){
		if (n<0){
			throw new IllegalArgumentException();
		}
		if (n==0){
			return 1;
		}
		return n*fact(n-1);
	}
	public int fib(int n){
		if (n<0){
			throw new IllegalArgumentException();
		}
		return fibHelp(0,1,n);
	}
	public int fibHelp(int num1, int num2, int n){
		if (n==1){
			return num1;
		}
		return fibHelp(num1 +num2,num1,n-1);
	}
	public static void main(String[] args) {
		Recursion a =new Recursion();
		System.out.println(a.fib(10));
	}
}