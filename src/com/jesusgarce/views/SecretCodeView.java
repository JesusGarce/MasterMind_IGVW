package com.jesusgarce.views;

import com.jesusgarce.controllers.Controller;

class SecretCodeView {
    protected final Controller controller;

    SecretCodeView(Controller controller) {
        this.controller = controller;
    }

    String print() {
        return controller.getSecretCode().toString();
    }

}
