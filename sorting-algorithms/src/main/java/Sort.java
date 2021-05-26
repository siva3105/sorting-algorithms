public class Sort {

    /*
     * worst case O(N^2)
     * avg case O(N^2)
     * best case O(N) --> if we want to sort sorted array
     * inplace algorithm it doesnt required extra memory*/
    public static void bubbleSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            boolean isAnySwap = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapPositions(array, j, j + 1);
                    isAnySwap = true;
                }
            }
            if (!isAnySwap) {
                break;
            }
        }
    }

    private static void swapPositions(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
     * O(N^2) in all cases
     * inplace Algorithm*/
    public static void selectionSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (array[minIndex] > array[j])
                    minIndex = j;
            }
            if (minIndex != i) {
                swapPositions(array, minIndex, i);
            }
        }
    }

    /*
     * O(N^2) in all cases
     * inplace Algorithm*/
    public static void insertionSort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swapPositions(array, j, j - 1);
                j--;
            }
        }
    }

    /*
     * O(N^2) in all cases
     * inplace Algorithm*/
    public static void shellSort(int[] array) {
        int size = array.length;
        for (int gap = size / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < size; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    /*
     * worst case O(N^2)
     * best case and avg case O(N(log N))
     * inplace algorithm */
    public static void quickSort(int[] array, int low, int high) {
        if (low >= high)
            return;
        int pivot = partition(array, low, high);
        quickSort(array, low, pivot - 1);
        quickSort(array, pivot + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int midIndex = (high + low) / 2;
        swapPositions(array, midIndex, high);
        int i = low;
        for (int j = low; j < high; j++) {
            if (array[j] <= array[high]) {
                swapPositions(array, i, j);
                i++;
            }
        }
        swapPositions(array, high, i);
        return i;
    }

    public static void mergeSort(int[] array, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);

    }

    private static void merge(int[] array, int low, int mid, int high) {
        int leftSubArraySize = mid - low + 1;
        int rightSubArraySize = high - mid;
        int[] leftSubArray = new int[leftSubArraySize];
        int[] rightSubArray = new int[rightSubArraySize];
        for (int i = 0; i < leftSubArraySize; i++) {
            leftSubArray[i] = array[low + i];
        }
        for (int i = 0; i < rightSubArraySize; i++) {
            rightSubArray[i] = array[mid + 1 + i];
        }
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int k = low;
        while (leftArrayIndex < leftSubArraySize && rightArrayIndex < rightSubArraySize) {
            if (leftSubArray[leftArrayIndex] <= rightSubArray[rightArrayIndex]) {
                array[k] = leftSubArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                array[k] = rightSubArray[rightArrayIndex];
                rightArrayIndex++;
            }
            k++;
        }
        while (leftArrayIndex < leftSubArraySize) {
            array[k] = leftSubArray[leftArrayIndex];
            leftArrayIndex++;
            k++;
        }
        while (rightArrayIndex < rightSubArraySize) {
            array[k] = rightSubArray[rightArrayIndex];
            rightArrayIndex++;
            k++;
        }
    }
}