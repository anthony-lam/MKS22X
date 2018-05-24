public class Location implements Comparable<Location>{
  private int x,y;
  private Location previous;
  private int distance;
  private int soFar =0;
  private boolean aStar;
  public Location(int _x, int _y, Location prev, int distance, boolean aStar){
   x = _x;
   y = _y;
   previous = prev;
   this.distance= distance;
   if (getPrev()!=null){
     soFar = 1 + prev.getSoFar();
   }
   this.aStar=aStar;
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
 public int getTotal(){
  return distance+soFar;
 }
 public int compareTo(Location L){
  if (aStar){
    if (getTotal()-L.getDistance()>0){
     return -1;
   }
   if (getTotal()-L.getDistance()==0){
     return 0;
   }
   return 1;
  }
  else{
   if (distance-L.getDistance()>0){
     return -1;
   }
   if (distance-L.getDistance()==0){
     return 0;
   }
   return 1;
 }
 }
 public String toString(){
   return distance + "";
 }
}
