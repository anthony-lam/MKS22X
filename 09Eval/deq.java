public class deq<T>{
    int start;
    int end;
    private class Linked{
    	LinkedList<String> a;
    	public String pop(){
    		String ans = a.get(a.size()-1);
    		a.remove(a.size()-1);
    		return ans;
    	}
    	public String peek(){
    		return a.get(a.size()-1);
    	}

    }
    public static double eval(String expression){
    	LinkedList<String> stack = new LinkedList<>();
    	String[] splitStr = str.split("\\s+");
    	for (int i =0; i<splitStr.length; i++){
    		stack.add(splitStr[i]);
    	}
    }
}
