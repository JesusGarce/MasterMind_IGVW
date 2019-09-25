package src.com.jesusgarce.views;

import src.com.jesusgarce.controllers.Controller;

class ResultView {
    private Controller controller;

    ResultView(Controller controller) {
        this.controller = controller;
    }

    void print() {
        System.out.print(" | Heridos: " + controller.getResult().getWoundeds() + " | Muertos: " + controller.getResult().getDeads());
    }
}
