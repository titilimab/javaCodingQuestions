package myorg.coding.programs;

//Reverse a string using Stack operations

class StackX{
	
	private int maxSize;
	private char stackarray[];
	private int top;
	
	public StackX(int s) {
		maxSize = s;
		stackarray = new char[maxSize];
		top = -1;
		
	}
	
	public void push(char c) {
		stackarray[++top] = c;
		
	}
	
	public char pop() {
		return stackarray[top--];
	}
	
	public long peek() {
		return stackarray[top];
		
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize-1);
	}
	
}

public class StackApp_ReverseString {
	
	public static void main(String args[]) {
		
		StackX theStack = new StackX(6);
		
		String s = "abc de";
		for(int i=0; i<s.length(); i++) {
			theStack.push(s.charAt(i));
		}
		
		while(!theStack.isEmpty()) {
			char value = theStack.pop();
			System.out.print(value);
		}
		System.out.println();
		
	}

}
