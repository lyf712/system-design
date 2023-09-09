package com.lyf.jdkanalysis.juc.locks.practice;

/**
 * @author liyunfei
 **/
public class TicketDao {
    static Ticket ticketRepo;
    static {
        ticketRepo = new Ticket(1000);
    }
    //void getTicket(){ticketRepo.decrease();}
}
