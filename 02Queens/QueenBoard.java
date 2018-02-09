public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
	board = new int[size][size];
    }
    private boolean addQueen(int r, int c){
	board[r][c]=-1;
	for (int col=c+1; col<board.length; col++){
	    board[r][col]=board[r][col]+1;
	}
	for (int row=r+1; row<board.length; row++){
	    board[row][c]=board[row][c]+1;
	}
	int row=r;
	int col=c;
	while(row<board.length&& col<board.length){
	    board[row][col]=board[row][col]+1;
	    row+=1;
	    col+=1;
	}
	return true;
    }
    private boolean removeQueen(int r, int c){
	board[r][c]=0;
	for (int col=c+1; col<board.length; col++){
	    board[r][col]=board[r][col]-1;
	}
	for (int row=r+1; row<board.length; row++){
	    board[row][c]=board[row][c]-1;
	}
	int row=r;
	int col=c;
	while(row<board.length&& col<board.length){
	    board[row][col]=board[row][col]-1;
	}
	return true;
    }
    public String toString(){
	String ans="";
	for (int r=0; r<board.length; r++){
	    for (int c=0; c<board.length; c++){
		if (board[r][c]==-1){
		    ans+="Q";
		}
		else{
		    ans+="_";
		}
	    }
	    ans+="\n";
	}
	return ans;
    }
    public boolean solve(){
	for (int r=0;r<board.length;r++){
	    for (int c=0;c<board.length;c++){
		if(board[r][c]!=0){
		    throw new IllegalStateException();
		}
	    }
	}
	return true;
    }
    public int countSolutions(){
	for (int r=0;r<board.length;r++){
	    for (int c=0;c<board.length;c++){
		if(board[r][c]!=0){
		    throw new IllegalStateException();
		}
	    }
	}
	return 0;
    }
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	a.addQueen(1,2);
	System.out.println(a);
	a.removeQueen(1,2);
	System.out.println(a);
	a.addQueen(1,2);
	a.addQueen(2,2);
	System.out.println(a);
    }
}
