public class USACO{
    public static int bronze(String filename){
	File text = new File(filename);
      	Scanner inf = new Scanner(text);
	int r = inf.nextInt();
	int c = inf.nextInt();
	int e = inf.nextInt();
	int n = inf.nextInt();
	int[][] field = new int[r][c];
	for (int row=0; row<r;row++){
	    for (int col=0; col<c; col++){
		field[row][col]=inf.nextInt();
	    }
	}
	while (inf.hasNextLine()){
	    int R_s = inf.nextInt();
	    int C_s = inf.nextInt();
	    int D_s = inf.nextInt();
	}
    }
}
