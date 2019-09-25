package com.jesusgarce;

import com.jesusgarce.controllers.*;
import com.jesusgarce.models.State;
import com.jesusgarce.views.console.ConsoleView;

import java.io.IOException;

public class MasterMind {
    public static final int CODE_SIZE = 4;
    public static final int MAX_ATTEMPTS = 10;
    private ConsoleView view;
    private Logic logic;

    private MasterMind() {
        this.logic = new Logic();
        this.view = new ConsoleView(logic.getController());
    }

    public static void main(String[] args) throws IOException {
        new MasterMind().play();
    }

    void play() throws IOException {
        Controller controller;
        do {
            controller = this.logic.getController();
            controller.accept(view);
        } while (!logic.getState().equals(State.EXIT));
    }
}

