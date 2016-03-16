public class MyLinkedList{

    
    LNode head;
    int size;
    
    // public MyLinkedList(LNode start){
    // 	this.start=start;
    // 	size = 0;
    // }

    // public MyLinkedList(){
    // 	start = new LNode();
    // }
   
    public String toString(){
	String retString = "[ ";
        LNode current = head;
	
        while (current!=null) {
	    retString += current.getValue();
	    if (current.getNext()!=null){
		retString += ", ";	
	    }
	    current = current.getNext();	
	}
	return retString + " ]";
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
	public void setValue(int newValue){ value = newValue; }
	public void setNext(LNode newNext){ next = newNext; }

	
    }

    public boolean add(int value){
	if (head == null){
	    head = new LNode(value);
	    size++;
	}else{
	    LNode p = head;
	    while (p.getNext()!=null){
		p=p.getNext();
	    }
	    p.setNext(new LNode(value));
	    size++;
	}
	return true;
    }


    // return the number of elements in the list
    public int size(){ return size; }

    
    // get the value of the element at the specified index (0 based)
    public int get (int index){
	if (index < 0 || index > size - 1){
	    throw new IllegalArgumentException();
	}
	LNode p = head;
	while (index>0){
	    p=p.getNext();
	    index--;
	}
	return p.getValue();
    }

    // change the value of the element at the specified index to the newValue,
    // return the old value
    public int set(int index, int newValue){
	LNode p = head;
        for (int i=0; i < index; i++){
	    p=p.getNext();
	}
	int oldValue = p.getValue();
	p.setValue(newValue);
	return oldValue;
    }

    // remove the element at the specified index, returns the value removed
    public int remove(int index){
	LNode p = head;
	for (int i=0; i < index-1; i++){
	    p=p.getNext();
	}
	p.setNext(p.getNext());
	
    }

    public static void main (String[] args){

	//    LNode l = new LNode(4);
	MyLinkedList L = new MyLinkedList();
	System.out.println(L);
	L.add(0);
	L.add(54);
	L.add(-10);
	System.out.println(L.size);
	System.out.println(L.set(2,100));
	System.out.println(L);
    }



}
