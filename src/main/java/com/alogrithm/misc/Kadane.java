package com.alogrithm.misc;

import java.util.Arrays;

class Kadane
{
	public static void main (String[] args)
	{
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println("Maximum contiguous sum is " +
									maxSubArraySum(a));
		System.out.println(Arrays.toString(maxSubArraySumIndices(a)));
	}

	static int maxSubArraySum(int a[])
	{
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++)
		{
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		return max_so_far;
	}

	static int[] maxSubArraySumIndices(int a[])
	{
		int[] indices = new int[2];
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++)
		{
			if(max_ending_here == 0){
				indices[0] = i;
			}
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				indices[1] = i;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
		}
		return indices;
	}
}
