package cn.jy.sellTicket;

/*
 * 案例需求 某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
 */
/*实现步骤
 * 定义一个类SellTicket实现Runnable接口，里面定义一个成员变量：private int tickets = 100;
 * 在SellTicket类中重写run()方法实现卖票，代码步骤如下
 * 判断票数大于0，就卖票，并告知是哪个窗口卖的
 * 卖了票之后，总票数要减1
 * 票没有了，也可能有人来问，所以这里用死循环让卖票的动作一直执行
 * 定义一个测试类SellTicketDemo，里面有main方法，代码步骤如下
 * 创建SellTicket类的对象
 * 创建三个Thread类的对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
 * 启动线程
 * */
public class SellTicket implements Runnable {
    private int tickets = 100;

    //在SellTicket类中重写run()方法实现卖票，代码步骤如下
    @Override
    public void run() {
        //相同的票出现了多次
        while (true) {
            //tickets = 100;
            //t1,t2,t3
            //假设t1线程抢到CPU的执行权
            if (tickets > 0) {
                //通过sleep方法来模拟出票时间
                try {
                    Thread.sleep(100);
                    //t1线程休息100毫秒
                    //t2线程抢到了CPU的执行权，t2线程就开始执行，执行到这里的时候，t2线程休息100毫秒
                    //t3线程抢到了CPU的执行权，t3线程就开始执行，执行到这里的时候，t3线程休息100毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //假设线程按照顺序醒过来
                //t1抢到CPU的执行权，在控制台输出：窗口1正在出售第100张票
                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                //t2抢到CPU的执行权，在控制台输出：窗口2正在出售第100张票
                //t3抢到CPU的执行权，在控制台输出：窗口3正在出售第100张票
                tickets--;
                //如果这三个线程还是按照顺序来，这里就执行了3次--的操作，最终票就变成了97

            }
        }
    }
}
