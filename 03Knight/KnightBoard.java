public class KnightBoard{
	private int[][] board;
	private int[][] moves = {{1,2},{1,-2},{2,1},{2,-1},{-1,2},{-1,-2},{-2,1},{-2,-1}};
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
		return 0;
	}

	private boolean solveH(int row ,int col, int level){
		if (level==board.length*board[0].length){
			return true;
		}
		for(int i=0;i<8;i++){
			int[] move = moves[i];
			if (row+moves[i][0]<board.length && col+moves[i][1]<board[0].length&&row+moves[i][0]>-1 && col+moves[i][1]>-1){
				if (board[row+move[0]][col+move[1]]==0){
					board[row+move[0]][col+move[1]]=level;
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
		KnightBoard a = new KnightBoard(7,7);
		a.solve();
		System.out.println(a);
	}
}
