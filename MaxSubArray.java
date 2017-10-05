package arraysandstrings;

import java.util.Arrays;

public class MaxSubArray {
	/*
	 * Computes subArray which has elements that sums up to max Value
	 */
	public static void main(String[] args) {
		int A[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Max subArray "+maxSubArray(A));
		System.out.println("Max subArray "+maxSubArrFast(A));
	}
	/* what you thought*/
	public static int maxSubArray(int[] nums) {
		int globalSum = nums[0];
		int sumHere = nums[0];
	        for(int start = 0; start<nums.length; start++){
	            //iterate through possible starting indices
	            for(int end = start+1; end<nums.length; end++){
	                //iterate through possible ending indices
	            	System.out.println(Arrays.toString(
	            			Arrays.copyOfRange(nums, start, end)));
	            	sumHere = 0;		            
	            	for(int i=start; i<end; i++){
	            		sumHere += nums[i];
	            	}
	            	globalSum = (globalSum > sumHere)? globalSum : sumHere;
	            	//System.out.println("globalSum "+globalSum+" sumHere "+sumHere );
	            }
	            
	        }
	        return globalSum;
	    }
	/* what is faster*/
	static int maxSubArrFast(int[] nums){
		int globalMax = nums[0];
		int maxHere = 0;
		for(int i=0; i<nums.length; i++){
			maxHere = (maxHere+nums[i] > nums[i]) ? maxHere+nums[i] :nums[i];  
			globalMax = (globalMax > maxHere) ? globalMax : maxHere;
		}
		return globalMax;
	}
}
