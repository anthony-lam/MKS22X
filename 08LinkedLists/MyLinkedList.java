public class MyLinkedList{
    private Node first;
    private Node last;
    private int length;
    public int size(){
	return length;
    }
    public Integer get(int n){
	int index = 0;
	Node current = first;
	while (index != n){
	    current = current.getNext();
	    index++;
	}
	return current.getValue();
    }
    public boolean add(Integer value){
	Node newNode = new Node(value);
	last.setNext(newNode);
	last = last.getNext();
	length++;
	return true;
    }
    private Node getNode(int index){
	return null;
    }
    public void clear(){
	first=null;
	last=null;
    }
    public void set(int index, Integer value){
	getNode(index).setValue(value);
    }
    public int indexOf(Integer value){
	for (int index=0; index<=size; index++){
	    if (getNode(index).getValue().equals(value)){
		return index;
	    }
	}
	return -1;
    }
    public void add(int index, Integer value){
	Node toAdd = new Node(value);
	getNode(index).setPrev(toAdd);
	toAdd.setPrev(getNode(index-1));
	//not done
    }
    public boolean add(Integer value){
	Node toAdd = new Node(value);
	last.setNext(toAdd);
	//not done
	return true;
    }
    public void remove(int index, Integer value){
    }
    public String toString(){
	String ans = "[";
	Node current = first;
	while (current.getNext()!=null){
	    current = current.getNext();
	    ans+=current.getValue();
	    ans+=",";
	}
	ans+="]";
	return ans;
    }
    private class Node{
	private Integer data;
	private Node next;
	private Node prev;
	public Node(Integer data){
	    this.data = data;
	}
	public Integer getValue(){
	    return data;
	}
	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return prev;
	}
	public void setValue(int data){
	    this.data=data;
	}
	public void setNext(Node next){
	    this.next=next;
	}
	public void setPrev(Node prev){
	    this.prev=prev;
	}
	public String toString(){
	    return data.toString();
	}
    }
}
