package org.example.extension.design.pattern.filterchain.old;

/**
 * @author liyunfei
 **/
public class FilterChain implements AuditHandler<WorkerOrder>{

    private final AbstractAuditFilter first;

    public FilterChain(AbstractAuditFilter first) {
        this.first = first;
    }

    public void addLast(AbstractAuditFilter handler){
        AbstractAuditFilter pos = first;
        while (pos!=null ){
            if(pos.getNext()==null){
                pos.setNext(handler);
                break;
            }
            pos = pos.getNext();
        }
    }

    @Override
    public boolean audit(WorkerOrder workerOrder) {
        return first.audit(workerOrder);
    }
}
