public class MyHeap<T extends Comparable<T>>{
	T[] heap;
	int size=0;
	boolean max = true;
	int index = 0;
	@SuppressWarnings("unchecked")
	public MyHeap(){
		heap = (T[])new Comparable[10];
	}
	@SuppressWarnings("unchecked")
	public MyHeap(boolean max){
		this.max = max;
		heap = (T[])new Comparable[10];
	}
	public void add(T value){
		heap[index]=value;
		index++;
		size++;
	}
	public T remove(){
		index--;
		size--;
		return heap[index-1];
	}
	public T peek(){
		return heap[index-1];
	}
	public int size(){
		return size;
	}
}