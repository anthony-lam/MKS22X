import java.util.*;
public class QuickSelect{
	private static int partition (int [] data, int start, int end){
		int pivotIndex = (int)(Math.random()*(end-start)+start); 
		int pivot = data[pivotIndex];
		int small = start;
		int large = end;
		int temp = data [start];
		data[start]=pivot;
		data[pivotIndex]=temp;
		while (small <= large){
			if (data[small] > pivot){
				temp = data[large];
				data[large] = data[small];
				data[small] = temp;
				large-=1;
			}
			else{
				small+=1;
			}
		}
		temp = data[large];
		data[large]=pivot;
		data[start]=temp;
		return large;
	}
	public static int quickselect(int []data, int k){
  //return the value that is the kth smallest value of the array. 
  //use your partition method to help you accomplish this.
		int start = 0;
		int end = data.length-1;
		int i = partition(data,start,end);
		while (i!=k-1){
			if (i>k-1){
				end = i ; 
				i = partition(data, start, end);
			}
			else{
				start = i;
				i = partition(data, start, end);
			}
		}
		System.out.println(Arrays.toString(data));
		return data[i];
	}
	public static void main(String[] args) {
		QuickSelect a = new QuickSelect();
		int[] test = {1,56,4,1,23,54,3,3535,54};
		System.out.println(a.quickselect(test,4));
	}
}