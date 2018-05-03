public class RunningMedians{
	private MyHeap<Integer> big = new MyHeap<>(false);
	private MyHeap<Integer> small = new MyHeap<>();
	private int median;
	public void addValue(int value){
		if(big.size() == 0 && small.size() == 0){
			median = value;
			small.add(value);
			return;
		}
		if(value <= median){
			small.add(value);
		} else {
			big.add(value);
		}
		if(big.size() - small.size() == 1){
			median = big.peek();
			return;
		}
		if(big.size() - small.size() == -1){
			median = small.peek();
			return;
		}
		if(big.size() - small.size() == 2){
			small.add(big.remove());
		}
		if(big.size() - small.size() == -2){
			big.add(small.remove());
		}
		median = (big.peek() + small.peek()) / 2;
	}
	public int getMedian(){
		return median;
	}
}