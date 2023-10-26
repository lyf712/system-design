package org.example.extension.design.pattern.filterchain.filter;

/**
 * @author liyunfei
 **/
public interface FilterChain {
    void entry();
    void addFilter(Filter filter);
}
