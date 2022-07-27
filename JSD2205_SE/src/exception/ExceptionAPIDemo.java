package exception;

//异常常用方法
public class ExceptionAPIDemo {
    public static void main(String[] args) {
        try {
            String str = "abc";
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace(); //输出错误的堆栈信息，便于定位错误进行修复

            String message = e.getMessage(); //获取错误信息，给用户提示或记录日志
            System.out.println(message);
        }
    }
}
