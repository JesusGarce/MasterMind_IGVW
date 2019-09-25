package com.jesusgarce.controllers;

import com.jesusgarce.models.Game;
import com.jesusgarce.models.StateManager;
import com.jesusgarce.views.View;

import java.io.IOException;

public class ResumeController extends Controller {

    public ResumeController(Game game, StateManager stateManager) {
        super(game, stateManager);
    }

    @Override
    public void accept(View view) throws IOException {
        view.visit(this);
    }

    public void resume(boolean newGame){
        if (newGame){
            game.initialize();
            stateManager.reset();
        }
        else
            stateManager.next();
    }

}
