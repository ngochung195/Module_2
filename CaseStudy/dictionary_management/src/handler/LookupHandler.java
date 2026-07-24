package handler;

import javafxcontroller.MainController;

public class LookupHandler implements ActionHandler {
    private final MainController controller;

    public LookupHandler(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.doLookup();
    }
}