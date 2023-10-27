package org.example.extension.design.pattern.filterchain.old;

/**
 * @author liyunfei
 **/
//implements AuditHandler<WorkerOrder>
public class Leader extends AbstractAuditFilter {

    //private AuditStrategy auditStrategy;

    @Override
    public boolean audit(WorkerOrder workerOrder) {
        if(workerOrder.getDay()<3){
            // look---
            return true;
        }
        return next.audit(workerOrder);
    }


}
