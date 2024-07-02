package SaleTicket;
//同步代码块
//同步代码块：synchronized关键字可以用于某个区块前面，表示只对这个区块的资源实行互斥访问。
//同步锁：多个线程必须共用一个同步监视器（同一个类）=> this或类名.class
public class SaleTicketDemo3 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(){
            public void  run(){
                while(true){
                    synchronized (ticket){
                        ticket.sale();
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            public void  run(){
                while(true){
                    synchronized (ticket){
                        ticket.sale();
                    }
                }
            }
        };
        Thread t3 = new Thread(){
            public void  run(){
                while(true){
                    synchronized (ticket){
                        ticket.sale();
                    }
                }
            }
        };
        Thread t4 = new Thread(){
            public void  run(){
                while(true){
                    synchronized (ticket){
                        ticket.sale();
                    }
                }
            }
        };
        Thread t5 = new Thread(){
            public void  run(){
                while(true){
                    synchronized (ticket){
                        ticket.sale();
                    }
                }
            }
        };

        t2.start();
        t1.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
