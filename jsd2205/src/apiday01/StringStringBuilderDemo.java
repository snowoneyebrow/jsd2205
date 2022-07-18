package apiday01;

public class StringStringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("a");
        for (int i = 0; i < 10000000; i++) {
            builder.append(i);
        }
        System.out.println("over");
    }
}
