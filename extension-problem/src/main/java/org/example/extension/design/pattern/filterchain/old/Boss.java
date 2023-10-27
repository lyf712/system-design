package org.example.extension.design.pattern.filterchain.old;

/**
 * @author liyunfei
 **/
public class Boss extends AbstractAuditFilter{
    @Override
    public boolean audit(WorkerOrder workerOrder) {
        return false;
    }
}
