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
		if (n==0){
			return 0;
		}
		if (n==1){
			return 1;
		}
		return fibHelp(0,1,n);
	}
	public int fibHelp(int num1, int num2, int n){
		if (n==0){
			return num1;
		}
		return fibHelp(num1 +num2,num1,n-1);
	}
	public double sqrt(double n){
		if (n<0){
			throw new IllegalArgumentException();
		}
		if (n==0){
			return 0;
		}
		return sqrtHelp(n, n/2);
	}
	public double sqrtHelp(double orig, double guess){
		if (Math.abs(guess*guess-orig)/orig < 0.00001){
			return guess;
		}
		return sqrtHelp(orig, (orig/guess + guess) / 2);
	}
}