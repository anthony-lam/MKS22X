import java.util.*;
public class Sort{
	public static void radixsort(MyLinkedListImproved<Integer> data){
		if (data.size()==0){
			return ;
		}
		int numOfDigits;
		int maxNumOfDigits = (int)(Math.log10(data.get(data.max())));
		int minNumOfDigits = (int)(Math.log10(Math.abs(data.get(data.min()))));
		if (maxNumOfDigits>minNumOfDigits){
			numOfDigits=maxNumOfDigits;
		}
		else{
			numOfDigits=minNumOfDigits;
		}
		int remainder;
		int value;
		@SuppressWarnings("unchecked") MyLinkedListImproved[] digits = new MyLinkedListImproved[10];
		for(int i = 0; i < 10; i++){
			digits[i] = new MyLinkedListImproved<Integer>();
		} 
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
		/*
		for (Integer num : data){
			if (num<0){
				data.remove(num);
				data.add(0,num);
			}
		}
		*/
	}
	/*
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
		while (n.size()>0){
			data.add(n.get(n.size()-1));
			n.remove(n.size()-1);
		}
		data.extend(p);
	}*/
	/*public static void main(String[] args) {
		//-----------SORTING POSITIVES-----------
		System.out.println("TESTING ON POSITIVE INTEGERS ONLY:");
		MyLinkedListImproved<Integer> data = new MyLinkedListImproved<>();
		int[] correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
		for(int i = 0; i < 1000; i++){
			int temp = (int)(Math.random() * 1000);
			data.add(temp);
			correctData[i] = temp;
		}

    //Sorts data and times the sort
		double end,start = System.currentTimeMillis();
		radixsort(data);
		end = System.currentTimeMillis();

    //Sorts the array
		Arrays.sort(correctData);
		System.out.println("Sort completed in " + (end - start) + " ms");

    //Checks if data is properly sorted
		boolean hasError = false;
		int index = 0;
		for(Integer x: data){
			if(!(x.equals(correctData[index]))){
				System.out.println("THERE IS AN ERROR");
				System.out.println("Index of error: " + index);
				hasError = true;
			}
			index++;
		}

		if(!(hasError)){
			System.out.println("Your LinkedList with all positive integers is properly sorted.");
		}
		else{
			System.out.println(data);
		}
		System.out.println("\n");


    //-----------SORTING NEGATIVES-----------
		System.out.println("TESTING ON NEGATIVE INTEGERS ONLY:");
		data.clear();
		correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
		for(int i = 0; i < 1000; i++){
			int temp = (int)(Math.random() * 1000);
			temp *= -1;
			data.add(temp);
			correctData[i] = temp;
		}

    //Sorts data and times the sort
		start = System.currentTimeMillis();
		radixsort(data);
		end = System.currentTimeMillis();

    //Sorts the array
		Arrays.sort(correctData);
		System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
		hasError = false;
		index = 0;
		for(Integer x: data){
			if(!(x.equals(correctData[index]))){
				System.out.println("THERE IS AN ERROR");
				System.out.println("Index of error: " + index);
				hasError = true;
			}
			index++;
		}

		if(!(hasError)){
			System.out.println("Your LinkedList with all negative numbers is properly sorted.");
		}
		else{
			System.out.println(data);
		}
		System.out.println("\n");


    //-----------SORTING POSITIVES AND NEGATIVES-----------
		System.out.println("TESTING ON POSITIVE AND NEGATIVE INTEGERS:");
		data.clear();
		correctData = new int[1000];

    //Create MyLinkedListImproved and array with random integers
		for(int i = 0; i < 1000; i++){
			int temp = (int)(Math.random() * 1000);
			if((int)(Math.random() * 1000) % 2 == 0){
				temp *= -1;
			}
			data.add(temp);
			correctData[i] = temp;
		}

    //Sorts data and times the sort
		start = System.currentTimeMillis();
		radixsort(data);
		end = System.currentTimeMillis();

    //Sorts the array
		Arrays.sort(correctData);
		System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
		hasError = false;
		index = 0;
		for(Integer x: data){
			if(!(x.equals(correctData[index]))){
				System.out.println("THERE IS AN ERROR");
				System.out.println("Index of error: " + index);
				hasError = true;
			}
			index++;
		}

		if(!(hasError)){
			System.out.println("Your LinkedList with positive and negative integers is properly sorted.");
		}
		else{
			System.out.println(data);
		}
		System.out.println("\n");


    //-----------SORTING EMPTY LISTS-----------
		System.out.println("SORTING ON EMPTY LISTS");
		data.clear();
		correctData = new int[0];

		start = System.currentTimeMillis();
		radixsort(data);
		end = System.currentTimeMillis();

    //Sorts the array
		Arrays.sort(correctData);
		System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
		hasError = false;
		index = 0;
		for(Integer x: data){
			if(!(x.equals(correctData[index]))){
				System.out.println("THERE IS AN ERROR");
				System.out.println("Index of error: " + index);
				hasError = true;
			}
			index++;
		}

		if(!(hasError)){
			System.out.println("Your empty LinkedList is properly sorted.");
		}
		else{
			System.out.println(data);
		}
		System.out.println("\n");


    //-----------SORTING POSITIVE ONE-ELEMENT LISTS-----------
		System.out.println("SORTING POSITIVE ONE-ELEMENT LISTS");
		data.clear();
		correctData = new int[1];

		int temp = (int)(Math.random() * 1000);
		data.add(temp);
		correctData[0] = temp;

		start = System.currentTimeMillis();
		radixsort(data);
		end = System.currentTimeMillis();

    //Sorts the array
		Arrays.sort(correctData);
		System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
		hasError = false;
		index = 0;
		for(Integer x: data){
			if(!(x.equals(correctData[index]))){
				System.out.println("THERE IS AN ERROR");
				System.out.println("Index of error: " + index);
				hasError = true;
			}
			index++;
		}

		if(!(hasError)){
			System.out.println("Your LinkedList with one positive element is properly sorted.");
		}
		else{
			System.out.println(data);
		}
		System.out.println("\n");


    //-----------SORTING NEGATIVE ONE-ELEMENT LISTS-----------
		System.out.println("SORTING NEGATIVE ONE-ELEMENT LISTS");
		data.clear();
		correctData = new int[1];

		temp = (int)(Math.random() * 1000) * -1;
		data.add(temp);
		correctData[0] = temp;

		start = System.currentTimeMillis();
		radixsort(data);
		end = System.currentTimeMillis();

    //Sorts the array
		Arrays.sort(correctData);
		System.out.println("Sort completed in " + (end - start) + " seconds");

    //Checks if data is properly sorted
		hasError = false;
		index = 0;
		for(Integer x: data){
			if(!(x.equals(correctData[index]))){
				System.out.println("THERE IS AN ERROR");
				System.out.println("Index of error: " + index);
				hasError = true;
			}
			index++;
		}

		if(!(hasError)){
			System.out.println("Your LinkedList with one negative element is properly sorted.");
		}
		else{
			System.out.println(data);
		}
	}
	*/
	public static void main(String[] args) {
   MyLinkedListImproved<Integer> list = new MyLinkedListImproved<>();
         list.add(2391);
         list.add(11231);
         list.add(2);
        list.add(2312312);
         list.add(1213);
         list.add(23421);
         list.add(154);
         list.add(1890);
         list.add(1);
         System.out.println(list);
         Sort.radixsort(list);
         System.out.println(list);
          int a = 21393;
          System.out.println(Math.floor(a / Math.pow(10, 5) % 10));
          System.out.println(Integer.toString(a).length());
     }
}