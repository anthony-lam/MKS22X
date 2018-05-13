public class MazeSolver{
    private Maze maze = new Maze("data3.dat");
    private Frontier frontier;
    private boolean animate = true;
    public MazeSolver(String mazeText){
        maze = new Maze(mazeText);
    }
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
      	System.out.println("\033[2J\033[1;1H");
    }
    public boolean solve(){ return solve(0); }
    public boolean solve(int mode){
        if (mode == 0){
	    frontier = new FrontierQueue();
	}
	if (mode == 1){
	    frontier = new FrontierStack();
	}
	if (mode == 2){
	    frontier = new FrontierPQ();
	}
	frontier.add(maze.getStart());
	while(frontier.hasNext()){
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(100);
        }
	    Location current = frontier.next();
	    Location[] neighbors = maze.getNeighbors(current);
	    for (int i=0; i<4; i++){
		if (neighbors[i]!=null){
		    if (neighbors[i].getX()==maze.getEnd().getX() && neighbors[i].getY()==maze.getEnd().getY()){
			while(current.getPrev()!=null){
			    maze.set(current.getX(),current.getY(), '@');
                current= current.getPrev();
			}
			return true;
		    }
		    frontier.add(neighbors[i]);
		}
	    }
	}
	return false;
    }
    public String toString(){
	return maze.toString();
    }
    private void wait(int millis){
      	try {
	    Thread.sleep(millis);
      	}
      	catch (InterruptedException e) {
      	}
    }

    public static void main(String[] args){
	MazeSolver a = new MazeSolver("data2.dat");
	a.solve(2);
    System.out.println(a);
    }
}

