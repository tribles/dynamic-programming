/**
 * @author Priyank Agrawal
 *
 * Longest increasing subsequence problem by Dynamic programming approach
 */
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] array = {5, 7, 2, 1, 6, 9, 7, 2};
		System.out.println("The length of the longest increasing subsequence is: " + longestSequence(array));
	}

	/**
	 * utility method
	 * @return maximum out of the two values
	 */
	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * @return number specifying length of longest common subsequence
	 */
	static int longestSequence(int[] array) {
		int length = array.length;
		int[] subArray = new int[length];
		for (int i = 0; i < length; i++) {		//initializing the new array with minimum lengths of longest common subsequences as 1 
			subArray[i] = 1;
		}
		int max = 1;
		for (int i = 1; i < length; i++) {		//starting with the second number present in original array
			for (int j = 0; j < i; j++) {		//starting with the first number present in original array
				if (array[j] < array[i]){		//first number is less than the second number 
					subArray[i] = max(subArray[j] + 1, subArray[i]);	//maximum of either pre-calculated length or the current length
					if(subArray[i] > max)		//current max is less than new length of longest common subsequence
						max=subArray[i];		//update max value
				}
			}
		}
		return max;
	}

}