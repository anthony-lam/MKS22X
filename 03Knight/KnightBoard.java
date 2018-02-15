public class KnightBoard{
    private int[][] board;
    private int[][] moves = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
    private int sols;
    public KnightBoard(int startingRows,int startingCols) {
	if (startingRows<0 || startingCols<0){
	    throw new IllegalArgumentException();
	}
	board= new int[startingRows][startingCols];
    }
    //non square is required!
    public void mark(int startRow, int startCol, int current){
	board[startRow][startCol]=current;
	for(int i=0;i<8; i++){
	    if (startRow+moves[i][0]<board.length && startCol+moves[i][1]<board[0].length){
		board[startRow+moves[i][0]][startCol+moves[i][1]]=-1;
	    }
	}
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
			ans=ans+" "+board[r][c]+" ";
		    }
		}
		ans+="\n";
	    }
	}
	else{
	    for (int r=0;r<board.length;r++){
		for (int c=0;c<board[0].length;c++){
		    ans=ans+" "+board[r][c];
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
    public boolean solve(){
	return solveH(0,0,1);
    }
    public int countSolutions(){
	sols=0;
	for (int r=0; r<board.length; r++){
	    for (int c=0; c<board[0].length;c++){
		solveH(r,c,1);
	    }
	}
	return sols;
    }
    private boolean countH(int row, int col, int level){
	board[row][col]=level;
	if (level==board.length*board[0].length){
	    sols+=1;
	    return true;
	}
	boolean all = true;
	for(int i=0;i<8;i++){
	    int[] move = moves[i];
	    if (row+moves[i][0]<board.length && col+moves[i][1]<board[0].length&&row+moves[i][0]>-1 && col+moves[i][1]>-1){
		if (board[row+move[0]][col+move[1]]==0){
		    if (solveH(row+move[0], col+move[1], level+1)){
			all|=solveH(row+move[0], col+move[1], level+1);
		    }
		    else{
			board[row+move[0]][col+move[1]]=0;
		    }
		}
	    }
	}
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
		    board[row+move[0]][col+move[1]]=0;				
		}
	    }
	}
	return false;
    }
    // level is the # of the knight
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(6,6);
	System.out.println(a.countSolutions());
	System.out.println(a);
    }
}
