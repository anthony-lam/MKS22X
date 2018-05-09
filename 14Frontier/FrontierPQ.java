public class FrontierPQ implements Frontier{
    private MyHeap<Location> data = new MyHeap(true);
    public void add(Location next){
	data.add(next);
    }
    public Location next(){
	return data.remove();
    }
    public boolean hasNext(){
	return data.size()>0;
    }
}
