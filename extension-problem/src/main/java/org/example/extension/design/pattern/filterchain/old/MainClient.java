package org.example.extension.design.pattern.filterchain.old;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyunfei
 **/
public class MainClient {
    public static void main(String[] args) {
        WorkerOrder workerOrder = new WorkerOrder();

    }

    boolean audit(WorkerOrder workerOrder){
        Leader leader = new Leader();
        List<AbstractAuditFilter> filterList = new ArrayList<>();
        filterList.add(leader);
        FilterChain filterChain = FilterChainFactory.build(filterList);
        return filterChain.audit(workerOrder);
//        Manager manager = new Manager();
//        Boss boss = new Boss();
//        if(workerOrder.getDay()<3){
//           return leader.audit(workerOrder);
//        }else if (workerOrder.getDay()<7){
//           return leader.audit(workerOrder) && manager.audit(workerOrder);
//        }else {
//           return leader.audit(workerOrder) && manager.audit(workerOrder) && boss.audit(workerOrder);
//        }
    }
}
