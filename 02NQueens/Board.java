public class Board{

    int[][] board;

    public Board(int n){
	board = new int[n][n];
    }

    public Board(){
	this(4);
    }

    public String printArray(){
	String retString = "";
	for (int row = 0; row < board.length; row++){
	    for (int col=0; col < board[row].length; col++){
		retString += board[row][col] + " ";  
	    }
	    retString+="\n";
	}
	return retString;
    }

    public void placeQueens(int row, int col){
	if (board[row][col]==0){
	    board[row][col]=1;
	    mark(row,col,-1);
	}
    }

    public void removeQueens(int row, int col){
	if (board[row][col]==1){
	    board[row][col]=0;
	    mark(row,col,1);
	}
    }

    public void mark(int row, int col, int delta){

	// marking horizontally
	for (int c = col; c < board[row].length; c++){
	    board[row][c]+=delta;
	}

	// marking diagonally up
	for (int c = col; c <= board[row].length; c++){
	    int i = 0;
	    board[row-i][c]+=delta;
	    i++;
	}
	

	//marking diagonally down
	for (int c = col; c <= board[row].length; c++){
	    int i = 0;
	    board[row+i][c]+=delta;
	    i++;
	}
	    
	
    }
    
}
