public class SubArraySum {
	public void subArraySum(int[] arr, int target) {
		if (arr == null || arr.length == 0) return;
		
		int currSum = arr[0];
		int start = 0;
		int len = arr.length;
		
		/* In order to be able to take the last element into consideration, i must <= len */
		for (int i = 1; i <= len; i++) {
			while (start < len && currSum > target) {
				currSum -= arr[start];
				start++;
			}
			
			if (currSum == target) {
				System.out.println("Find one subsequence between " + start + " and " + (i - 1));
			}
			
			if (i < len) currSum += arr[i];
		}
	}
	
	public static void main(String[] args) {
		SubArraySum sas = new SubArraySum();
		int[] arr = new int[]{15, 2, 4, 8, 9, 5, 10, 23};
		int target = 23;
		sas.subArraySum(arr, target);
	}
}

