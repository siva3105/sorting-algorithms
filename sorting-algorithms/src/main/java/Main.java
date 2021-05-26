public class Main {

    public static void main(String[] args) {
        int[] array = {45, 23, 76, 12, 58, -1};
        int[] tempArray = {45, 23, 76, 12, 58, -1};
        System.out.println("****** Bubble Sort ******");
        showArray(array);
        Sort.bubbleSort(array);
        showArray(array);
        System.out.println("****** Selection Sort ******");
        unsort(tempArray, array);
        showArray(array);
        Sort.selectionSort(array);
        showArray(array);
        System.out.println("****** Insertion Sort ******");
        unsort(tempArray, array);
        showArray(array);
        Sort.insertionSort(array);
        showArray(array);
        System.out.println("****** Shell Sort ******");
        unsort(tempArray, array);
        showArray(array);
        Sort.shellSort(array);
        showArray(array);
        System.out.println("****** Quick Sort ******");
        unsort(tempArray, array);
        showArray(array);
        Sort.quickSort(array, 0, array.length - 1);
        showArray(array);
        System.out.println("****** Merge Sort ******");
        unsort(tempArray, array);
        showArray(array);
        Sort.mergeSort(array, 0, array.length - 1);
        showArray(array);
        System.out.println("****** END ******");
    }

    private static void showArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    private static void unsort(int[] tempArray, int[] array) {
        for (int i = 0; i < tempArray.length; i++) {
            array[i] = tempArray[i];
        }
    }

}
