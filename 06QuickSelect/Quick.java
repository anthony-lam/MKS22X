import java.util.*;
public class Quick{
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
    private static swap(int[] data, int x, int y){
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }
    private static int partition2 (int [] data, int start, int end){
	int pivotIndex = (int)(Math.random()*(end-start)+start); 
	int pivot = data[pivotIndex];
	int small = start;
	int large = end;
	int i = start;
	swap(data, start, pivotIndex);
	while (i <= large){
	    if (data[i] == pivot){
		i++;
	    }
	    else{
		if (data[i] > pivot){
		    swap(data, i, large);
		    large--;
		}
		else{
		    swap(data, i, small);
		    small++;
		    i++;
		}
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
	int i = end;
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
    public static void quicksort(int[]ary){
	
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Quick.quickselect(arr, 9));
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Quick.partition(arr, 0, arr.length - 1));
        // System.out.println(Arrays.toString(arr));
    }
}
