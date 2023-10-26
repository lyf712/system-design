package org.example.extension.design.pattern.filterchain;

/**
 * @author liyunfei
 **/
public abstract class AbstractHandler implements Handler<Request,Response>{

    private AbstractHandler nextHandler = null;

//    public AbstractHandler(AbstractHandler nextHandler) {
//        this.nextHandler = nextHandler;
//    }

    void setNextHandler(AbstractHandler handler){
        this.nextHandler = handler;
    }

    @Override
    public void handle(Request request, Response response) {
        process(request,response);
        if(nextHandler!=null){
           nextHandler.handle(request, response);
        }
    }

    abstract void process(Request request,Response response);
}
