package org.example.extension.design.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class PlayerMemento {

    //private List<PlayerOriginator.State> mementos = new ArrayList<>();
    private final PlayerOriginator.State state;

    public PlayerMemento(PlayerOriginator.State state) {
        this.state = state;
    }

    public PlayerOriginator.State getState() {
        return state;
    }
}
