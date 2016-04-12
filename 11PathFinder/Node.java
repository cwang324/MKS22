public class Node{

    int rc;
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
