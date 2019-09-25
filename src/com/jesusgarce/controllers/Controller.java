package com.jesusgarce.controllers;

import com.jesusgarce.models.Game;
import com.jesusgarce.models.ProposedCode;
import com.jesusgarce.models.SecretCode;
import com.jesusgarce.models.StateManager;
import com.jesusgarce.views.View;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Controller {
    final Game game;
    final StateManager stateManager;

    public Controller(Game game, StateManager stateManager) {
        this.game = game;
        this.stateManager = stateManager;
    }

    public abstract void accept(View view) throws IOException;

    public int getAttempts() {
        return game.getAttempts();
    }

    public ArrayList<ProposedCode> getProposedCodes() {
        return game.getProposedCodes();
    }

    public void addAtempt() {
        game.addAtempt();
    }

    public SecretCode getSecretCode() {
        return this.game.getSecretCode();
    }

}