import java.util.*;
public class Linked{
	private LinkedList<Double> a = new LinkedList<>();
	public double pop(){
		double ans = a.getLast();
		a.removeLast();
		return ans;
	}
	public double peek(){
		return a.getLast();
	}
	public void push(double value){
		a.add(value);
	}
}