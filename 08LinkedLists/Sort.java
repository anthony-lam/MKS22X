import java.util.*;
public class Sort{
	@SuppressWarnings("unchecked") public static void radixsortH(MyLinkedListImproved<Integer> data){
		if (data.size()<2){
			return ;
		}
		boolean neg = data.get(0)<0;
		int numOfDigits = data.get(data.max()).toString().length();
		int remainder;
		int value;
		MyLinkedListImproved[] digits = new MyLinkedListImproved[10];
		for(int i = 0; i < 10; i++){
			digits[i] = new MyLinkedListImproved<Integer>();
		}
		if (neg){
			for (int place=1;place<numOfDigits+2; place++){
				while(data.size()>0){
					value=data.get(0);
					remainder=(int)(((Math.abs(value)%Math.pow(10,place)))/Math.pow(10,place-1));
					digits[remainder].add(value);
					data.remove(0);
				}
				for (int i=9;i>=0;i--){
					data.extend(digits[i]);
				}
			}
		}
		else{
			for (int place=1;place<numOfDigits+2; place++){
				while(data.size()>0){
					value=data.get(0);
					remainder=(int)(((value%Math.pow(10,place)))/Math.pow(10,place-1));
					digits[remainder].add(data.get(0));
					data.remove(0);
				}
				for (int i=0;i<10;i++){
					data.extend(digits[i]);
				}
			}
		}
	}
	public static void radixsort(MyLinkedListImproved<Integer> data){
		MyLinkedListImproved<Integer> p = new MyLinkedListImproved<>();
		MyLinkedListImproved<Integer> n = new MyLinkedListImproved<>();
		while (data.size()>0){
			if (data.get(0)>=0){
				p.add(data.get(0));
			}
			else{
				n.add(data.get(0));
			}
			data.remove(0);
		}
		radixsortH(p);
		radixsortH(n);
		data.extend(n);
		data.extend(p);
	}
	public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
		radixsort(data);
	}
	public static void main(String[] args) {
		MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
		a.add(84);
		a.add(-34);
		a.add(43);
		a.add(-34);
		a.add(32842738);
		a.add(-98428);
		a.add(-24);
		a.add(-4535);
		a.add(-34534);
		radixsort(a);
		System.out.println(a);
	}
}