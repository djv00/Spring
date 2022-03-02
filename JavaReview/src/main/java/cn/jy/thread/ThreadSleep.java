package cn.jy.thread;

//sleep演示
public class ThreadSleep extends Thread{
       public void run(){
           for (int i = 0; i < 100; i++) {
               System.out.println(getName() + ":" + i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }

}
