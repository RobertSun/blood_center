package org.dlbc.ws.handler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: echo
 * Date: 7/5/11
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeaderHandlerResolver implements HandlerResolver{
    @SuppressWarnings("rawtypes")
	public List<Handler> getHandlerChain(PortInfo portInfo) {
        List<Handler> handlers = new ArrayList<Handler>();
        handlers.add(new HeaderHandler());
        return handlers;
    }
}
