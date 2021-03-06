package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import utility.MaxHeap;
import utility.MinHeap;

public class KthElement {

	public static int findKthLargestElement(int[] array, int k) {
		if ((array == null || array.length == 0) && k < array.length) {
			return Integer.MIN_VALUE;
		} else if (array.length == 1 && k == 1) {
			return array[0];
		} else {
			int retval = _createMaxHeap(array, k);
			return retval;
		}
	}

	private static int _createMaxHeap(int[] array, int k) {
		MaxHeap maxHeap = new MaxHeap(array.length);
		for (int f = 0; f < array.length; ++f) {
			maxHeap.insert(array[f]);
		}

		// heap nodes have been added
		maxHeap.maxHeap();

		int retval = 0;
		for (int f = 1; f <= k; ++f) {
			retval = maxHeap.remove();
		}
		return retval;
	}

	public static int findKthSmallestElement(int[] array, int k) {
		if ((array == null || array.length == 0) && k < array.length) {
			return Integer.MIN_VALUE;
		} else if (array.length == 1 && k == 1) {
			return array[0];
		} else {
			int retval = _createMinHeap(array, k);
			return retval;
		}
	}

	private static int _createMinHeap(int[] array, int k) {
		MinHeap minHeap = new MinHeap(array.length);
		for (int f = 0; f < array.length; ++f) {
			minHeap.insert(array[f]);
		}

		// heap nodes have been added
		minHeap.minHeap();

		int retval = 0;
		for (int f = 1; f <= k; ++f) {
			retval = minHeap.remove();
		}
		return retval;
	}
	
	public static int getKthLargestUsingPQ(int[] array, int k) {
		if ((array == null || array.length == 0) && k < array.length) {
			return Integer.MIN_VALUE;
		} else if (array.length == 1 && k == 1) {
			return array[0];
		} else {
			List<Integer> list = _convertArraysIntoListIntegers(array);
			PriorityQueue<Integer> pq = new PriorityQueue<>(list.subList(0, k));
			for (int i = k; i < list.size(); i++) {
				if (list.get(i) > pq.peek()) {
					pq.poll();
					pq.add(list.get(i));
				}
			}
			return pq.peek();
		}
	}

	private static List<Integer> _convertArraysIntoListIntegers(int[] array) {
		List<Integer> list = new ArrayList<Integer>();
		for (int f : array) {
			list.add(f);
		}
		return list;
	}
}

