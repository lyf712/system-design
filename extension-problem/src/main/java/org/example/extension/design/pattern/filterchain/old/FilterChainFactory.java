package org.example.extension.design.pattern.filterchain.old;

import java.util.List;

/**
 * @author liyunfei
 **/
public class FilterChainFactory {
    public static FilterChain build(List<AbstractAuditFilter> abstractAuditFilterList){
        if(abstractAuditFilterList==null||abstractAuditFilterList.isEmpty()){
            return null;
        }
        FilterChain filterChain = new FilterChain(abstractAuditFilterList.get(0));
        for(AbstractAuditFilter filter:abstractAuditFilterList){
            filterChain.addLast(filter);
        }
        return filterChain;
    }
}
