public class MyLinkedList{
	private Node first;
	private Node last;
	private int length;

	public int size(){
		return length;
	}

	public Integer get(int n){
		if  (n < 0 || n >= size()){
			throw new IndexOutOfBoundsException();
		}
		return getNode(n).getValue();
	}

	private Node getNode(int index){
		int n=0;
		Node current = first;
		for (int i = 0; i<length; i++){
			if (i==index){
				return current;
			}
			current=current.getNext();
		}
		return null;
	}

	public void clear(){
		first=null;
		last=null;
		length=0;
	}

	public Integer set(int index, Integer value){
		if  (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		getNode(index).setValue(value);
		return value;
	}

	public int indexOf(Integer value){
		for (int index=0; index<length; index++){
			if (getNode(index).getValue().equals(value)){
				return index;
			}
		}
		return -1;
	}

	public void add(int index, Integer value){
		if  (index < 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		Node toAdd = new Node(value);
		if (length == 0){
			first = toAdd;
			last = toAdd;
			length++;
			return ;	
		}
		if (index == 0){
			first.setPrev(toAdd);
			toAdd.setNext(first);
			first = toAdd;
			length++;
			return ;
		}
		if (index == length){
			add(value);
			return ;
		}
		getNode(index).setPrev(toAdd);
		toAdd.setPrev(getNode(index-1));
		toAdd.setNext(getNode(index));
		getNode(index).setPrev(toAdd);
		getNode(index-1).setNext(toAdd);
		length++;
	}

	public boolean add(Integer value){
		Node toAdd = new Node(value);
		if (length==0){
			first = toAdd;
			last = toAdd; 
		}
		toAdd.setPrev(last);
		last.setNext(toAdd);
		last=toAdd;
		length+=1;
		return true;
	}

	public Integer remove(int index){
		Node node = null;
		if  (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		if (index == 0){
			node=first;
			first = first.getNext();
			first.setPrev(null);
			length--;
			return node.getValue();
		}
		if (index == length-1){
			node=last;
			last = last.getPrev();
			last.setNext(null);
			length--;
			return node.getValue();
		}
		node=getNode(index);
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		length--;
		return node.getValue();
	}

	public boolean remove(Integer value){
		int index = indexOf(value);
		if (index == -1){
			return false;
		}
		remove(index);
		return true;
	}

	public String toString(){
		if (length==0){
			return "[]";
		}
		String ans = "[";
		Node current = first;
		for (int i=0; i<length-1; i++){
			ans = ans + current.getValue() + ",";
			current = current.getNext();
		}
		ans= ans + current.getValue() + "]";
		return ans;
	}

	public static void main(String[] args) {
		MyLinkedList a = new MyLinkedList();
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(0,5);
		System.out.println(a);
		System.out.println(a.size());
		System.out.println(a.indexOf(4));
		a.clear();
		System.out.println(a);
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
