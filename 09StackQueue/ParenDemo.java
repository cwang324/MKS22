import java.util.*;

public class ParenDemo {

	
	public static boolean isValidOpen(char c){
		if (c == '(' || c == '{' || c == '[' || c == '<'){
			return true;
		}
		return false;
	}
	
	public static boolean isValidClose(char c){
		if (c == ')' || c == '}' || c == ']' || c == '>'){
			return true;
		}
		return false;
	}
	
	public static boolean isMatching(String s){
		
		
		// putting input into Linked List
		MyStack<Character> stack = new MyStack<Character>();
		
		try{
		char c;
		for (int i=0; i<s.length(); i++){
			c = s.charAt(i);
			
			if (isValidOpen(c)){
				
				stack.push(c);
				
			}
			else if(stack.isEmpty()){
					return false;
				}
			
			else if (c==')'){
					
				
				if (stack.peek() == '('){
					stack.pop();
					
				}
			}
			else if (c=='}'){
					
				if (stack.peek() == '{'){
					stack.pop();
				}else{
					return false;
				}
				
			}else if (c==']'){
					
					if (stack.peek() == '['){
						stack.pop();
					}else{
						return false;
					}
			}
				
				
				
		}
		}catch(NoSuchElementException e){
		    return false;
		}
				
			return stack.isEmpty();
			
	}
	

			
	
	 public static void main(String[]args){
		 String input = "()()(([[]]))";
		 if(args.length > 0){
		     input = args[0];
		     System.out.println( isMatching(input)); 
		 }else{
		     System.out.println("Usage:"); 
		     System.out.println("java ParenDemo \"text\""); 
		 }
		 
		
	 }
}
