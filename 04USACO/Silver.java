import java.io.*;
import java.util.Scanner;

public class Silver {
	
	private int[][] pasture;
	private int R1, C1, endx, endy, movingTime, numRows, numCols,solution;
	private boolean debug = true;
	private Scanner sc;

	
	public Silver(){
		
		try{
			File inFile = new File("ctravel.in");
			sc = new Scanner(inFile);
		}catch(FileNotFoundException e){
			System.out.println("File not found.");
			}
			
				
			numRows = Integer.parseInt(sc.next());
			numCols = Integer.parseInt(sc.next());
			movingTime = Integer.parseInt(sc.next());
			
			pasture = new int[numRows][numCols];
			
			String input="";
			int rows = numRows;
			while (rows>=0){
		    	input+=sc.nextLine();
		    	rows--;;
			}
				
			
			int i = 0;
		    for (int row=0; row<numRows; row++){
		    	for (int col=0; col<numCols; col++){
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
		    
		    pasture[R1][C1]=1;
		    
			if (debug){
				System.out.println(numRows + " " + numCols);
				System.out.println(input + " " + input.length());
				System.out.println(R1 + " " + C1 + " " + endx + " " + endy);
			}
			
		
	}
		
		 public String toString(){
   			 String retString = "";
     		   	for (int rows=0; rows < numRows; rows++){
			    		
			  		for (int cols=0; cols < numCols; cols++){
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
			  				
			  				if (pasture[rows][cols]>=0){
			  					int sum = 0;
			  					if(cols - 1 >= 0 && pasture[rows][cols - 1] > 0){
									sum = sum + pasture[rows][cols - 1];
								}
								if(cols + 1 < cols && pasture[rows][cols + 1] > 0){
									sum = sum + pasture[rows][cols + 1];
								}
								if(rows - 1 >= 0 && pasture[rows - 1][cols] > 0){
									sum = sum + pasture[rows - 1][cols];
								}
								if(rows + 1 < rows && pasture[rows + 1][cols] > 0){
									sum = sum + pasture[rows + 1][cols];
								}
								newPasture[rows][cols] = sum;
							}else{
								newPasture[rows][cols] = -1;
							}
//			  					newPasture[rows][cols]= add(rows-1,cols) + add(rows, cols-1) 
//			    									+ add(rows+1,cols) + add(rows, cols+1);
//			  					
////			  				}else if (pasture[rows][cols]>0){
////				  				newPasture[rows][cols]=0;
//			  				}else{
//			  					newPasture[rows][cols]=-1;
//			  				}
			  				
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
		 

		 
		private boolean solve(){
			while(movingTime>0){
				
				 int[][] newPasture = new int[numRows][numCols]; 
				 
				 for (int rows=0; rows < numRows; rows++){
			    		
				  		for (int cols=0; cols < numCols; cols++){
				  				
				  				if (pasture[rows][cols]>=0){
				  					int sum = 0;
				  					
				  					// add from the left
				  					if(cols - 1 >= 0 && pasture[rows][cols - 1] > 0){
										sum += pasture[rows][cols - 1];
									}
				  					
				  					// add from the right
									if(cols + 1 < cols && pasture[rows][cols + 1] > 0){
										sum +=  pasture[rows][cols + 1];
									}
									
									// add from the top
									if(rows - 1 >= 0 && pasture[rows - 1][cols] > 0){
										sum += pasture[rows - 1][cols];
									}
									
									// add from the bottom
									if(rows + 1 < rows && pasture[rows + 1][cols] > 0){
										sum +=  pasture[rows + 1][cols];
									}
									newPasture[rows][cols] = sum;
								}else{
									newPasture[rows][cols] = -1;
								}
//				  					newPasture[rows][cols]= add(rows-1,cols) + add(rows, cols-1) 
//				    									+ add(rows+1,cols) + add(rows, cols+1);
//				  					
////				  				}else if (pasture[rows][cols]>0){
////					  				newPasture[rows][cols]=0;
//				  				}else{
//				  					newPasture[rows][cols]=-1;
//				  				}
				  				
				  				//System.out.println(newPasture[rows][cols]);
		  				}				  				
				   }
				 
				 pasture = newPasture;
				 movingTime = movingTime-1;
				 System.out.println(this);
			}	
			solution = pasture[endx][endy];
			System.out.println(solution);
			return true;
		}
		 
		public static void main(String[] args){
		
			Silver s = new Silver();
			
			
			
			
			if (s.debug){
				
				System.out.println(s);
				//s.start();
				
//				System.out.println(s);
//				s.changeState();
//				
//				System.out.println(s);
//				s.changeState();
//				
//				System.out.println(s);
//				s.changeState();
//				
//				System.out.println(s);
//				s.changeState();
//				
//				System.out.println(s);
//				s.changeState();
//				
//				System.out.println(s);
//				s.changeState();
//				
//				System.out.println(s);
//				s.changeState();
				s.solve();
				
				
			}
		}
		
}

