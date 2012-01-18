package org.mule.module.esper;

import java.util.Date;

public class DummyEvent {

    public DummyEvent() {
        timestamp = new Date();
    }

    Date timestamp;

    public Date getTimestamp() {
        return timestamp;
    }
}
