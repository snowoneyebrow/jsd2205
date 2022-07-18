package day05;

//九九乘法表
public class MultiTable {
    public static void main(String[] args) {
        for (int num = 1; num <= 9; num++) { //控制行
            for (int i = 1; i <= num; i++) { //控制列
                System.out.print(i + "*" + num + "=" + i * num + "\t");
                //print()：输出完不换行
                //"\t"控制输出的字符对齐
            }
            System.out.println(); //若println()为空，则单纯地换行
        }


        for (int num = 1; num <= 9; num++) {
            for (int i = 1; i <= num; i++) {
                System.out.print(i + "*" + num + "=" + i * num + "\t");
            }
            System.out.println();
        }




    }
}
