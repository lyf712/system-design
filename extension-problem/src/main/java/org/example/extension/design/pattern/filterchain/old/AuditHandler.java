package org.example.extension.design.pattern.filterchain.old;

/**
 * @author liyunfei
 **/
public interface AuditHandler<T> {
    boolean audit(T t);
}
