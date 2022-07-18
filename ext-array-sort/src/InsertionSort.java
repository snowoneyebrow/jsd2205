import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {8, 1, 4, 9, 0, 3, 5, 2, 7, 6};
        int temp;

        for (int i = 1; i < array.length; i++) { //升序，从第2个元素开始排
            for (int j = i; j > 0; j--) { //每个元素从右往左比较
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < array.length; i++) { //降序，从第2个元素开始排
            for (int j = i; j > 0; j--) { //每个元素从右往左比较
                if (array[j] > array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}