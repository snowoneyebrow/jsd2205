package apiday01;

public class StartsWithDemo {
    public static void main(String[] args) {
        String str = "thinking in java";
        boolean starts = str.startsWith("think");
        System.out.println(starts);
        boolean ends = str.endsWith("av");
        System.out.println(ends);
    }
}
