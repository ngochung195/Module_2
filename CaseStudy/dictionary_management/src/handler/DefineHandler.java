package handler;

import javafxcontroller.MainController;

public class DefineHandler implements ActionHandler {
    private final MainController controller;

    public DefineHandler(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.doDefine();
    }
}
