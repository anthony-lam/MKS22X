public class Merge{
    private static void merge (int[] data, int[] temp, int lo, int mid, int hi){
	for (int l=lo; lo<=hi; l++){
	    if (lo < mid && (mid>hi || temp[lo] > temp[mid])){
		data[l] = temp[mid];
	    }
	    else{
		data[l] = temp[lo];
	    }
	}
    }
    public static void mergeSort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    private static void msort(int[] data, int[] temp, int lo, int hi){
	if (lo != hi){
	    mid = lo/2 + hi/2;
	    msort(temp, data, lo, mid);
	    msort(temp, data, mid+1, hi);
	}
	merge(data, temp, lo, mid, high);
    }
    
}
