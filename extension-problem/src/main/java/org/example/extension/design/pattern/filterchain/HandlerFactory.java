package org.example.extension.design.pattern.filterchain;

/**
 * @author liyunfei
 **/
public class HandlerFactory {

    private HandlerFactory(){}

    private static class Holder{
        private static final HandlerFactory INSTANCE = new HandlerFactory();
    }

    public AbstractHandler buildDefaultHandlers(){
         AbstractHandler defaultHandlers = new AbstractHandler() {

             @Override
             void process(Request request, Response response) {

             }
         };
         defaultHandlers.setNextHandler(new PreHandler1(null));
         return defaultHandlers;
    }

}
