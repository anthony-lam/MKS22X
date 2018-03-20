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
	private static void swap(int[] data, int x, int y){
		int temp = data[x];
		data[x] = data[y];
		data[y] = temp;
	}
	public static int dutchPartition(int[] data, int start, int end){
		int pivotIndex = (int)(Math.random()*(end-start)+start);
		int pivot = data[pivotIndex];
		int small = start;
		int large = end;
		int i = start;
		int lt = start;
		int gt = end;

		swap(data,start,pivotIndex);

		while (i <= gt){
			if(data[i] == pivot){
				i++;
			}
			else{
				if(data[i] < pivot){
					swap(data,lt,i);
					lt++;
					i++;
				}
				if(data[i] > pivot){
					swap(data,gt,i);
					gt--;
				}
			}
		}
		return lt;	
	}
	/*
	public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
		int start = 0;
		int end = data.length;
		int[] i = dutchPartition(data,start,end);
		k-=1;
		while (!(k >= i[0] && k<= i[1])){
			if (i[0]>k){
				end = i[0] ; 
				i = dutchPartition(data, start, end);
			}
			else{
				start = i[1];
				i = dutchPartition(data, start, end);
			}
		}
		return data[i[0]];
	}
	*/
	public static void quicksort(int[] data){
		quicksortH(data, 0, data.length-1);
	}

	private static void quicksortH(int[] data, int start, int end){
		int lt = start;
		int gt = end;
		int i = start;
		int pivotIndex = (int)(Math.random()*(end-start)+start);
		int pivot = data[pivotIndex];
		while(i <= gt){
			if(data[i] < pivot){
				swap(data, i, lt);
				i++;
				lt++;
			} else if(data[i] > pivot){
				swap(data, i, gt);
				gt--;
			} else {
				i++;
			}
		}

		if(end - start >= 2){
			quicksortH(data, start, lt);
			quicksortH(data, gt, end);
		}
	}
	public static void main(String[] args) {
		int[] arr = {1,23423,33,42,523,65,73,2,9};
		quicksort(arr);
		System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Quick.partition(arr, 0, arr.length - 1));
        // System.out.println(Arrays.toString(arr));
	}
}
