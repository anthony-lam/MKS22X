public class FrontierPQ implements Frontier{
    @SuppressWarnings("unchecked")
    private MyHeap<Location> data = new MyHeap(false);
    public void add(Location next){
       data.add(next);
   }
   public Location next(){
       return data.remove();
   }
   public boolean hasNext(){
       return data.size()>0;
   }
   public String toString(){
    return data.toString();
   }
}
