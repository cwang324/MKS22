public class Node{

    Coordinate c;
    Node prev;

    public Node(Coordinate c, Node whereFrom){
	this.c = c;
	prev = whereFrom;
    }

    public Node getPrev(){
	return prev;
    }

    public Coordinate getValue(){
	return c;
    }
	


}
