package SaleTicket;

//静态方法方法加锁，默认为类名.class
public class TicketSaleThread extends Thread{
    public static int ticket = 100;
    @Override
    public void run() {
        while(ticket > 0){
            saleOneTicket();
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }

    }
    private synchronized static void saleOneTicket(){
        if(ticket > 0 ){
            System.out.println(Thread.currentThread().getName() + "卖出了一张票，票号：" + ticket);
            ticket--;
        }
    }
}
