package org.example.extension.design.pattern;

/**
 * @author liyunfei
 **/
public interface PayStrategy {
    /**
     *
     * @param amount
     * @param bankId
     */
    void pay(Long amount,Long bankId);
}
