package org.example.extension.design.pattern.filterchain;

/**
 * @author liyunfei
 **/
public class PreHandler1 extends AbstractHandler{


//    public PreHandler1(AbstractHandler nextHandler) {
//        super(nextHandler);
//    }

    @Override
    void process(Request request, Response response) {
        System.out.println("pre handle1 handle");
    }
}
