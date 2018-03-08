import java.util.*;
import java.io.*;
public class USACO{
    public static int bronze(String filename){
	int total=0;
	try{
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
	    int numRow = inf.nextInt();
	    int numCol = inf.nextInt();
	    int e = inf.nextInt();
	    int n = inf.nextInt();
	    int[][] field = new int[numRow][numCol];
	    for (int row=0; row<numRow;row++){
		for (int col=0; col<numCol; col++){
		    field[row][col]=inf.nextInt();
		}
	    }
	    while (inf.hasNextLine()){
		int R = inf.nextInt();
		int C = inf.nextInt();
		int D_s = inf.nextInt();
		int max=0;
		for (int r=0; r<3; r++){
		    for (int c=0; c<3; c++){
			if (field[R+r][C+c]>max){
			    max=field[R+r][C+c];
			}
		    }
		}
		int newValue= max-D_s;
		for (int r=0; r<3; r++){
		    for (int c=0; c<3; c++){
			if (field[R+r][C+c]>newValue){
			    field[R+r][C+c]=newValue;
			}
		    }
		}
	    }
	    for (int r=0; r<numRow; r++){
		for (int c=0; c<numCol; c++){
		    if (field[r][c]<e){
			total+=e-field[r][c];
		    }
		}
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("Error");
	}
	return total * 72 * 72;
    }
    public static int silver(String filename){
	try{
	    File text = new File(filename);
	    Scanner inf = new Scanner(text);
	}
	catch(FileNotFoundException e){
	}
	return -1;
    }
}
