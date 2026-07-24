package handler;

import javafxcontroller.MainController;

public class ExportHandler implements ActionHandler {

    private final MainController controller;

    public ExportHandler(MainController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.doExport();
    }

}