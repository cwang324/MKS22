
import java.util.*;
import java.io.*;

public class BetterMaze{
	
    private class Node{
    	
        private int xcor,ycor;
        private Node lastNode;

        public Node(int x, int y, Node last){
            xcor = x;
            ycor = y;
            lastNode = last;
        }

        public int getX(){
            return xcor;
        }

        public int getY(){
            return ycor;
        }

        public Node getLast(){
            return lastNode;
        }

        public String toString(){
            return "X: " + xcor + "  , Y: " + ycor;
        }

    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol,endRow,endCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false
    private boolean solved;

     /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     **/
     public int[] solutionCoordinates(){
        if (solved == false) {
            return new int[1];
        }else{
            return solution;
        }
    }

    public void printSolution(){
        if (solved == true) {
            String retString = "[";
            for (int i = 0; i < solution.length - 1; i++) {
                retString = retString + solution[i] + ",";
            }
            retString = retString + solution[solution.length - 1] + "]"; 
            System.out.println(retString);
        }else{
            System.out.println("[] ");
        }
    }

    private ArrayList<Node> getNeighbors(Node current){
        ArrayList<Node> neighbors = new ArrayList<Node>();
        int x = current.getX();
        int y = current.getY();
        
        // checks surroundings to see if valid move
        
        if (y - 1 >= 0 && maze[y - 1][x] != '.' && maze[y - 1][x] != '#') {
            neighbors.add(new Node(x,y - 1,current));
        }if (y + 1 < maze.length && maze[y + 1][x] != '.' && maze[y + 1][x] != '#') {
            neighbors.add(new Node(x,y + 1,current));
        }if (x - 1 >= 0 && maze[y][x - 1] != '.' && maze[y][x - 1] != '#') {
            neighbors.add(new Node(x - 1,y,current));
        }if (x + 1 < maze[0].length && maze[y][x + 1] != '.' && maze[y][x + 1] != '#') {
            neighbors.add(new Node(x + 1,y,current));
        }
        
        return neighbors;
    }


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        placesToGo = new FrontierQueue<Node>();
        Node current =  new Node(startCol,startRow,null);
        placesToGo.add(current);
        while(!(current.getY() == endRow && current.getX() == endCol)){
          
            maze[current.getY()][current.getX()] = '.';
            for(Node cur : getNeighbors(current) ){ 
                placesToGo.add(cur);
            }
            if (animate) {
                System.out.println(this.toString());  
                wait(5);
            }
            try{
                current = placesToGo.next();
            }catch(NoSuchElementException e){
                return false;
            }
        }

        // Draw correct path

        ArrayList<Node> sols = new ArrayList<Node>();
        while(current != null){
            sols.add(current);
            current = current.getLast();
        }
        int n = 1;
        for (Node cur : sols) {
            if (n == 1) {
                maze[cur.getY()][cur.getX()] = 'E';
                n--;
            }else if (cur.getLast() == null) {
                maze[cur.getY()][cur.getX()] = 'S';
            }else {
                maze[cur.getY()][cur.getX()] = '@';
            }          
        }

        // Change solution int array;
        solution = new int[sols.size() * 2];
        int i = sols.size() * 2;
        for (Node cur : sols) {
            i--;
            solution[i] = cur.getY();
            i--;
            solution[i] = cur.getX();
        }

        solved = true;
        return true;
    }




    public boolean solveDFS(){  
        placesToGo = new FrontierStack<Node>();
        Node current =  new Node(startCol,startRow,null);
        placesToGo.add(current);
        while(!(current.getY() == endRow && current.getX() == endCol)){
            //wait(1);
            maze[current.getY()][current.getX()] = '.';
            for(Node cur : getNeighbors(current) ){ 
                placesToGo.add(cur);
            }
            if (animate) {
                System.out.println(this.toString());  
                wait(5);
            }  
            try{
                current = placesToGo.next();
            }catch(NoSuchElementException e){
                return false;
            }
        }

        // Draw correct path

        ArrayList<Node> sols = new ArrayList<Node>();
        while(current != null){
            sols.add(current);
            current = current.getLast();
        }
        int n = 1;
        for (Node cur : sols) {
            if (n == 1) {
                maze[cur.getY()][cur.getX()] = 'E';
                n--;
            }else if (cur.getLast() == null) {
                maze[cur.getY()][cur.getX()] = 'S';
            }else {
                maze[cur.getY()][cur.getX()] = '@';
            }          
        }

        // Change solution int array;
        solution = new int[sols.size() * 2];
        int i = sols.size() * 2;
        for (Node cur : sols) {
            i--;
            solution[i] = cur.getY();
            i--;
            solution[i] = cur.getX();
        }

        solved = true;
        return false;
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
      private boolean solve(){  
        return solveBFS();
    } 

    /**mutator for the animate variable  **/
    public void setAnimate(boolean b){  
        animate = b;
    }

    public BetterMaze(String filename){
        animate = false;
        int maxc = 0;
        int maxr = 0;
        startRow = -1;
        startCol = -1;
        solved = false;
    //read the whole maze into a single string first
        String ans = "";
        try{
            Scanner in = new Scanner(new File(filename));

        //keep reading next line
            while(in.hasNext()){
                String line = in.nextLine();
                if(maxr == 0){
            //calculate width of the maze
                    maxc = line.length();
                }
        //every new line add 1 to the height of the maze
                maxr++;
                ans += line;
            }
        }
        catch(Exception e){
            System.out.println("File: " + filename + " could not be opened.");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println(maxr+" "+maxc);
        maze = new char[maxr][maxc];
        for(int i = 0; i < ans.length(); i++){
            char c = ans.charAt(i);
            maze[i / maxc][i % maxc] = c;
            if(c == 'S'){
                startCol = i % maxc;
                startRow = i / maxc;
            }else if (c == 'E') {
                endCol = i % maxc;
                endRow = i / maxc;
            }
        }
    }





    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
        System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }


    public String toString(){
        int maxr = maze.length;
        int maxc = maze[0].length;
        String ans = "";
        if(animate){
            ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
        }
        for(int i = 0; i < maxc * maxr; i++){
            if(i % maxc == 0 && i != 0){
                ans += color(37,40) + "\n";
            }
            char c =  maze[i / maxc][i % maxc];
            if(c == '#'){
                ans += color(38,47)+c;
            }else{
                ans += color(33,40)+c;
            }
        }
    //nice animation string
        if(animate){
            return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
        }else{
            return ans + color(37,40) + "\n";
        }
    } 
    

    
    

}
