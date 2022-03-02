package cn.jy.thread;

public class MyRunnableDemo {
    public static void main(String[] args) {
        //创建MyRunnable类的对象
        MyRunnable my = new MyRunnable();

        // 创建Thread类的对象,把MyRunnable对象作为构造方法的参数,还可以设置名称
        Thread t1 = new Thread(my,"高铁");
        Thread t2 = new Thread(my,"飞机");

        t1.start();
        t2.start();
    }
}
