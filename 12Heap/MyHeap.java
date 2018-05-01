import java.util.*;
public class MyHeap<T extends Comparable<T>>{
    T[] heap;
    int size=10;
    boolean max = true;
    int current = 0;
    @SuppressWarnings("unchecked")
    public MyHeap(){
	heap = (T[])new Comparable[10];
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean max){
	this.max = max;
	heap = (T[])new Comparable[10];
    }
    @SuppressWarnings("unchecked")
    public void resize(){
	if (current<size-1){
	    return ;
	}
	T[] temp = (T[])new Comparable[size*2];
	for (int i=0;i<size;i++){
	    temp[i]=heap[i];
	}
	size*=2;
	heap=temp;
    }
    public void add(T value){
	resize();
	heap[current]=value;
	if (max){
	    pushMax(current);
	}
	else{
	    pushMin(current);
	}
	current++;
    }
    public void pushMax(int index){
	int parent = (index-1)/2;
	if (parent<=0||heap[index].compareTo(heap[parent])<0){
	    return ;
	}
	T temp = heap[parent];
	heap[parent]=heap[index];
	heap[index]=temp;
	pushMax(parent);
    }
    private void pushMin(int index){
	int parent = (index-1)/2;
	if (parent<=0||heap[index].compareTo(heap[parent])>0){
	    return ;
	}
	T temp = heap[parent];
	heap[parent]=heap[index];
	heap[index]=temp;
	pushMax(parent);
    }
    public void downMax(int index){
	int left = index*2+1;
	int right = left +1;
	if (left>=current){
	    return ;
	}
	if (heap[right]==null&&heap[left].compareTo(heap[index])>0){
	    T temp = heap[left];
	    heap[left]=heap[index];
	    heap[index]=temp;
	    downMax(left);
	    return ;
	}
	if (heap[right]==null){
	    return ;
	}
	if (heap[index].compareTo(heap[left])<0 && heap[index].compareTo(heap[right])<0){
	    return ;
	}
	if (heap[left].compareTo(heap[right])>0){
	    T temp = heap[left];
	    heap[left]=heap[index];
	    heap[index]=temp;
	    downMax(left);
	    return ;
	}
	else{
	    T temp = heap[right];
	    heap[right]=heap[index];
	    heap[index]=temp;
	    downMax(right);
	    return ;
	}
    }
    private void downMin(int index){
	int left = index*2+1;
	int right = left +1;
	if (left>current){
	    return ;
	}
	if (heap[right]==null&&heap[left].compareTo(heap[index])<0){
	    T temp = heap[left];
	    heap[left]=heap[index];
	    heap[index]=temp;
	    downMax(left);
	    return ;
	}
	if (heap[right]==null){
	    return ;
	}
	if (heap[index].compareTo(heap[left])>0 && heap[index].compareTo(heap[right])>0){
	    return ;
	}
	if (heap[left].compareTo(heap[right])<0){
	    T temp = heap[left];
	    heap[left]=heap[index];
	    heap[index]=temp;
	    downMax(left);
	    return ;
	}
	else{
	    T temp = heap[right];
	    heap[right]=heap[index];
	    heap[index]=temp;
	    downMax(right);
	    return ;
	}
    }
    public T remove(){
	T ans = heap[0];
	heap[0]=heap[current-1];
	if (max){
	    downMax(0);
	}
	else{
	    downMin(0);
	}
	current--;
	return ans;
    }
    public T peek(){
	return heap[0];
    }
    public int size(){
	return current;
    }
    public String toString(){
	return Arrays.toString(heap);
    }
}
