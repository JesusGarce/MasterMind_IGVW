package com.jesusgarce.controllers;

import com.jesusgarce.models.*;
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

    public int getAttempts(){
        return game.getAttempts();
    }

    public ArrayList<ProposedCode> getProposedCodes(){
        return game.getProposedCodes();
    }

    public void addAtempt(){
        game.addAtempt();
    }

    public SecretCode getSecretCode(){
        return this.game.getSecretCode();
    }

}