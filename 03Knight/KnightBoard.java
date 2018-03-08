public class KnightBoard{
	private int[][] board;
	private int[][] moves = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
	public KnightBoard(int startingRows,int startingCols) {
		if (startingRows<0 || startingCols<0){
			throw new IllegalArgumentException();
		}
		board= new int[startingRows][startingCols];
	}
	public String toString(){
		String ans="";
		if (containsDouble()){
			for (int r=0;r<board.length;r++){
				for (int c=0;c<board[0].length;c++){
					if (board[r][c]>9){
						ans=ans+board[r][c]+" ";
					}
					else{
						if (board[r][c]==0){
							ans=ans+" "+ "_"+" ";
						}
						else{
							ans=ans+" "+board[r][c]+" ";
						}
					}
				}
				ans+="\n";
			}
		}
		else{
			for (int r=0;r<board.length;r++){
				for (int c=0;c<board[0].length;c++){
					if (board[r][c]==0){
						ans=ans+" "+ "_";
					}
					else{
						ans=ans+" "+board[r][c];
					}
				}
				ans+="\n";
			}
		}
		return ans;
	}
	public boolean containsDouble(){
		for (int r=0;r<board.length;r++){
			for (int c=0;c<board[0].length;c++){
				if (board[r][c]>9){
					return true;
				}
			}
		}
		return false;
	}
	public boolean solve(int row, int col){
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != 0) throw new IllegalStateException();
			}
		}
		if (row > board.length || col > board[0].length || row < 0|| col < 0) throw new IllegalArgumentException();
		return solveH(row,col,1);
	}
	public int countSolutions(int row, int col){
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c] != 0) throw new IllegalStateException();
			}
		}
		if (row > board.length || col > board[0].length || row < 0|| col < 0) throw new IllegalArgumentException();
		return countH(row,col,1);
	}
	private int countH(int row, int col, int level){
		board[row][col]=level;
		if (level==board.length*board[0].length){
			board[row][col]=0;
			return 1;
		}
		int all = 0;
		for(int i=0;i<8;i++){
			if (row+moves[i][0]<board.length && col+moves[i][1]<board[0].length&&row+moves[i][0]>-1 && col+moves[i][1]>-1 && board[row+moves[i][0]][col+moves[i][1]]==0){
				all += countH(row+moves[i][0], col+moves[i][1], level+1);
			}
		}
		board[row][col]=0;
		return all;
	}
	private boolean solveH(int row ,int col, int level){
		board[row][col]=level;
		if (level==board.length*board[0].length){
			return true;
		}
		for(int i=0;i<8;i++){
			int[] move = moves[i];
			if (row+moves[i][0]<board.length && col+moves[i][1]<board[0].length&&row+moves[i][0]>-1 && col+moves[i][1]>-1){
				if (board[row+move[0]][col+move[1]]==0){
					if (solveH(row+move[0], col+move[1], level+1)){
						return true;
					}				
				}
			}
		}
					board[row][col]=0;
		return false;
	}
    // level is the # of the knight
	public static void main(String[] args){
		KnightBoard a = new KnightBoard(3,3);

		System.out.println(a);
    /* Prints
      _ _ _
      _ _ _
      _ _ _
    */

      for (int i = 0; i < 3; i++){
      	for (int j = 0; j < 3; j++){
      		if (a.solve(i,j)){
      			System.out.println("There is an error with your solve method");
      		}
      	}
    } //prints nothing

    System.out.println(a.countSolutions(0,0)); //prints 0



    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b.solve(0,0)); //prints true
    System.out.println(b); //prints a valid solution

    try{
    	b.solve(0,0);
    }catch(IllegalStateException e){
    	System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
    	b.countSolutions(0,0);
    }catch(IllegalStateException e){
    	System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
    	KnightBoard b1 = new KnightBoard(-1,0);
    }catch(IllegalArgumentException e){
    	System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
    	KnightBoard b1 = new KnightBoard(1,-1);
    }catch(IllegalArgumentException e){
    	System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
    	KnightBoard b1 = new KnightBoard(-1,-1);
    }catch(IllegalArgumentException e){
    	System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
    	KnightBoard b1 = new KnightBoard(5,5);
    	b1.solve(0,-1);
    }catch(IllegalArgumentException e){
    	System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
    	KnightBoard b1 = new KnightBoard(5,5);
    	b1.solve(-1,0);
    }catch(IllegalArgumentException e){
    	System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
    	KnightBoard b1 = new KnightBoard(5,5);
    	b1.solve(-1,-1);
    }catch(IllegalArgumentException e){
    	System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"



    for (int i = 0; i < 5; i++){
    	for (int j = 0; j < 5; j++){
    		KnightBoard abc = new KnightBoard(5,5);
        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
    }
}
KnightBoard c = new KnightBoard(5,5);

int totalSol = 0;
for (int i = 0; i < 5; i++){
	for (int j = 0; j < 5; j++){
		totalSol += c.countSolutions(i,j);
	}
}

    System.out.println(totalSol); //prints 1728

    KnightBoard d = new KnightBoard(5,5);
    System.out.println(d.countSolutions(0,0)); //prints 304
}
}
