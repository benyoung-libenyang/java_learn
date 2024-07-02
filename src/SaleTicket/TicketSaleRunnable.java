package SaleTicket;

public class TicketSaleRunnable implements Runnable{
    private int ticket = 100;

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
    private synchronized void saleOneTicket(){
        if(ticket > 0 ){
            System.out.println(Thread.currentThread().getName() + "卖出一张票，票号："+ticket);
            ticket--;
        }
    }
}
