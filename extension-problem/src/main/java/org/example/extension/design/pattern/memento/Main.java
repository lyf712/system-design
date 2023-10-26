package org.example.extension.design.pattern.memento;

import java.util.ArrayList;

/**
 * @author liyunfei
 **/
public class Main {

    static PlayerCareTaker playerCareTaker = new PlayerCareTaker(new ArrayList<>());
    public static void main(String[] args) {
        PlayerOriginator playerOriginator = new PlayerOriginator(new PlayerOriginator.State(1,"高兴"));
        System.out.println(playerOriginator.getState());


        playerCareTaker.add(playerOriginator.createMemento());

        playerOriginator.changeState();
        System.out.println(playerOriginator.getState());

        // 可设定列表，恢复到指定地方
        playerOriginator.restore(playerCareTaker.getMementoList().get(0));
        System.out.println(playerOriginator.getState());

    }
}
