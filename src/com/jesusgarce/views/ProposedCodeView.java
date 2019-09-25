package src.com.jesusgarce.views;

import src.com.jesusgarce.controllers.Controller;

class ProposedCodeView {
    private Controller controller;

    ProposedCodeView(Controller controller) {
        this.controller = controller;
    }

    void print() {
        System.out.print(controller.getLastProposedCode().getCode().toString());
    }
}
