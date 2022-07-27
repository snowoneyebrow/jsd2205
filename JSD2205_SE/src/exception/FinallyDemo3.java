package exception;

/*
finally常见面试题：
请分别说明：final，finally，finalize是什么？
finalize是Object中定义的一个方法，这意味着java中所有类都有该方法。
该方法会被GC（垃圾回收）调用，当GC扫描时发现一个对象不再被引用，则会将其释放，
在释放前会调用finalize，一旦该方法执行完毕，则对象被释放。
API手册明确说明：该方法可以被重写，但是不应当做耗时的操作，否则可能影响GC的工作。
 */
public class FinallyDemo3 {
    public static void main(String[] args) {
        //null不能调方法，会空指针异常
        //""空字符串没有第一个元素，会下标越界异常
        System.out.println(dosome("0") + "," + dosome(null) + "," + dosome(""));
    }

    public static int dosome(String str) {
        try {
            return str.charAt(0) - '0'; //str.charAt(0)返回str下标为0的字符
        } catch (NullPointerException e) {
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
