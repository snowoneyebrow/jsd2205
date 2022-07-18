package ooday05;

public class Card { //银行卡
    private String cardId;  //卡号
    private String cardPwd; //密码
    private double balance; //余额

    public boolean payMoney(double money) { //支付金额
        if (balance >= money) {
            balance -= money;
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPwd(String pwd) { //检测密码（营业员可以调用）
        if (pwd == cardPwd) {
            return true;
        } else {
            return false;
        }
    }
}