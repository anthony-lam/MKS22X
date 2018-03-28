public class MyLinked{
	private Node first;
	private Node last;
	private int length;
	public int size(){
		return length;
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
	}
}