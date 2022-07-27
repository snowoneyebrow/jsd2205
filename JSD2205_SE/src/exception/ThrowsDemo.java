package exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

//当子类重写超类一个含有throws声明异常抛出的方法时，对throws的重写规则
public class ThrowsDemo {
    public void dosome() throws IOException, AWTException {
    }
}

class SubClass extends ThrowsDemo {
    /*
    public void dosome() throws IOException, AWTException {
    }

    //允许仅抛出部分异常
    public void dosome() throws IOException {
    }

    //允许不再抛出任何异常
    public void dosome(){
    }

    //允许抛出超类方法抛出的异常的子类型异常
    public void dosome() throws FileNotFoundException {
    }

    //不允许抛出额外异常
    public void dosome() throws SQLException {
    }

    //不允许抛出超类方法抛出的异常的超类型异常
    public void dosome() throws Exception {
    }
     */
}
