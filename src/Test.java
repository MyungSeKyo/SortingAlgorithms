
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8,9};
		insertionSort(array);
		for(int i = 0;i < array.length;i++) {
			System.out.println(array[i]);
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
	public static void swap(int[] array,int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
