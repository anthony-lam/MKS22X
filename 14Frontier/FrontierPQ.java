public class FrontierPQ implements Frontier{
    @SuppressWarnings("unchecked")
    private MyHeap<Location> data = new MyHeap(false);
    public void add(Location next){
       data.add(next);
   }
   public Location next(){
        System.out.println(data);
       return data.remove();
   }
   public boolean hasNext(){
       return data.size()>0;
   }
}
