public class Recursion implements hw01{

    public String name(){
	return "Wang,Carol";
    }

    public double sqrt(double n){
	return sqrtHelp(n,1);	
    }

    public double sqrtHelp(double n, double guess){
	while (!isCloseEnough(n,guess)){
	    guess = (n/guess + guess)/2;
	    sqrtHelp(n, guess);
	}
	return guess;
    }

    private boolean isCloseEnough(int n, int guess){
	double pDiff = Math.abs(guess-n*n)/n;
	if (pDiff <= .0001){
	    return true;
	}
	return false;
    }



}
