package factory;

import java.util.HashMap;
import java.util.Map;

import handler.ActionHandler;

public class HandlerFactory {
    private final Map<String, ActionHandler> handlers = new HashMap<>();

    public void register(String command, ActionHandler handler) {
        handlers.put(command.toLowerCase(), handler);
    }

    public ActionHandler getHandler(String command) {
        return handlers.get(command.toLowerCase());
    }
}
