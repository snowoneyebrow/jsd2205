package reflect.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解：
 * 注解被大量应用于反射中，可以辅助反射机制做更多灵活的操作。
 * 后期使用的框架基本都是使用注解进行配置的。
 *
 * 在注解上我们有两个常用的注解用来说明当前注解的相关特性：
 * @Target：用于说明我们定义的注解可以被应用到哪里。
 * 该注解可以传递的参数为ElementType类型，用来表示可标注的位置。
 * 常见的有：
 * ElementType.TYPE：在类上用
 * ElementType.METHOD：在方法上用
 * ElementType.FIELD：在属性上用
 * 如果不指定@Target，则当前注解可以被应用在任何注解可使用的位置上。
 *
 * @Retention：当前注解的保留级别，有三个可选值
 * RetentionPolicy.SOURCE：当前注解仅保留在源代码中，编译后的字节码文件中没有该注解
 * RetentionPolicy.CLASS：保留到编译后的字节码文件中，但是反射机制不可访问
 * RetentionPolicy.RUNTIME：保留到字节码文件中且反射机制可以访问
 * 不指定时，默认保留级别为CLASS
 */
@Target(ElementType.TYPE) //多个时的数组形式：{ElementType.TYPE,......}
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoRunClass {

}
