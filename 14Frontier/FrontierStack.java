import java.util.*;
public class FrontierStack implements Frontier{
    private LinkedList<Location> data = new LinkedList<>();
    public void add(Location next){
	data.addLast(next);
    }
    public Location next(){
	return data.removeLast();
    }
    public boolean hasNext(){
	return data.size()>0;
    }
}

