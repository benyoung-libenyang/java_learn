package SaleTicket;

public class Ticket {
    private int ticket = 100;
    public void sale(){
        if(ticket > 0){
            System.out.println(Thread.currentThread().getName()+"卖出一张票，票号："+ticket);
            ticket--;
        }else {
            throw new RuntimeException("没有票了");
        }
    }
    public int getTicket() {
         return ticket;
    }
}
