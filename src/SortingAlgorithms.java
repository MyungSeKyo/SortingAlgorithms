
public class SortingAlgorithms {
	
	public static void mergeSort(int[] array) {
		mergeSortRoutine(array, 0, array.length - 1);
	}
	
	private static void mergeSortRoutine(int[] array,int head, int tail) {
		int mid = (head + tail) / 2;
		int i = head;
		int j = mid;
		int[] tempArray;
		int tempIndex = 0;
		
		if(head < mid) {
			mergeSortRoutine(array, head, mid);	
		}
		
		if(mid  + 1 < tail) {
			mergeSortRoutine(array, mid + 1, tail);
		}
		
		tempArray = new int[tail - head + 1];
		i = head;
		j = mid + 1;
		
		while(i <= mid && j <= tail) {
			if(array[i] < array[j]) {
				tempArray[tempIndex] = array[i];
				tempIndex++;
				i++;
			} else {
				tempArray[tempIndex] = array[j];
				tempIndex++;
				j++;
			}
		}
		
		while(i <= mid) {
			tempArray[tempIndex] = array[i];
			tempIndex++;
			i++;
		}	
		
		while(j <= tail) {
			tempArray[tempIndex] = array[j];
			tempIndex++;
			j++;
		}
		
		for(int k = 0;k < tempArray.length;k++) {
			array[head + k] = tempArray[k];
		}
	}
	
	public static void quickSort(int[] array) {
		quickSortRoutine(array, 0, array.length - 1);
	}
	
	private static void quickSortRoutine(int[] array, int head, int tail) {
		int pivot = array[(head + tail) / 2];
		int left = head;
		int right = tail;
		
		
		while(left < right) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			if(left < right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}

		if(head < left && left < right)
			quickSortRoutine(array, head, left);
		
		if(right < tail && left < right)
			quickSortRoutine(array, right, tail);
	}
	
	public static void selectionSort(int[] array) {
		int maxIndex = 0;
		for(int i = 0;i < array.length; i++) {
			maxIndex = i;
			for(int j = i + 1;j < array.length;j++) {
				if(array[maxIndex] > array[j]) {
					maxIndex = j;
				}
			}
			swap(array, i, maxIndex);
		}
	}
	
	public static void insertionSort(int[] array) {
		for(int i = 0;i < array.length;i++) {
			for(int j = i;j > 0;j--) {
				if(array[j - 1] > array[j]) {
					swap(array, j - 1, j);
				} else {
					break;
				}
			}
		}
	}
	
	private static void swap(int[] array,int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
