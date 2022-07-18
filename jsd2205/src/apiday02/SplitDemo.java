package apiday02;

import java.util.Arrays;

/**
 * String[] split(String regex):拆分
 * 将当前字符串中满足正则表达式的部分移除，剩下的部分自动分隔成各个元素，依次存进String[]数组中
 */
public class SplitDemo {
    public static void main(String[] args) {
        String line = "abc123def456ghi789";
        String[] data = line.split("\\d+"); //移除数字部分
        System.out.println(Arrays.toString(data)); //将data数组按String格式输出

        line = "123.456.78";
        data = line.split("\\.");
        System.out.println(Arrays.toString(data));

        //如果最开始就是可拆分项(.)，那么数组第1个元素为空字符串""
        //如果连续两个(两个以上)可拆分项，那么各个.中间也会拆出一个空字符串""
        //如果末尾连续多个可拆分项，那么拆出的空字符串会被忽略
        line = ".123.456...78......"; //头有一个，末尾没有，中间两点拆一个
        data = line.split("\\.");
        System.out.println(Arrays.toString(data)); //6个数组元素
    }
}
