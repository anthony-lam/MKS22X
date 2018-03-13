import java.util.*;
public class QuickSelect{
	private int partition ( int [] data, int start, int end){
		int pivot = data[(start+end)/2];
		int pivotIndex = (start+end)/2;
		int small = start;
		int large = end;
		int temp = data [start];
		data[start]=pivot;
		data[pivotIndex]=temp;
		System.out.println(pivot);
		while (small != large-1){
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
		data[small+1]=pivot;
		System.out.println(Arrays.toString(data));
		return small + 1;
	}
	public static void main(String[] args) {
		QuickSelect a = new QuickSelect();
		int[] test = {1,56,4,1,23,54,3,3535,54};
		System.out.println(a.partition(test,0,8));
	}
}