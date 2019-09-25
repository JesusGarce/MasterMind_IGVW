package com.jesusgarce.controllers;

import com.jesusgarce.models.Game;
import com.jesusgarce.models.ProposedCode;
import com.jesusgarce.models.Result;
import com.jesusgarce.models.SecretCode;

import java.util.ArrayList;

public abstract class Controller {
    final Game game;

    public Controller(Game game) {
        this.game = game;
    }

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

    public ProposedCode getLastProposedCode(){
        return this.game.getLastProposedCode();
    }

    public Result getResult(){
        return this.game.getLastProposedCode().getResult();
    }
}