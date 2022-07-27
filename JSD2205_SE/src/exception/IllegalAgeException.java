package exception;

/*
illegal：非法的
自定义异常：
自定义异常通常用于那些满足语法但是不满足业务的场景。
自定义异常要做到：
1、类名见名知义
2、继承自Exception（直接或间接继承）
3、提供所有构造器（alt+insert生成即可）
 */
public class IllegalAgeException extends Exception {
    public IllegalAgeException() {
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(Throwable cause) {
        super(cause);
    }

    public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
