public class BSTree<T extends Comparable<T>>{
	private class Node{
		T data;
		Node left;
		Node right;

		public Node(T d){
			data = d;
		}

		public T getData(){
			return data;
		}

		public void setData(T d){
			data = d;
		}

		public Node getLeft(){
			return left;
		}

		public void setLeft(Node l){
			left = l;
		}

		public Node getRight(){
			return right;
		}

		public void setRight(Node r){
			right = r;
		}

		public int height(){
			return heightHelper(this, 1);
		}

		private int heightHelper(Node n, int h){
			if (n.getLeft() == null && n.getRight() == null) {
				return h;
			}else if (n.getRight() == null) {
				return heightHelper(n.left, h + 1);
			}else if (n.getLeft() == null) {
				return heightHelper(n.right, h + 1);
			}
			int l = heightHelper(n.left, h + 1);
			int r = heightHelper(n.right, h + 1);
			if (l > r) {
				return l;
			}
			return r;
		}

		public void add(T value){
			if (getData() == null) {
				setData(value);
			}else {
				addHelper(value, this);
			}
		}

		private void addHelper(T value, Node current){
			if (value.compareTo(current.getData()) <= 0) {    // duplicates gets added to the left for now 
				if (current.getLeft() == null) {
					current.setLeft(new Node(value));
				}else {
					addHelper(value, current.getLeft());
				}
			}else if (value.compareTo(current.getData()) > 0) {
				if (current.getRight() == null) {
					current.setRight(new Node(value));
				}else {
					addHelper(value, current.getRight());
				}
			}
		}

		public String toString(){
			return data.toString();
		}

		public boolean contains(T value){
			if (getData() == null) {
				return false;
			}else {
				return containsHelper(this, value);
			}
		}

		private boolean containsHelper(Node current, T value){
			if (current.getData().compareTo(value) == 0) {
				return true;
			}
			if (current.getLeft() == null && current.getRight() == null) {
				return false;
			}else if (current.getLeft() == null) {
				return containsHelper(current.getRight(),value);
			}else if (current.getRight() == null) {
				return containsHelper(current.getLeft(),value);
			}else {
				return containsHelper(current.getLeft(),value) || containsHelper(current.getRight(),value);
			}
		}
	}


	private Node root;

	public BSTree(){
		root = new Node(null);
	}

        //OUTER methods here are wrapper methods for the root
	public int getHeight(){
		if (root.getData() == null) {
			return 0;
		}
		return root.height();
	}

	public void add(T value){
		root.add(value);
	}

	public String toString(){
		if (root.getData() == null) {
			return "";
		}else{
			return toStringHelper(root);
		}
	}

	private String toStringHelper(Node current){
		if (current.getLeft() == null && current.getRight() == null) {
			return " " + current.toString() + " _ _";
		}else if (current.getLeft() == null) {
			return " " + current.toString() + " _" + toStringHelper(current.getRight());
		}else if (current.getRight() == null) {
			return " " + current.toString() + toStringHelper(current.getLeft()) + " _";
		}else {
			return " " + current.toString() + toStringHelper(current.getLeft()) + toStringHelper(current.getRight());
		}
	}


	public boolean contains(T value){
		return root.contains(value);
	}
}