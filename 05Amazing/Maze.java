

import java.util.*;
import java.io.*;

public class Maze{


	    private char[][]maze;
	    private int startx,starty;
	    private boolean animate;
	    boolean debug = false;

	    /*Constructor loads a maze text file.
	      1. The file contains a rectangular ascii maze, made with the following 4 characters:
	      '#' - locations that cannot be moved onto
	      ' ' - locations that can be moved onto
	      'E' - the location of the goal (only 1 per file)
	      'S' - the location of the start(only 1 per file)
	      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
	      3. When the file is not found, print an error and exit the program.
	    */
	    public Maze(String filename, boolean ani){
		
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
		    			startx = row;
		    			starty = col;
		    		}
		    		i++;
		    	}
		    }
		    
		    if (startx==0) { startx = -1;}
		    
		    
		    if (debug){
		    	
		    	
		    	//System.out.println(numRows);
		    	//System.out.println(numCols);
		    	//System.out.println(mazeString);
		    	
		    }

		   
		   
		}catch(FileNotFoundException e){
		    System.out.println("File not found");
		}

		animate = ani;
		
	        //COMPLETE CONSTRUCTOR
	    }


	    /*Main Solve Function
	      Things to note:
	       When no S is contained in maze, print an error and return false.
	    */
	    public boolean solve(){
	        if(startx < 0){
	            System.out.println("No starting point 'S' found in maze.");
	            return false;
	        }else{
	            maze[startx][starty] = ' ';
	            return solve(startx,starty);
	        }
	    }

	    /*
	      Recursive Solve function:
	      A solved maze has a path marked with '@' from S to E.
	      The S is replaced with '@' but the 'E' is not.
	      Postcondition:
	        Returns true when the maze is solved,
	        Returns false when the maze has no solution.
	        All visited spots that were not part of the solution are changed to '.'
	        All visited spots that are part of the solution are changed to '@'
	    */
	    private boolean solve(int x, int y){
	        
	    	if(animate){
	            System.out.println(this);
	            wait(20);
	        }

	        //COMPLETE SOLVE
	    	if (maze[x][y] == 'E'){
	    		return true;
	    	}
	    		
	    	if(maze[x][y]==' '){
	    		maze[x][y]='@';
	    		if (	(isValidMove(x+1,y) && solve(x+1,y)) ||
		    			(isValidMove(x,y-1) && solve(x,y-1)) ||
		    			(isValidMove(x-1,y) && solve(x-1,y)) ||
		    			(isValidMove(x,y+1) && solve(x,y+1)) ){
	    				return true;
	    		}
	    					
	    	}
	    	
	    	maze[x][y] = '.';
	    	return false;
	    	
	    	
	    			
	         //so it compiles
	    }

	    private boolean isValidMove(int x, int y){
	    	if (maze[x][y]=='#' || maze[x][y]=='@' || maze[x][y]=='.'){
	    		return false;
	    	}
	    	return true;
	    }

	    //FREE STUFF!!! *you should be aware of this*


	    public void clearTerminal(){
	        System.out.println(CLEAR_SCREEN);
	    }

	    public String toString(){
	    	String retString = "";
	    	for (int rows=0; rows < maze.length; rows++){
	    		
	    		for (int cols=0; cols < maze[0].length; cols++){
	    			retString+=maze[rows][cols];
	    			
	    		}
	    		retString+="\n";
	    	}
	    	return retString;
	    	
	    }
	    
	    /*
	    public String toString(){
	        int maxx = maze.length;
	        int maxy = maze[0].length;
	        String ans = "";

	        if(animate){

	            ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";

	        }
	        for(int i = 0; i < maxx * maxy; i++){
	            if(i % maxx == 0 && i != 0){
	                ans += "\n";
	            }
	            char c =  maze[i % maxx][i / maxx];
	            if(c == '#'){
	                ans += color(38,47)+c;
	            }else{
	                ans += color(32,40)+c;
	            }
	        }
	        return HIDE_CURSOR + go(0,0) + ans + "\n" + SHOW_CURSOR + color(37,40);
	    }
	    */


	    //MORE FREE STUFF!!! *you can ignore all of this*

	    //Terminal keycodes to clear the terminal, or hide/show the cursor
	    private static final String CLEAR_SCREEN =  "\033[2J";
	    private static final String HIDE_CURSOR =  "\033[?25l";
	    private static final String SHOW_CURSOR =  "\033[?25h";
	    //terminal specific character to move the cursor
	    private String go(int x,int y){
	        return ("\033[" + x + ";" + y + "H");
	    }

	    private String color(int foreground,int background){
	        return ("\033[0;" + foreground + ";" + background + "m");
	    }

	    private void wait(int millis){
	        try {
	            Thread.sleep(millis);
	        }
	        catch (InterruptedException e) {
	        }
	    }


	    public static void main (String[] args){
	    	
	    	Maze m = new Maze("data.dat", true);
	    	m.solve();
	    	
	    	
	    	if (m.debug){
	    		System.out.println(m.maze.length + "/" + m.maze[0].length);
	    		System.out.println(m.maze[1][1]);
	    		System.out.println(m.startx);
	    		
	    		
	    	}
	    }

	    //END FREE STUFF

	
}
