public class Merge{
	private static void merge (int[] data, int first, int second, int end){
		int[] temp = new int[end-first+1]; 
		int ct = first;
		int ct2 = second;
		for (int i = first; i <= end; i++){
			if (ct<second && (ct2>end || data[ct] > data[ct2])){
				temp[i-first]=data[ct];
				ct++;
			}
			else{
				temp[i-first]=data[ct2];
			}
		}
		for (int i=0; i< end-first+1;i++){
			data[i+first]=temp[i];
		}
	}
}