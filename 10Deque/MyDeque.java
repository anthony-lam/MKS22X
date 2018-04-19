import java.util.*;
public class MyDeque<T>{
    private T[] array;
    private int start;
    private int end;
    private int length;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	array = (T[]) new Object[10];
	length = 0;
	start = 0;
	end = 5;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int capacity){
	if (capacity <0){
	    throw new IllegalArgumentException();
	}
	array = (T[]) new Object[capacity];
	length = 0;
	start = 0;
	end = capacity/2;
    }
    public int size(){
	return length;
    }
    public void addFirst(T value){
	if (value==null){
	    throw new NullPointerException();
	}
	if (start==0){
	    start = array.length-1;
	}
	else{
	    start--;
	}
	array[start]=value;
	length++;
    }
    public void addLast(T value){
	if (value==null){
	    throw new NullPointerException();
	}
	if (end == array.length-1){
	    end=0;
	}
	else{
	    end++;
	}
	array[end]=value;
	length++;
    }
    public T removeFirst(){
	if (size()<1){
	    throw new NoSuchElementException();
	}
	length--;
	T ans = array[start];
	array[start]=null;
	start++;
	return ans;
    }
    public T removeLast(){
	if (size()<1){
	    throw new NoSuchElementException();
	}
	T ans = array[end];
	array[end]=null;
	end--;
	length--;
	return ans;
    }
    public T getFirst(){
	if (size()<1){
	    throw new NoSuchElementException();
	}
	return array[start];
    }
    public T getLast(){
	if (size()<1){
	    throw new NoSuchElementException();
	}
	return array[end];
    }
    public static void main(String[] args){
	MyDeque<Integer> a = new MyDeque<>(20);
	a.addLast(new Integer(45));
	a.addLast(new Integer(22));
	a.addLast(new Integer(22));
	a.addLast(new Integer(4854));
	for (int i = 0; i<4 ;i++){
	    System.out.println(a.removeLast ());
	}
    }
}
    
    
