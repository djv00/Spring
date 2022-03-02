package cn.jy.thread;

//Join演示
public class ThreadJoin extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i );
        }
    }

}
