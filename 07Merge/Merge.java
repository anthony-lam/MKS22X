import java.util.*;
public class Merge{
    private static void merge (int[] data, int[] temp, int lo, int hi){
	int mid = (lo+hi)/2+1;
	int start = lo;
	int start2 = mid; 
	for (int l=lo; l<=hi; l++){
	    if (start < mid && start2<=hi){
		if (data[start]<data[start2]){
		    temp[l] = data[start];
		    start++;
		}
		else{
		    temp[l]= data[start2];
		    start2++;
		}
	    }
	    else{
		if (start<mid){
		    temp[l]=data[start];
		    start++;
		}
		else{
		    temp[l]=data[start2];
		    start2++;
		}
	    }
	}
	for(int l =lo; l<=hi;l++){
	    data[l]=temp[l];
	}
    }
    public static void mergeSort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    private static void msort(int[] data, int[] temp, int lo, int hi){
	for(int l=lo;l<=hi;l++){
	    temp[l]=data[l];
	}
	int mid = (lo+hi)/2;
	if (hi>lo){
	    msort(temp, data, lo, mid);
	    msort(temp, data, mid+1, hi);
	    merge(data, temp, lo, hi);
	}
    }
    public static void insertionSort(int[] ary,int lo,int hi){
	for(int index=lo;index<=hi;index++){
	    int l=index;
	    while (l>0 && ary[l]<ary[l-1]){
		int temp=ary[l-1];
		ary[l-1]=ary[l];
		ary[l]=temp;
		l--;
	    }
	}
    }
    public static void main(String[] args) {
	int[] a = {9,8,7,6,5,4,3,2,1};
	mergeSort(a);
	System.out.println(Arrays.toString(a));
    }
}
