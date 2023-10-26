package org.example.extension.design.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class PlayerCareTaker {

    private List<PlayerMemento> mementoList;

    public void add(PlayerMemento memento){mementoList.add(memento);}

    public PlayerCareTaker(List<PlayerMemento> mementoList) {
        this.mementoList = mementoList;
    }


    public List<PlayerMemento> getMementoList() {
        return mementoList;
    }
}
