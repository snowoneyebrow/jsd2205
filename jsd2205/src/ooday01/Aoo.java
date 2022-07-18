package ooday01;

class Aoo {
    void show() {}
    void show(String name) {}
    void show(int age) {}
    void show(String name, int age) {}
    void show(int age, String name) {}

    //int show(){ return 1; } //编译错误，重载与返回值类型无关
    //void show(String address){} //编译错误，重载与形式参数名称无关
}