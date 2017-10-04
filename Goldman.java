package arraysandstrings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Goldman {

	public static void main(String[] args) {
		int []a = {1,2,3,3,4,4};
		System.out.println(reverseSentence("Hello milan"));
	}
	/**
	 * Checks if there is a pair of ywo numbers from array a[] that sums up to some number k
	 * @param k
	 * @param a
	 * @return the count of such pairs.
	 */
	static int countPairs(int k, int[] a) {
		int count=0;
		Map<Integer,Integer> numsSeen = new HashMap<Integer,Integer>();
		int no=0, pairNo =0;
		for(int i=0; i<a.length; i++){
			no = a[i];
			pairNo = k-no;
			if(numsSeen.containsKey(no)){
				if(no==pairNo){
					int thisCount = numsSeen.get(no)+1;
					count +=thisCount;
					numsSeen.put(no, thisCount);
				}else{
					count++;
				}				
			}else{
				numsSeen.put(pairNo,0);
			}
		}
		
		return count;
    }
	/**
	 * Reverse the letters of every words keeping the words at the same position in the sentence.
	 * @param sentence
	 * @return
	 */
	static String reverseSentence(String sentence) {
		StringBuilder reversedSentence = new StringBuilder();
		StringTokenizer st = new StringTokenizer(sentence);
		while(st.hasMoreTokens()){
			StringBuilder reversedWord = new StringBuilder();
			String word = st.nextToken();
			//System.out.println(word);
			for(int i=word.length()-1; i>=0; i--){
				reversedWord.append(word.charAt(i));
			}
			if(st.hasMoreTokens())
				reversedWord.append(" ");
			reversedSentence.append(reversedWord);
			//System.out.println(reversedWord);
		}
		return reversedSentence.toString();
    }
}
