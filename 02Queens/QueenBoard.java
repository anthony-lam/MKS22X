public class QueenBoard{
    private int[][] board;
    private int sols;
    public QueenBoard(int size){
	board = new int[size][size];
    }
    private void queenChange(int r, int c, int change){
	diagonal(r,c,change);
	row(r,c,change);
	col(r,c,change);
    }
    private void row(int r, int c, int change){
	for (int col=0; col<board.length;col++){
	    if (board[r][col]!=-1){
		board[r][col]=board[r][col]+change;
	    }
	}
    }
    private void col(int r, int c, int change){
	for (int row=0; row<board.length;row++){
	    if (board[row][c]!=-1){
		board[row][c]=board[row][c]+change;
	    }
	}
    }
    private void diagonal (int r, int c, int change){
	int row=r+1;
	int col=c+1;
	while(row>=0&& col>=0&&row<board.length&& col<board.length){
	    if(board[row][col]!=-1){
		board[row][col]=board[row][col]+change;
	    }
	    row+=1;
	    col+=1;
	}
	row=r-1;
	col=c-1;
	while(row>=0&& col>=0&&row<board.length&& col<board.length){
	    if(board[row][col]!=-1){
		board[row][col]=board[row][col]+change;
	    }
	    row-=1;
	    col-=1;
	}
	row=r+1;
	col=c-1;
	while(row>=0&& col>=0&&row<board.length&& col<board.length){
	    if(board[row][col]!=-1){
		board[row][col]=board[row][col]+change;
	    }
	    row+=1;
	    col-=1;
	}
	row=r-1;
	col=c+1;
	while(row>=0&& col>=0&&row<board.length&& col<board.length){
	    if(board[row][col]!=-1){
		board[row][col]=board[row][col]+change;
	    }
	    row-=1;
	    col+=1;
	}
    }
    private boolean addQueen(int r, int c){
	board[r][c]=-1;
	queenChange(r,c,1);
	return true;
    }
    private boolean removeQueen(int r, int c){
	queenChange(r,c,-1);
	board[r][c]=0;
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
		    ans+=board[r][c];
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
	return solveHelp(0);
    }
    public boolean solveHelp(int row){
	if (row>=board.length){
	    return true;
	}
	for (int col=0;col<board.length; col++){
	    if (board[row][col]==0){
		addQueen(row,col);
		if (solveHelp(row+1)){
		    return true;
		}
		removeQueen(row,col);
	    }
	}
	return false;
    }
    public int countSolutions(){
	for (int r=0;r<board.length;r++){
	    for (int c=0;c<board.length;c++){
		if(board[r][c]!=0){
		    throw new IllegalStateException();
		}
	    }
	}
	sols=0;
	countHelp(0);
	return sols;
    }
    public boolean countHelp(int row){
	if (row>=board.length){
	    sols+=1;
	    return true;
	}
        for (int col=0;col<board.length; col++){
	    if (board[row][col]==0){
		addQueen(row,col);
		if (countHelp(row+1)){
		    return true;
		}
		else{
		    removeQueen(row,col);
		}
	    }
	}
	return false;
    }
	
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(10);
	System.out.println(a.countSolutions());
	System.out.println(a);
    }
}
