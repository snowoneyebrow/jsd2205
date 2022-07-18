package exception;

public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("start");

        try {
            //String line = null; //异常只处理一次
            String line = "abc";
            System.out.println(line.length());
            System.out.println(line.charAt(0));
            System.out.println(Integer.parseInt(line));
            System.out.println("!!!!!!!");
//        } catch (NullPointerException e) {
//            System.out.println("空指针，解决了");
//        } catch (StringIndexOutOfBoundsException e) {
//            System.out.println("下标越界，解决了");
        } catch (NullPointerException | StringIndexOutOfBoundsException e) { //一个或符号
            System.out.println("出现空指针或下标越界，解决了");
        } catch (Exception e) { //超类的异常
            System.out.println("反正就是出错了啦");
        }

        System.out.println("end");
    }
}
