import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
	private Node first;
	private Node last;
	private int length;

	public Iterator<T> iterator(){
		return new LinkedListIterator(this);
	}

	public int size(){
		return length;
	}

	public T get(int n){
		if  (n < 0 || n >= size()){
			throw new IndexOutOfBoundsException();
		}
		return getNode(n).getValue();
	}

	private Node getNode(int index){
		if (index<length/2){
			Node current = first;
			for (int i = 0; i<length; i++){
				if (i==index){
					return current;
				}
				current=current.getNext();
			}
		}
		else{
			Node current = last;
			for (int i = length-1; i>-1; i--){
				if (i==index){
					return current;
				}
				current=current.getPrev();
			}
		}
		return null;
	}

	public void clear(){
		first=null;
		last=null;
		length=0;
	}

	public T set(int index, T value){
		if  (index < 0 || index >= size()){
			throw new IndexOutOfBoundsException();
		}
		getNode(index).setValue(value);
		return value;
	}

	public int indexOf(T value){
		for (int index=0; index<length; index++){
			if (getNode(index).getValue().equals(value)){
				return index;
			}
		}
		return -1;
	}

	public void add(int index, T value){
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

	public boolean add(T value){
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

	public T remove(int index){
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

	public boolean remove(T value){
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
	public int max(){
		if (length==0){
			return -1;
		}
		int ans = 0;
		T value =first.getValue();
		Node current = first;
		for (int i=1; i<length;i++){
			if(current.getValue().compareTo(value)>0){
				value = current.getValue();
				ans=i;
			}
			current=current.getNext();
		}
		return ans;
	}
	public int min(){
		if (length==0){
			return -1;
		}
		int ans = 0;
		T value =first.getValue();
		Node current = first;
		for (int i=1; i<length;i++){
			if(current.getValue().compareTo(value)<0){
				value = current.getValue();
				ans=i;
			}
			current=current.getNext();
		}
		return ans;
	}

	public static void main(String[]args){
      MyLinkedList nums = new MyLinkedList();
      LinkedList<Integer> nums2 = new LinkedList<>();
      
      for(int i = 0; i < 2000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds");
      
      int max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        if(nums.remove(i)!=nums2.remove(i).intValue()){
          System.out.println("FAIL while removing index: "+i);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL consecutive removes");
          return;
        }
      }
      System.out.println("PASS consecutive removes");
      
      
      for(int i = 0; i < 1000; i++  ){
        int index = (int)(Math.random()*(1 + nums.size()));
        nums.add(index,i);
        nums2.add(index,i);
      }
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i) != nums2.get(i).intValue()){
          System.out.println("FAIL Randomized adds location: "+i+" "+nums.get(i)+" vs "+nums2.get(i));
          return;
        }
      }
      System.out.println("PASS Randomized adds phase 2");
      
      
      max = nums.size();
      for(int i = 0; i < max/2; i++  ){
        int index = (int)(Math.random()*nums.size());
        if(nums.remove(index)!=nums2.remove(index).intValue()){
          System.out.println("FAIL while removing index: "+index);
          return;
        }
      }
      nums.remove(0);
      nums2.remove(0);
      nums.remove(nums.size()-1);
      nums2.remove(nums2.size()-1);
      
      for(int i = 0; i < nums.size(); i++  ){
        if(nums.get(i)!=nums2.get(i).intValue()){
          System.out.println("FAIL randomized removes");
          return;
        }
      }
      System.out.println("PASS randomized removes");
      
      //get-------------------
      try{
        nums.get(-3);
        System.out.println("FAIL get access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds negateive index ");
      }
      
      try{
        nums.get(nums.size());
        System.out.println("FAIL get access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS get out of bounds index too large");
      }
      
      
      //set-------------------
      try{
        nums.set(-3,5);
        System.out.println("FAIL set access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds negateive index ");
        
      }
      
      try{
        nums.set(nums.size(),5);
        System.out.println("FAIL set access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS set out of bounds index too large");
      }
      
      
      
      //add-------------------
      try{
        nums.add(nums.size()+1,5);
        System.out.println("FAIL add access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds index too large");
      }
      
      try{
        nums.add(-1,5);
        System.out.println("FAIL add access negative index did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS add out of bounds negative index");
      }
      
      
      
      //remove-------------------
      try{
        nums.remove(nums.size()+1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      try{
        nums.remove(-1);
        System.out.println("FAIL remove access index too large did not throw exception");
        return;
      }catch(IndexOutOfBoundsException e){
        System.out.println("PASS remove out of bounds index too large");
      }
      
      
      //
      nums.clear();
      if(nums.size()==0){
        System.out.println("PASS clear");
      }else{
        System.out.println("FAIL clear");
        return;
      }
      
      
      
      //REMOVE BY VALUE (not index)
      nums.clear();
      for(int i = 0; i < 10; i++){
        nums.add(0,Integer.valueOf(i));
      }
      if(nums.remove(Integer.valueOf(0)) && nums.remove(Integer.valueOf(1)) &&
      nums.remove(Integer.valueOf(5)) && nums.remove(Integer.valueOf(3)) &&
      nums.remove(Integer.valueOf(8))&& nums.remove(Integer.valueOf(9)))  {
        try{
          int[]result = { 7, 6, 4, 2};
          for(int i = 0; i < nums.size();i++ ){
            if(result[i]!=nums.get(i).intValue()){
              System.out.println("FAIL to remove by value. Final State bad");
              return;
            }
          }
        }catch(Exception e){
          System.out.println("FAIL to remove by value. Exception thrown");
          return;
        }
      }else{
        System.out.println("FAIL to remove by value.");
        return;
      }
      System.out.println("PASS remove by values (Integer, not int).");
      
      nums.clear();
      long end,start = System.currentTimeMillis();
      
      System.out.println("#Adding to 100000 values to the front, and 100000 to the end, should be fast.\n#If the next line doesn't print right away you have some issues.");
      for(int i = 0; i < 100000; i++  ){
        nums.add(i);
        nums.add(nums.size(),i);
      }
      end = System.currentTimeMillis();
      //mine was 8msec on a laptop, so 250 should be fine!
      if(end - start > 250){
        System.out.println("FAIL! Should be much faster than "+(end-start)+"msec");
        return;
      }else{
        System.out.println("PASS "+ (end-start)+" msec current size: "+nums.size());
      }
    }

	private class Node{
		private T data;
		private Node next;
		private Node prev;
		public Node(T data){
			this.data = data;
		}
		public T getValue(){
			return data;
		}
		public Node getNext(){
			return next;
		}
		public Node getPrev(){
			return prev;
		}
		public void setValue(T data){
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
	private class LinkedListIterator implements Iterator<T>{
		private MyLinkedListImproved<T> list;
		private Node current;
		public LinkedListIterator(MyLinkedListImproved<T> list){
			this.list = list;
			current = list.getNode(0);
		}
		public boolean hasNext(){
			return current!=null;
		}
		public T next(){
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T ans = current.getValue();
			current = current.getNext();
			return ans;
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	public void extend(MyLinkedListImproved<T> toAdd){
		if (toAdd.size()==0){
			return ;
		}
		length += toAdd.size();
		last.setNext(toAdd.getNode(0));
		last = toAdd.getNode(toAdd.size()-1);
		toAdd.clear();
	}
}
