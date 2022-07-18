package apiday02;

/**
 * String replaceAll(String regex,String s):替换
 * 将当前字符串中满足正则表达式(regex)的部分替换为给定的字符串(s)
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String line = "abc123def456ghi789";
        line = line.replaceAll("\\d+", "#NUMBER#");
        System.out.println(line);
    }
}
