import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
    private char[][]maze;
    private boolean animate;//false by default
    private int[][] moves = {{0,1},{0,-1},{1,0}, {-1,0}};
    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.

    */

    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
	File text = new File(filename);
        Scanner inf = new Scanner(text);
	int rows=0;
	int cols=0;
	while(inf.hasNextLine()){
	    rows+=1;
	    String line = inf.nextLine();
	    cols=line.length();
	}
	Scanner read = new Scanner(text);
	maze= new char[rows][cols];
	int currentRow=0;
	for (int r=0;r<rows;r++){
	    String line=read.nextLine();
	    for (int c=0;c<cols;c++){
		maze[r][c]=line.charAt(c);
	    }
	}
	int start=0;
	int end=0;
	for (int row=0; row<maze.length; row++){
	    for (int col=0; col<maze[0].length; col++){
		if (maze[row][col]=='S'){
		    start+=1;
		}
		if (maze[row][col]=='E'){
		    end+=1;
		}
	    }
	}
	if (start!=1 || end!=1){
	    throw new IllegalStateException();
	}
    }
    

    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public void setAnimate(boolean b){
        animate = b;
    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
	int row=-1;
	int col=-1;
	for (int r=0; r< maze.length; r++){
	    for (int c=0; c<maze.length; c++){
		if (maze[r][c]=='S'){
		    row=r;
		    col=c;
		}
	    }
	}
	maze[row][col]=' ';
	return solve(row,col,1);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

      The S is replaced with '@' but the 'E' is not.

      All visited spots that were not part of the solution are changed to '.'

      Note: This is not required based on the algorithm, it is just nice visually to see.
      All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int move){ //you can add more parameters since this is private
	if (maze[row][col]=='E'){
	    return move;
	}
        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(100);
        }
	maze[row][col]='@';
	for (int l=0;l<4;l++){
	    if (row+moves[l][0]<maze.length && col+moves[l][1]<maze[0].length &&( maze[row+moves[l][0]][col+moves[l][1]]==' '||maze[row+moves[l][0]][col+moves[l][1]]=='E') && solve(row+moves[l][0], col+moves[l][1], move+1)!= -1){
		return solve(row+moves[l][0], col+moves[l][1], move+1);
	    }
	}
	maze[row][col]='.';
        //COMPLETE SOLVE

        return -1; //so it compiles
    }
    public String toString(){
	String ans="";
	for (int r=0;r<maze.length;r++){
	    for (int c=0;c<maze[0].length;c++){
		ans+=maze[r][c];
	    }
	    ans+="\n";
	}
	return ans;
    }
    public static void main(String[] args){
	try{
	    Maze a = new Maze("data1.dat");
	    a.setAnimate(true);
	    System.out.println(a);
	    System.out.println(a.solve());
	    System.out.println(a);
	}
	catch(FileNotFoundException e){
	    System.out.println("Error");
	}
    }
}
