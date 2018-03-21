import java.util.*;
public class Merge{
	private static void merge (int[] data, int[] temp, int lo, int mid, int hi){
		int start = lo;
		int start2 = mid; 
		for (int l=lo; l<=hi; l++){
			boolean change = true;
			if (start <= mid && start2<=hi){
				if (temp[start]<temp[start2]){
					data[l] = temp[start];
					start++;
				}
				else{
					data[l]= temp[start2];
					start2++;
				}
				change = false;
			}
			if (start<=mid && change){
				data[l]=temp[start];
				start++;
				change=false;
			}
			if (start2<=hi && change){
				data[l]=temp[start2];
				start2++;
			}
		}
	}
	public static void mergeSort(int[] data){
		int[] temp = new int[data.length];
		msort(data,temp,0,data.length-1);
	}
	private static void msort(int[] data, int[] temp, int lo, int hi){
		int mid = lo/2 + hi/2+1;
		if (lo< hi-2){
			msort(temp, data, lo, mid);
			msort(temp, data, mid+1, hi);
			merge(data, temp, lo, mid+1, hi);
		}
	}
	public static void main(String[] args) {
		int[] a = {1,3,5,2,4,6};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}
}
