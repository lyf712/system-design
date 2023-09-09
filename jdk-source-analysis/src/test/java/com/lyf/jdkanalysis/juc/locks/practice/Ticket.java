package com.lyf.jdkanalysis.juc.locks.practice;

/**
 * @author liyunfei
 **/
public class Ticket {
    private int num;

    public Ticket(int num) {
        this.num = num;
    }

    void increase() {
        num++;
    }

    void decrease() {
        num--;
    }
}
