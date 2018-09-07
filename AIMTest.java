package arraysandstring;

import java.util.Arrays;
import java.util.Stack;

public class AIMTest {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = s1.concat(s2.toUpperCase());
		//System.out.println(s1 + s2 + s3);
		//add(5);	//This was for MCQ
		
		
		int []a = {3,5,6,9,12,14,18,20,25,28};
		int []b = {30,32,34,36,38,40,42,44,48,46};
		//mergeArray(a, b, b.length); 		//Prog1 was running well in eclipse Not in Hackerrank
		
		
		String [] input = new String[2];
		input[0] = "{}[]()";
		input[1] = "}]";
		braces(input);			//Prog2		all test cases passed
		
		//Prog 3 directly from my github
		//https://github.com/milanpathak/codepuzzles/blob/master/Assessment.java
		//countPair		12/15 test cases passed
	}
	
	public static void add (int a){
		loop: for(int i=1; i<3; i++){
			for(int j=1; j<3; j++){
				if(a==5){
					break loop;
				}
				System.out.println(i*j);
			}
				
				
		}
	}

	static void mergeArray(int []a, int []b, int M ){
		Arrays.sort(a);
		Arrays.sort(b);
		int []bCopy = Arrays.copyOf(b, b.length);
		b = new int[2*M];
		int aIndex = 0, bIndex = 0;
		for(int i=0; i<2*M; i++){
			if(aIndex<M && bIndex<M && a[aIndex] < bCopy[bIndex]){
				b[i] = a[aIndex];
				aIndex++;
			}else{
				b[i] = bCopy[bIndex];
				bIndex++;
			}
		}
		for(int i=0; i<2*M; i++){
			System.out.print(b[i]+" ");
		}
	}

	static String[] braces(String[] values) {
		String YES = "YES";
		String NO = "NO";
		String [] returnArr = new String[values.length];
		
		
		for(int i=0; i<values.length; i++){
		
			String s = values[i];
			Stack<Character> stack = new Stack<Character>();
			boolean breakNotHappened = true;
			for (char c : s.toCharArray()) {
				if (c == '(')
					stack.push(')');
				else if (c == '{')
					stack.push('}');
				else if (c == '[')
					stack.push(']');
				else if (stack.isEmpty() || stack.pop() != c){
					returnArr[i] = NO;
					breakNotHappened = false;
					break;
				}
			}
			returnArr[i] =  stack.isEmpty() && breakNotHappened ? YES : NO;
		}
		
		
		return returnArr;
	}
}
