import java.util.*;
public class MyDeque<T>{
	private T[] array;
	public int start;
	public int end;
	private int length;
	public int capacity;

	@SuppressWarnings("unchecked")
	public MyDeque(){
		array = (T[]) new Object[10];
		capacity =10;
		length = 0;
		start = 4;
		end = 5;
	}
	@SuppressWarnings("unchecked")
	public MyDeque(int capacity){
		if (capacity <0){
			throw new IllegalArgumentException();
		}
		array = (T[]) new Object[capacity];
		length = 0;
		end = capacity/2;
		start = end-1;
		this.capacity=capacity;
	}
	public int size(){
		return length;
	}
	public void addFirst(T value){
		if (value==null){
			throw new NullPointerException();
		}
		if (array[start]==null){
			array[start]=value;
			length++;
			return ;
		}
		resize();
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
		if (array[end]==null){
			array[end]=value;
			length++;
			return ;
		}
		resize();
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
		T ans = array[start];
		array[start]=null;
		if (start==capacity-1){
			start=0;
		}
		else{
			start++;
		}
		length--;
		return ans;
	}
	public T removeLast(){
		if (size()<1){
			throw new NoSuchElementException();
		}
		T ans = array[end];
		array[end]=null;
		if (end==0){
			end=capacity-1;
		}
		else{
			end--;	
		}
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
	@SuppressWarnings("unchecked")
	public void resize(){
		if(length<capacity-1){
			return;
		}
		T[] newSize = (T[]) new Object[capacity*2];
		int current=start;
		for (int i = 0; i<length;i++){
			newSize[i]=array[current%capacity];
			current++;
		}
		array=newSize;
		start=0;
		end=length-1;
		capacity*=2;
	}
}

