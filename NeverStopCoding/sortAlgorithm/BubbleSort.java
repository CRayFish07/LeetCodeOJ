package sortAlgorithm;

import java.util.Arrays;

/**  
 * 冒泡排序：
 * 
 * 冒泡排序是最简单的排序之一了，其大体思想就是通过与相邻元素的比较和交换来把小的数交换到最前面。
 * 这个过程类似于水泡向上升一样，因此而得名。举个例子，对5,3,8,6,4这个无序序列进行冒泡排序。
 * 首先从后向前冒泡，4和6比较，把4交换到前面，序列变成5,3,8,4,6。同理4和8交换，变成5,3,4,8,6,3和4无需交换。
 * 5和3交换，变成3,5,4,8,6,3.这样一次冒泡就完了，把最小的数3排到最前面了。对剩下的序列依次冒泡就会得到一个有序序列。
 * 
 * 冒泡排序的时间复杂度为O(n^2)。
 *  
 * @author 郑元浩 
 * @date 2017年2月17日 下午3:54:10 
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 8, 6};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arr1 = {3, 4, 5, 6, 8};
		bubbleSort3(arr1);
		System.out.println(Arrays.toString(arr1));
	}
	
	public static void bubbleSort(int[] arr){
		if (arr == null || arr.length == 0) { // null或者无元素的数组
			return ;
		}
		for (int i = 0; i < arr.length - 1; i++) { // 从第一个元素到倒数第二个元素
			for (int j = arr.length - 1; j > i; j--) { // 从最后一个元素到当前元素之前的那个元素
				if (arr[j] < arr[j - 1]) { // 比较每个元素与之前元素值得大小，小的话交换
					Swap.swap(arr, j - 1, j);
				}
			}
		}
	}
	
	// repeat1
	public static void bubbleSort2(int[] arr){
		if (arr == null || arr.length == 0) {
			return ;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					Swap.swap(arr, j, j - 1);
				}
			}
		}
	}
	
	/**
	 * 改进的冒泡排序算法：最佳情况下时间复杂度为O(n)
	 * @param arr
	 */
	public static void bubbleSort3(int arr[]) {
	    boolean didSwap;
	    for(int i = 0, len = arr.length; i < len - 1; i++) {
	        didSwap = false;
	        for(int j = 0; j < len - i - 1; j++) {
	            if(arr[j + 1] < arr[j]) {
	            	Swap.swap(arr, j, j + 1);
	                didSwap = true;
	            }
	        }
	        if(didSwap == false) // 如果是有序的，则不会发生上面的比较，标志位为false
	            return;
	    }    
	}

}
