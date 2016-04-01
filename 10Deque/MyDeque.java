public class MyDeque<T>{


    private Object[] deck;
    private int start,end,size;

    public MyDeque(){
	deck = new Object[10];
    }

    
    public void resize(){
	Object[] newDeck = new Object[size*2];
	for (int i = 0; i < size; i++){
	    newDeck[i] = deck [i];
	}
	deck = newDeck;
    }

    public void addFirst(T value){
	deck[start-1]=value;
	start --;

    }





}
