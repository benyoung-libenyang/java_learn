package SaleTicket;
//非静态方法加锁，默认为对象this
public class SaleTicketDemo2 {
    public static void main(String[] args) {
//        使用Thread类代理Runnable来启动线程
        TicketSaleThread tr = new TicketSaleThread();
        Thread t1 = new Thread(tr, "窗口一");
        Thread t2 = new Thread(tr, "窗口二");
        Thread t3 = new Thread(tr, "窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
