import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random random = new Random();
        int numberBound = 100; //numberBound表示生成0到numberBound-1之间的随机数
        int numbersCount = 10000; //生成多少个随机数
        int[] array = new int[numbersCount];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(numberBound);
        }
        System.out.println(Arrays.toString(array)); //输出数组

        int temp;
        int compareCount = 0, swapCount = 0; //对比次数，换位次数

        long startTime = System.currentTimeMillis(); //获取当前系统时间，单位毫秒

        for (int i = 0; i < array.length - 1; i++) { //升序
            for (int j = 0; j < array.length - i - 1; j++) {
                compareCount++; //对比次数
                if (array[j] > array[j + 1]) {
                    swapCount++; //换位次数
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        long endTime = System.currentTimeMillis();
/*
        for (int i = 0; i < array.length - 1; i++) { //降序
            for (int j = 0; j < array.length - i - 1; j++) {
                compareCount++; //对比次数
                if (array[j] < array[j + 1]) {
                    swapCount++; //换位次数
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
*/
        System.out.println(Arrays.toString(array)); //输出数组
        System.out.println("对比次数：" + compareCount);
        System.out.println("换位次数：" + swapCount);
        System.out.println("耗时：" + (endTime - startTime) + "毫秒");
    }
}