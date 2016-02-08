public class Recursion implements hw01{

    public String name(){
	return "Wang,Carol";
    }

    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	return sqrtHelp(n,1);	
    }

    public double sqrtHelp(double n, double guess){
        if (isCloseEnough(n,guess)){
	    return guess;
	}
	else{
	    double newGuess = (n/guess + guess)/2;
	    return sqrtHelp(n, newGuess);
	}
    }

    private boolean isCloseEnough(double n,double guess){
	if (n==0 & guess==0){
	    return true;
	}
	if (n==0){
	    return isCloseEnough(guess,n);
	}
	double pDiff = Math.abs(n/guess - guess)/n;
        return pDiff < 0.00001;
    }



}
