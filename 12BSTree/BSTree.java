public class BSTree<T extends Comparable<T>>{

    
    Node root;

    public class Node{

	Node left, right;
	T data;


	public T getData(){
	    return data;
	}

	public void setData(T newData){
	    data=newData;
	}

	public Node getLeft(){
	    return left;
	}

	public void setLeft(Node newLeft){
	    left = newLeft;
	}
	    

	public Node getRight(){
	    return right;
	}

	public void setRight(Node newRight){
	    right = newRight;
	}

	

    }




}
