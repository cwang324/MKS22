public class MyLinkedList{

    
    private LNode head;
    private LNode end;
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
	    end = new LNode(value);
	    size++;
	}else{
	    LNode p = head;
	    while (p.getNext()!=null){
		p=p.getNext();
	    }
	    end = new LNode(value);
	    p.setNext(end);
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
    	if (index < 0 || index > size - 1){
    	    throw new IllegalArgumentException();
    	}
    	
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
    	int oldValue = p.getValue();
    	if (p==head){
    		head=p.getNext();
    		
    	}else{
    		p.setNext(p.getNext().getNext());
    		
    	}
    	size--;
    	return oldValue;
    }

    // insert a new element at the specified index, 0 at the front, size() at the end
    public boolean add(int index, int value){
    	if (index < 0 || index > size){
    		throw new IllegalArgumentException("Please enter a valid index.");
    	}
    	LNode p = head;
    	if (head == null || index==0){
    	    head = new LNode(value);
    	    head.setNext(p);
    	    size++;
    	}
    	else{
    		for (int i=0; i < index-1; i++){
    			p=p.getNext();
    		}
	    	LNode nextNode = p.getNext();
	    	p.setNext(new LNode(value));
	    	p.getNext().setNext(nextNode);
	    	size++;
	    	if (index==size()){
	    		end=p.getNext();
	    	}
	    	
    	}
    	return true;
    }
    
    // returns the index of the 1st occurrence of the value in the linked list, -1 if not found
    public int indexOf(int value){
    	int index = -1;
    	LNode p = head;
    	for (int i=0; i<size(); i++){
    		if (p.getValue()==value){
    			return i;
    		}
    		p=p.getNext();
    	}
    	return index;
    }
    
    public static void main (String[] args){

	//    LNode l = new LNode(4);
	MyLinkedList L = new MyLinkedList();
	
	
	L.add(54);
	L.add(23);
	L.add(0, 13);
	System.out.println(L + " " + L.size());
	L.set(0,20);
	System.out.println(L + " " + L.size());
    System.out.println(L.remove(0));
    System.out.println(L + " " + L.size());
    L.add(2,20);
    System.out.println(L + " " + L.size());
//	System.out.println(L);
//	System.out.println(L.indexOf(54));
//	System.out.println(L);

    }



}