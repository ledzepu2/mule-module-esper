package org.mule.module.esper;


public class EsperException extends RuntimeException  {

    public EsperException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public EsperException(String s) {
        super(s);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public EsperException(String s, Throwable throwable) {
        super(s, throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public EsperException(Throwable throwable) {
        super(throwable);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
