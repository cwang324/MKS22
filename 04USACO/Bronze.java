import java.util.Scanner;
import java.io.*;

public class Bronze {

	private int rows,cols;
    private int[][] pasture;
	    
    public Bronze(int R, int C, int[] elevations){
    	if (		R < 3 || R > 100 
    			||  C < 3 || C > 100){
    		throw new IllegalArgumentException();
    	}
    	rows=R;
    	cols=C;
    	pasture = new int[rows][cols];
    	fillPasture(elevations);
    	
    	
    }

    private void fillPasture(int[] elevations){
    	int i = 0;
    
    	for (int row = 0; row < rows; row++){
    		for (int col=0; col < cols; col++){
    			
    			pasture[row][col] = elevations[i];
    			i++;
    		}
    	}
    }
    
    private void stomp(int R_s, int C_s, int D_s){
    	if (		R_s < 1 || R_s > rows-2 
    			||  C_s < 1 || C_s > cols-2){
    		throw new IllegalArgumentException();
    	}
    	int highestE = pasture[R_s][C_s];
    	
    	for (int row = R_s-1; row < R_s+2; row++){
    		for (int col = C_s-1; col < C_s+2; col++){
    			if (pasture[row][col]>highestE){
    				highestE=pasture[row][col];
    			}
    		}
    	}
    	
    	int lowestE = highestE-D_s;
    	for (int row = R_s-1; row < R_s+2; row++){
    		for (int col = C_s-1; col < C_s+2; col++){
    			if (pasture[row][col]>lowestE){
    				pasture[row][col]=lowestE;
    			}
    		}
    	}
    }
    
    
    private void findDepths(int finalE){
    	for (int row=0; row < rows; row++){
    		for (int col=0; col < cols; col++){
    			if (finalE-pasture[row][col]>0){
    				pasture[row][col]=finalE-pasture[row][col];
    			}else{
    				pasture[row][col]=0;
    			}
    		}
    	}
    }
    
    private int findVolume(){
    	int totalDepth = 0;
    	for (int row=0; row < rows; row++){
    		for (int col=0; col < cols; col++){
    			totalDepth+=pasture[row][col];
    		}
    	}
    	int vol = totalDepth * 72 * 72;
    	return vol;
    	
    }
    
    public void print(){
    	for  ( int i = 0; i < rows; i++)
		{
			for  ( int j = 0; j < cols; j++)
			{
			    
                int cellValue = pasture[i][j];
                
                if ( cellValue >= 10 )
                  System.out.print(cellValue);
                else
                  System.out.print(" " + cellValue);
				
				if ( j < cols)
				   System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
    }
    

    public static void main (String[] args) throws IOException{

		    
		File inFile = new File("makelake.in");

		Scanner sc = new Scanner(inFile);
		
		int numRows = sc.nextInt();
		int numCols = sc.nextInt();
		int finalElevation = sc.nextInt();
		int numInstructions = sc.nextInt();
		
		int numElevations = numRows*numCols;
		int[] elevations = new int[numElevations];
		
		for (int i=0; i<numElevations; i++){
			elevations[i] = sc.nextInt();
		}
		

		Bronze b = new Bronze(numRows,numCols,elevations);
	
		//b.print();
		
		while(numInstructions>0){
			int R_s = sc.nextInt();
			int C_s = sc.nextInt();
			int D_s = sc.nextInt();
			b.stomp(R_s, C_s, D_s);
			numInstructions--;
		}
		
		
	
		
		b.findDepths(finalElevation);
		//b.print();
		System.out.println(b.findVolume()+",6,Wang,Carol");
		sc.close();
    }


}

