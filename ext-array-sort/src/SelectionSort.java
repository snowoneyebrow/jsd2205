import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {8, 1, 4, 9, 0, 3, 5, 2, 7, 6};
        int temp;

        for (int i = 0; i < array.length - 1; i++) { //升序
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length - 1; i++) { //降序
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}