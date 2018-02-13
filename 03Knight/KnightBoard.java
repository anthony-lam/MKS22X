public class KnightBoard{
	int[][] board;
	public KnightBoard(int startingRows,int startingCols) {
		board= new int[startingRows][startingCols];
	}
//non square is required!

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
			}
		}
		else{
			for (int r=0;r<board.length;r++){
				for (int c=0;c<board[0].length;c++){
					ans=ans+" "+board[r][c];
				}
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

	}
	public int countSolutions(){

	}

	private boolean solveH(int row ,int col, int level){
		
	}
// level is the # of the knight
}