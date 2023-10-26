package org.example.extension.design.pattern.memento;

/**
 * @author liyunfei
 **/
public class PlayerOriginator {

    private State state;

    public PlayerOriginator(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void changeState(){
        //
        this.state = new State(2,"哈哈哈");
    }

    PlayerMemento createMemento(){
        return new PlayerMemento(state);
    }

    void restore(PlayerMemento memento){
       this.state = memento.getState();
    }

    // 采用枚举可能更好
    public static class State{
        private int code;
        // 描述
        private String desc;

        public State(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "State{" +
                    "code=" + code +
                    ", desc='" + desc + '\'' +
                    '}';
        }
    }
}
