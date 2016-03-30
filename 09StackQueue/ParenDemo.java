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
				
			return stack.isEmpty();
			
	}
	
//public static boolean isMatching(String s){
//		
//		
//		// putting input into Linked List
//		MyStack<Character> stack = new MyStack<Character>();
//		
//		char c;
//		for (int i=0; i<s.length(); i++){
//			c = s.charAt(i);
//			
//			if (isValidOpen(c)){
//				
//				stack.push(c);
//				
//			}else if (c==')'){
//					
//				if(stack.isEmpty()){
//					return false;
//				}
//				if (stack.pop() != '('){
//					return false;
//				}
//					
//					
//				}else if (c=='}'){
//					
//					if(stack.isEmpty()){
//						return false;
//					}
//					if (stack.pop() != '{'){
//						return false;
//					}
//				}else if (c==']'){
//					
//					if(stack.isEmpty()){
//						return false;
//					}
//					if (stack.pop() != '['){
//						return false;
//					}
//				}
//				
//				
//			}	
//		}
//				
//			return stack.isEmpty();
//			
//	}
	
//	public static boolean isMatchingH(MyStack s, char c){
//		if (s.isEmpty()){
//			return false;
//		}
//		else if (s.peek().equals(c)){
//			s.pop();
//			return true;
//		}
//		else{
//			return false;
//		}
//	}
			
	
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
