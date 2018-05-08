import java.util.*;
public class FrontierQueue implements Frontier{
    private LinkedList<Location> data = new LinkedList<>();
    public void add(Location next){
	data.addLast(next);
    }
    public Location next(){
	return data.removeFirst();
    }
    public boolean hasNext(){
	return data.size()>0;
    }
}
