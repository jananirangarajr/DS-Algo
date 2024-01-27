package algo.sorting;

public class InsertionSort {

    public static void main(String[] args) {

        int[] array = new int[] {85,12,59,45,72,51};

        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >=0; j--) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                else {
                    //In position
                    break;
                }
                printArray(array);
            }

        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
}
