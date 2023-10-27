package org.example.extension.design.pattern.filterchain.old;

import lombok.Data;

/**
 * @author liyunfei
 **/
@Data
public abstract class AbstractAuditFilter implements AuditHandler<WorkerOrder>{

    protected AbstractAuditFilter next;

}
