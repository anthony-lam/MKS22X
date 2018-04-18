public class MyDeque<T>{
    T[] array;
    int start;
    int end;
    int length;
    public MyDeque(){
	array = new T[10];
	length=0;
    }
    public MyDeque(int capacity){
	array = new T[capacity];
	length=0;
    }
    public int size(){
	return length;
    }
    public void addFirst(T value){
	if (start==0){
	    start= array.length-1;
	}
	else{
	    start--;
	}
	array[start]=value;
	length++;
    }
    public void addLast(T value){
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
}
    
    
