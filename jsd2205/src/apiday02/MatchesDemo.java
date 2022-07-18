package apiday02;

/**
 * boolean matches(String regex):匹配
 * 使用给定的正则表达式(regex)验证当前字符串的格式是否符合要求，符合则返回true，否则返回false
 */
public class MatchesDemo {
    public static void main(String[] args) {
        String email = "wangkj@tedu.cn";
        String regex = "\\w+@[a-zA-Z\\d]+(\\.[a-zA-Z]+)+";
        /*
        \\.：在Java中，\是转义的意思，若想让\表示反斜杠，则要转义\，即第一个\转义第二个\，
        让第二个\表示反斜杠。现在变成了\.，在正则表达式中，.表示任意一个字符，
        若想让.表示点，则要转义.，让.表示点
        \\w：匹配大小写字母或数字或下划线
        \\d：匹配数字
        +：一次或多次
         */

        boolean match = email.matches(regex);
        System.out.println(match);
    }
}
