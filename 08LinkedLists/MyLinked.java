public class MyLinked{
    private Node first;
    private Node last;
    private int length;
    public int size(){
	return length;
    }
    public int get(int n){
	int index = 0;
	Node current = first;
	while (index != n){
	    current = current.getNext();
	    index++;
	}
	return current.getValue();
    }
    public boolean add(int value){
	Node newNode = new Node(value);
	last.setNext(newNode);
	last = last.getNext();
	length++;
    }
    private Node getNode(int index){
	int n = 
    public void set(int index, int value){
    }
    public void add(int index, int value){
    }
    public void remove(int index, int value){
    }
    private class Node{
	private int data;
	private Node next;
	private Node prev;
	public Node(int data){
	    this.data = data;
	}
	public int getValue(){
	    return data;
	}
	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public boolean setValue(int data){
	    this.data=data;
	    return true;
	}
	public boolean setNext(Node next){
	    this.next=next;
	    return true;
	}
	public boolean setPrev(Node prev){
	    this.prev=prev;
	    return true;
	}
	public String toString(){
	}
    }
}
