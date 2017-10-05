package arraysandstrings;

import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public abstract class LargestNo {

	public static void main(String[] args) {
		Integer [] a = {402,53,108,901,24};
		TreeSet<String> ts = new TreeSet<String>();
		for(int i=0; i<a.length; i++){
			ts.add(a[i].toString());
		}
		Iterator<String> i = ts.descendingIterator();
		while(i.hasNext()){
			System.out.print(i.next()+" ");
		}
	}
}
