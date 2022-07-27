package exception;

/*
java异常处理机制中的try-catch：
语法：
try{
    可能出现异常的代码片段
}catch(XXXException e){
    当try中代码出现XXXException后的处理代码（B计划）
}
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("start");

        try {
            String line = null; //异常只处理一次
            System.out.println(line.length());
            System.out.println(line.charAt(0));
            System.out.println(Integer.parseInt(line));

            //try语句块中出错，出错代码下面的内容都不会被执行
            System.out.println("！！！");
        /*} catch (NullPointerException e) {
            System.out.println("空指针，解决了");
            //当我们在try中针对可能出现的不同异常有不同处理方式时，我们可以定义多个catch来分别处理
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("下标越界，解决了");*/
            //当我们针对不同异常但用相同手段处理时，可以合并到一个catch中解决
        } catch (NullPointerException | StringIndexOutOfBoundsException e) { //注意：一个“或”符号！
            System.out.println("出现空指针或下标越界，解决了");
            /*
            如果catch的是一个超类型异常，那么在try中出现的任何它的子类型异常都可以被它捕获。
            如果catch有多个，那么catch的异常遵循从小到大的先后捕获原则。
            即：子类型异常在上先catch，超类型异常在下后catch
             */
        } catch (Exception e) { //超类的异常
            System.out.println("反正就是出错了啦");
        }

        System.out.println("end");
    }
}
