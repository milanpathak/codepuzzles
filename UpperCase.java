package arraysandstrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Below program converts first letter of every word to uppercase.
 * @author milan
 *
 */
public class UpperCase {

	public static void main(String[] args) {
		 String thisLine = null;
		 int []ascii = new int[26];
		 boolean match = false;
		 
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    try {
				thisLine  = br.readLine().toLowerCase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    thisLine = thisLine.replace('_', ' ');
		    StringTokenizer input = new StringTokenizer(thisLine);
		    StringBuffer sb = new StringBuffer();
		    String temp;
		    char tempChar;
		    int tempInt;
		    while(input.hasMoreTokens()){
		    	temp = input.nextToken();
		    	tempChar = temp.charAt(0);
		    	tempInt = (int)tempChar - 32;
		    	//temp = temp.replace(temp.charAt(0), (char)tempInt);
		    	sb.append((char)tempInt);
		    	sb.append(temp.substring(1));
		    	if(input.hasMoreTokens())
		    	sb.append(" ");
		    }
		    System.out.println(sb);
		//oddNumbers(3,5);
	}
	/**
	 * 
	 * @param l
	 * @param r
	 * @return array of odd numbers between two numbers l and r.
	 */
	 static int[] oddNumbers(int l, int r) {
		//size_padis used to determine correct size of final array.
        int size_pad = (l%2 == 1 || r%2 ==1) ? 1 : 0;
        int size = (r-l)/2 + size_pad;
        int ans[] = new int[size];
        for(int i=l,j=0; i<=r; i++){
            if(i%2 == 1){
                System.out.println(i);
                ans[j] = i;
                j++;
            }    
        }
        return ans;
	 }
}
