import java.util.*;
public class Merge{
    private static void merge (int[] data, int[] temp, int lo, int hi){
	int mid = (lo + hi) /2 +1;
	int start = lo;
	int start2 = mid;
	int l = lo;
	while (start < mid && start2<=hi && l <=hi){
	    System.out.println(Arrays.toString(data));
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
	while (start<mid  && l <=hi){
	    data[l]=temp[start];
	    start++;
	    l++;
	}
	while(start2<=hi && l <=hi){
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
	int mid = (lo+hi/2)+1;
	if (lo>=hi-2){
	    for (int i=0; i<temp.length;i++){
		temp[i]=data[i];
	    }
	    return ;
	}
	msort(temp, data, lo, mid);
	msort(temp, data, mid, hi);
	merge(data, temp, lo, hi);
    }
    public static void main(String[] args) {
	int[] a = {1,3,5,2,4,6,3,5,2,3};
	mergeSort(a);
	System.out.println(Arrays.toString(a));
    }
}
