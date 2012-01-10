package org.mule.module.esper;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import com.espertech.esper.event.bean.BeanEventBean;
import com.espertech.esper.event.map.MapEventBean;
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

    // ToDo Figure out how to deal with newEvents vs. oldEvents intelligently
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {

        /*
        ToDo this should probably be made configurable, giving the user the option to return a NullPayload
        instead of suppressing null events.
         */
        if (newEvents == null) {
            logger.debug("Null events collection received");
            return;
        }

        for (EventBean event : newEvents) {
            try {
                sourceCallback.process(event.getUnderlying());
            } catch (Exception e) {
                logger.error("Could not process event: " + event, e);
            }
        }

    }
}
