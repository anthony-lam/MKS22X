public class MazeSolver{
    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){

    }

    public boolean solve(){ return solve(0); }
    public boolean solve(int mode){
        if (mode == 0){
         frontier = new FrontierQueue();
     }
     else{
        frontier = new FrontierStack();
    }
    frontier.add(maze.getStart());
    while(frontier.hasNext()){
        Location current = frontier.next();
     Location[] neighbors = maze.getNeighbors(current);
     for (int i=0; i<4; i++){
        if (neighbors[i]==maze.getEnd()){
            return true;
        }
        frontier.add(neighbors[i]);
    }
}
return false;
}

public String toString(){
 return maze.toString();
}
}

