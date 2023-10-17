package org.example.extension.design.pattern.impl;

import org.example.extension.design.pattern.PayService;

/**
 * @author liyunfei
 **/
public class PayServiceImpl implements PayService {
    //

    private PayService payService;

    @Override
    public void pay(String username, Long amount, Long bankId) {
        // SpringUtil
    }

    @Override
    public Long query(Long bankId) {
        return null;
    }
}
