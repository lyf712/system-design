package org.example.extension.design.pattern.filterchain.filter;

/**
 * @author liyunfei
 **/
public class ApplicationFilterChain implements FilterChain{

    int pos = 0;

    Filter[] filters = new Filter[0];

    @Override
    public void entry() {

    }

    @Override
    public void addFilter(Filter filter) {

    }
}
