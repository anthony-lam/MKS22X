public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distance;
    private int soFar =0;
    public Location(int _x, int _y, Location prev, int distance){
	x = _x;
	y = _y;
	previous = prev;
	this.distance= distance;
	if (getPrev()!=null){
	soFar = 1 + prev.getSoFar();
}
    }
    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public Location getPrev(){
	return previous;
    }
    public int getDistance(){
	return distance;
    }
    public int getSoFar(){
	return soFar;
    }
    public int compareTo(Location L){
	if (distance-L.getDistance()>0){
	    return -1;
	}
	if (distance-L.getDistance()==0){
	    return 0;
	}
	return 1;
    }
    public String toString(){
	return distance + "";
    }
}
