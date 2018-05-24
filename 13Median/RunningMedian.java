public class RunningMedian{
	private MyHeap<Double> big = new MyHeap<>(false);
	private MyHeap<Double> small = new MyHeap<>();
	private Double median;
	public void addValue(Double value){
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
	public Double getMedian(){
		return median;
	}
	public static void main(String[] args) {
		RunningMedian a = new RunningMedian();
		a.addValue(0.03);
		a.addValue(0.33);
		a.addValue(21.03);
		a.addValue(10.03);
		a.addValue(67.03);
		System.out.println(a.getMedian());
	}
}
