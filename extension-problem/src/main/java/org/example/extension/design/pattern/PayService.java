package org.example.extension.design.pattern;

/**
 * @author liyunfei
 **/
public interface PayService {

    void pay(String username,Long amount,Long bankId);

    Long query(Long bankId);

}
