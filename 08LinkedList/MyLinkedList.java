public class MyLinkedList{

    
    LNode start;
    int size;
    
    public MyLinkedList(LNode start){
	this.start=start;
	size = 0;
    }

    public MyLinkedList(){
	start = new LNode();
    }
   
    public String toString(){
	String retString = "[ ";
        LNode current = start;
        while (current.getNext()!=null) {
	    retString += current.data + ", ";
	    current = current.getNext();
	}
	retString+= " ]";
	return retString;
   }

    public class LNode{
	
	private int value;
	private LNode next;

	public LNode(int value){
	    this.value = value;
	}

	public LNode(){	}

	// accessors
	public int getValue(){ return value; }
	public LNode getNext(){ return next; }

	// mutators
	public void setValue(int newValue){ value = newValue }
	public void setNext(LNode newNext){ next = newNext; }

	
    }

    
    public static void main (String[] args){

	//    LNode l = new LNode(4);
	MyLinkedList L = new MyLinkedList();
	System.out.println(L);
    }



}
