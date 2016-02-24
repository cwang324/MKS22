

import java.util.ArrayList;
import java.util.List;

public class KnightTour
{

	private static final int CLASSICAL_CHESS_BOARD_SIZE = 8;
	private static final String LEFT_PAREN = "[";
	private static final String RIGHT_PAREN = "]";
	private static final String SEPARATOR = ", ";
	private static final String LINE_FEED = "\n";
	
	
	private int[][] chessBoard;
	private int boardFillCount = 0;
	private int boardSize;
	private StringBuilder sb;
	private boolean oneSolutionFound = false;
	
	/**
	 * Default C'tor
	 */
	public KnightTour(int boardSize)
	{
		this.boardSize = boardSize;
		chessBoard = new int[boardSize][boardSize];
		sb = new StringBuilder( boardSize * boardSize *  5);		
	}
	
	/**
	 * Default C'tor
	 */
	public KnightTour()
	{
		this(CLASSICAL_CHESS_BOARD_SIZE);
	}
	

	/**
	 * 
	 */
	private void printChessBoard ()
	{
		
		for  ( int i = 0; i < boardSize; i++)
		{
			for  ( int j = 0; j < boardSize; j++)
			{
			    
				sb.append(LEFT_PAREN);
				sb.append( String.format("%2d", chessBoard[i][j]));
				sb.append(RIGHT_PAREN);
				
//				if ( i < boardSize -1)
//					   sb.append(SEPARATOR);
			}
			sb.append(LINE_FEED);
		}
		sb.append(LINE_FEED);
		System.out.println ( sb.toString());
		// reset sb content to null
		//sb.
	}
	
    
	
    private void addToPossibleMove(List<Location> locations, Location startLoc,  int delRow, int delCol)
    {
	    Location newLoc = new Location();
	    newLoc.row = startLoc.row + delRow;
	    newLoc.col = startLoc.col + delCol;
	    if ( possibleLoc(newLoc))
	       locations.add(newLoc);
    	
    }
	
	private List<Location> findPossibleMoves(Location  startLoc)
	{
		List<Location> locations = new ArrayList<Location>(8);
		
		// find all 8 locations
		
		// first quadrant
		addToPossibleMove(locations, startLoc, 2, 1);
		addToPossibleMove(locations, startLoc, 1, 2);		
	    
		// second quadrant
		addToPossibleMove(locations, startLoc, -2, 1);
		addToPossibleMove(locations, startLoc, -1, 2);		
		
	    
		// third quadrant	    
		addToPossibleMove(locations, startLoc, 2, -1);
		addToPossibleMove(locations, startLoc, 1, -2);	
	    
		// fourth quadrant	    
		addToPossibleMove(locations, startLoc, -2, -1);
		addToPossibleMove(locations, startLoc, -1, -2);	
    
		return locations;
	}
	
	private boolean possibleLoc(Location loc)
	{			
	    // drop those locations that are outside the chessboard
		// drop those locations that are visited						
		return ! (     loc.row < 0 || loc.col < 0        
				   ||  loc.row > chessBoard.length - 1 ||  loc.col > chessBoard.length - 1 
				   ||  chessBoard[loc.row][loc.col] != 0
				);
	}
	
	
	private boolean isBoardFilled()
	{
		for  ( int i = 0; i < boardSize; i++)
		{
			for  ( int j = 0; j < boardSize; j++)
			{
				if (chessBoard[i][j]==0){
					return false;
				}
			}
		}
		return true;		
	}
	
	public boolean tour(Location startLoc)
	{
		if ( oneSolutionFound)
			return true;
		
		chessBoard[startLoc.row][startLoc.col] = startLoc.nthStep;
		if ( isBoardFilled())
		{
			System.out.println("Yeah! we are done");
			printChessBoard();
			oneSolutionFound = true;
			return true;
		}
		
        // ok more tour to go
    
		List<Location> moves = findPossibleMoves(startLoc);
//		int numberOfMoves = moves.size();
//		if ( numberOfMoves == 0 )
//		{
//			chessBoard[startLoc.row][startLoc.col] = 0;
//			return false;
//		}
		
        int moveCount = 0;		
		for ( Location move: moves)
		{
			move.nthStep = startLoc.nthStep+1;
	
			if ( tour(move) )
			{
			   moveCount++;
			}
			
		}
		
		if ( moveCount <= 0 ) 
		{	
			chessBoard[startLoc.row][startLoc.col] = 0;
			return false;			
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) 
	{
		KnightTour kt = new KnightTour(6);
		
//		int row = Math.random() * 8
//		int col = Math.random() * 8;
		int nthStep = 1;
		int row = 2;
		int col = 3;
		Location startLoc = new Location(row, col, nthStep);

		// wish you luck!
		boolean tourResult = kt.tour(startLoc);
		
	}
}

class Location
{
	int row;
	int col;
	int nthStep;
	

	public Location()
	{
	}

	public Location(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public Location(int row, int col, int nthStep)
	{
		this.row = row;
		this.col = col;
		this.nthStep = nthStep;
	}
	
	
}




