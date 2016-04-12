import java.util.*;
import java.io.*;

public class BetterMaze{

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false


    public class Node{

	int[] rc;
	Node prev;

	public Node(int r, int c, Node whereFrom){
	    rc[0]=r;
	    rc[1]=c;
	    prev = whereFrom;
	}

	public Node getPrev(){
	    return prev;
	}

	public int getRow(){
	    return rc[0];
	}

	public int getCol(){
	    return rc[1];
	}
   
    }


     public BetterMaze(String filename, boolean ani){
		
		try{
		    File inFile = new File(filename);
		    Scanner sc = new Scanner (inFile);
		    Scanner sc2 = new Scanner(inFile);
		    
		    int numRows = 0;
		    int numCols = 0;
		    while (sc.hasNextLine()){
		    	
		    	if (numRows==0){
		    		numCols = sc.nextLine().length();
		    		numRows++;
		    	}
		    	sc.nextLine();
		    	numRows++;
		    }

		    maze = new char[numRows][numCols];
		
		    String mazeString="";
		    while (sc2.hasNextLine()){
		    	mazeString+=sc2.nextLine();
		    }
		    
		    int i = 0;
		    for (int row=0; row<numRows; row++){
		    	for (int col=0; col<numCols; col++){
		    		char cur = mazeString.charAt(i);
		    		maze[row][col] = cur;
		    		if (cur=='S'){
		    			startRow = row;
		    			startCol = col;
		    		}
		    		i++;
		    	}
		    }
		    
		    if (startRow==0) { startRow = -1;}
		    
		    
		    // if (debug){
		    	
		    	
		    // 	//System.out.println(numRows);
		    // 	//System.out.println(numCols);
		    // 	//System.out.println(mazeString);
		    	
		    // }

		   
		   
		}catch(FileNotFoundException e){
		    System.out.println("File not found");
		}

		animate = ani;
		
	        //COMPLETE CONSTRUCTOR
	    }


   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
        /** IMPLEMENT THIS **/     
	return 
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        placesToGo = new FrontierQueue<Node>(); 
	return solve();

    }   


   /**initialize the frontier as a stack and call solve
    **/ 
    public boolean solveDFS(){  
        placesToGo = new FrontierStack<Node>();
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    public boolean solve(){  
        Node start = new Node(startRow, startCol, null);
	placesToGo.add(start);

	return true;

    }    
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  /** IMPLEMENT THIS **/ }    



}
