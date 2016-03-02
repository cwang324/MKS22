import java.io.*;
import java.util.Scanner;

public class Silver {
	
	private int[][] pasture;
	private int R1, C1, endx, endy, movingTime;
	private boolean debug = true;

	
	public Silver(String filename){
		
		try{
			File inFile = new File(filename);
			Scanner sc = new Scanner(inFile);
		
			
				
			int numRows = Integer.parseInt(sc.next());
			int numCols = Integer.parseInt(sc.next());
			movingTime = Integer.parseInt(sc.next());
			
			pasture = new int[numRows][numCols];
			
			String input="";
			while (numRows>=0){
		    	input+=sc.nextLine();
		    	numRows--;;
			}
				
			
			int i = 0;
		    for (int row=0; row<pasture.length; row++){
		    	for (int col=0; col<pasture[0].length; col++){
		    		char cur = input.charAt(i);
		    		
		    		if (cur=='.'){
		    			pasture[row][col] = 0;
		    		}else{
		    			pasture[row][col] = -1;
		    		}
		    		i++;
		    	}
		    }
		    
		    R1 = Integer.parseInt(sc.next())-1;
		    C1 = Integer.parseInt(sc.next())-1;
		    endx = Integer.parseInt(sc.next())-1;
		    endy = Integer.parseInt(sc.next())-1;
		    
			if (debug){
				System.out.println(numRows + " " + numCols);
				System.out.println(input + " " + input.length());
				System.out.println(R1 + " " + C1 + " " + endx + " " + endy);
			}
			
		}catch(FileNotFoundException e){
			System.out.println("File not found.");
			}
	}
		
		 public String toString(){
   			 String retString = "";
     		   	for (int rows=0; rows < pasture.length; rows++){
			    		
			  		for (int cols=0; cols < pasture[0].length; cols++){
			    		retString+=pasture[rows][cols]+"\t";
			    			
		    		}
			     		retString+="\n";
		     	}
		     	return retString;
		 }
		 
		 private void changeState(){
			 
			 int[][] newPasture = new int[pasture.length][pasture[0].length];
			 
			 
			 for (int rows=0; rows < pasture.length; rows++){
		    		
			  		for (int cols=0; cols < pasture[0].length; cols++){
			  				
			  				if (pasture[rows][cols]==0){
			  					newPasture[rows][cols]= add(rows-1,cols) + add(rows, cols-1) 
			    									+ add(rows+1,cols) + add(rows, cols+1);
			  					
			  				}else if (pasture[rows][cols]>0){
				  				newPasture[rows][cols]=0;
			  				}else{
			  					newPasture[rows][cols]=-1;
			  				}
			  				
			  				//System.out.println(newPasture[rows][cols]);
	  				}				  				
			   }
			 
			 pasture = newPasture;
			 
			 }	
		 
		 
		 
			 
		 
	
		 
		 private int add(int row, int col){
			 if ( (	row<0 || row>=pasture.length 
					 || col<0 || col>=pasture.length
					 || pasture[row][col] < 0)){
				 return 0;
			 }
			 return pasture[row][col];
		 }
		 
		private void start(){
			
			if (!(R1<1 )){
				if (pasture[R1-1][C1]!=-1){
					pasture[R1-1][C1]=1;
				}
			}
			
			if (!(C1<1)){
				if( pasture[R1][C1-1]!=-1 ){
					pasture[R1][C1-1]=1;
				}
			}
			
			if (!(R1>pasture.length-1)){
				if (pasture[R1+1][C1]!=-1){
					pasture[R1+1][C1]=1;
				}
			}
			
			if (!(C1>pasture[R1].length-1)){
				if (pasture[R1][C1+1]!=-1){
					pasture[R1][C1+1]=1;
				}
			}
			 
		}
		 
		private int solve(int T){
			if(T==0){
				return pasture[endx][endy];
			}else{
				changeState();
				return solve(T-1);
			}
		}
		 
		public static void main(String[] args){
		
			Silver s = new Silver("ctravel.in");
			
			
			
			
			if (s.debug){
				
				System.out.println(s);
				s.start();
				
				System.out.println(s);
				s.changeState();
				
				System.out.println(s);
				s.changeState();
				
				System.out.println(s);
				s.changeState();
				
				System.out.println(s);
				s.changeState();
				
				System.out.println(s);
				s.changeState();
				
				System.out.println(s);
				s.changeState();
				
				System.out.println(s);
				s.changeState();
				//System.out.println(s.solve(s.movingTime));
				
				
			}
		}
		
}

