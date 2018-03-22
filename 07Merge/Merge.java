import java.util.*;
public class Merge{
    private static void merge (int[] data, int[] temp, int lo, int mid, int hi){
	int start = lo;
	int start2 = mid;
	int l = lo;
	while (start <= mid && start2<=hi){
	    if (temp[start]<temp[start2]){
		data[l] = temp[start];
		start++;
		l++;
	    }
	    else{
		data[l]= temp[start2];
		start2++;
		l++;
	    }
	}
	while (start<=mid ){
	    data[l]=temp[start];
	    start++;
	    l++;
	}
	while(start2<=hi){
	    data[l]=temp[start2];
	    start2++;
	    l++;
	}
    }
    public static void mergeSort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    private static void msort(int[] data, int[] temp, int lo, int hi){
		
	int mid = (lo+hi/2);
	if (lo>=hi-2){
	    return ;
	}
	msort(temp, data, lo, mid);
	msort(temp, data, mid+1, hi);
	merge(data, temp, lo, mid+1, hi);
	for(int i  = lo;i <= hi;i++){
	    temp[i] = data[i];
	}
    }
    public static void main(String[] args) {
	int[] a = {1,3,5,2,4,6};
	mergeSort(a);
	System.out.println(Arrays.toString(a));
    }
}
