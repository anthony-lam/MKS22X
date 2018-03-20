public class Merge{
    private static void merge (int[] data, int[] temp, int lo, int hi){
	int mid = lo/2 + hi/2;
	for (int l=lo; lo<=hi; l++){
	    if (lo < mid && (mid>hi || temp[lo] > temp[mid])){
		data[l] = temp[mid];
	    }
	    else{
		data[l] = temp[lo];
	    }
	}
    }
}
