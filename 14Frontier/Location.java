public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distance;
    public Location(int _x, int _y, Location prev, int distance){
        x = _x;
        y = _y;
        previous = prev;
        this.distance= distance;
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
   public int compareTo(Location L){
    System.out.println(this);
    System.out.println(L);
    return this.getDistance() - L.getDistance();
   }
   public static void main(String[] args) {
     Location a = new Location(4, 7, null, 4);
     Location b = new Location(4, 7, null, 8);
     System.out.println(a.compareTo(b));
   }
}
