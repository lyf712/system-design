package org.example.extension.design.pattern.filterchain;

/**
 * @author liyunfei
 **/
public interface Handler<REQUEST,RESPONSE> {

    void handle(REQUEST request,RESPONSE response);

}
