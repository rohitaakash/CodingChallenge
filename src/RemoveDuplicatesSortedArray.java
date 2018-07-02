/*
 * Copyright (c) 2018 Financial Engines, Inc.  All Rights Reserved.
 * Sunnyvale, CA
 *
 * File: RemoveDuplicatesSortedArray.java
 * Author: raakash
 */

public class RemoveDuplicatesSortedArray {

	public static void main(String[] args) {
		
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println("No of unique elements = " + removeDuplicates(nums));

	}

	public static int removeDuplicates(int[] nums) {

		int j = 0;
		
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[j]) {
				nums[++j] = nums[i];
			}
		}
		
		return j+1;
	}
}
