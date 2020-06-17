import java.io.*; 
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;
import java.util.HashMap; 

// "-1" represents no next greater element
public class next_greater_element {
	public static void main(String[] args) {
		int[] array = {5, 3, 2, 10, 6, 8, 1, 4, 12, 7, 4};
		int[] nextGreaterElement = nextGreaterArray(array);
		for(int i = 0; i < nextGreaterElement.length; i++)
			System.out.println(nextGreaterElement[i]);
	}
	
	private static int[] nextGreaterArray(int[] array) {
		int[] nextList = new int[array.length];
		Stack<Integer> stack = new Stack();
		Map<Integer, Integer> hm = new HashMap();
		
		for (int i = 0; i < array.length; i++)
			hm.put(i, array[i]);
		
		for (int i = 0; i < array.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
				continue;
			}
			else {
				while (!stack.isEmpty() && hm.get(stack.peek()) < array[i]) {
					int idx = stack.pop();
					nextList[idx] = array[i];
				}
				stack.push(i);
			}
		}
		
		while (!stack.isEmpty()) {
			nextList[stack.pop()] = -1;
		}
		
        return nextList;
	}
}
