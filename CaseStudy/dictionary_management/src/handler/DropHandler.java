package handler;

import javafxcontroller.MainController;

public class DropHandler implements ActionHandler {

    private final MainController controller;

    public DropHandler(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.doDrop();
    }

}