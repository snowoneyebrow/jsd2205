package reflect.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoRunMethod {
    int value() default 2;
    //String name();

    /*
    注解中定义参数的语法：
    类型 参数名() default 默认值; //“default 默认值”是可写可不写的

    如果当前注解只有一个参数，那么参数名应当叫value。
    此时当我们在外面使用该注解时，可以使用：
    @AutoRunMethod(3)
    进行传参。此时注解中value的值为3。

    如果该参数名不叫value，例如，定义时如下：
    public @interface AutoRunMethod{
        int num();
    }
    此时当我们在外面使用该注解时，可以使用：
    @AutoRunMethod(num=3) //传参时格式为：参数名=参数值
    进行传参。此时注解中num的值为3。

    只有当参数名叫value时，传参时才可以将参数名忽略。

    以上特性仅限于只有一个参数时。

    当有多个参数时，例如，定义时如下：
    public @interface AutoRunMethod{
        int value();
        String name();
    }
    使用注解传递参数时，参数名都不可以忽略，必须写为name=value的格式，且顺序无所谓。
    例如：
    @AutoRunMethod(value=1,name="张三")
    @AutoRunMethod(name="张三",value=1)
    以上都正确

    参数可以使用default指定默认值，那么在使用注解时，可以不指定该参数的值，使用的是默认值。
    public @interface AutoRunMethod{
       int value() default 1;
    }
    使用该注解时：
    @AutoRunMethod(3)
    此时value的值为3

    @AutoRunMethod
    此时value的值为1（默认值）
     */
}
