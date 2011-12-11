package org.mule.module.esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.callback.SourceCallback;


/**
 * <code>UpdateListener</code> implementation that invokes the <code>SourceCallback</code> facilitate the
 * dispatch of events as they are read off the event stream.
 */
public class SourceCallbackUpdateListener implements UpdateListener {

    protected transient Log logger = LogFactory.getLog(getClass());

    SourceCallback sourceCallback;

    public SourceCallbackUpdateListener(SourceCallback sourceCallback) {
        this.sourceCallback = sourceCallback;
    }

    public void update(EventBean[] newEvents, EventBean[] oldEvents) {

        for (EventBean event : newEvents) {
            try {
                sourceCallback.process(event);
            } catch (Exception e) {
                logger.error("Could not process event: " + event, e);
            }
        }

    }
}
