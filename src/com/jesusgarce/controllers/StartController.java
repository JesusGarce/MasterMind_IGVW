package com.jesusgarce.controllers;

import com.jesusgarce.models.Game;
import com.jesusgarce.models.StateManager;
import com.jesusgarce.views.View;

import java.io.IOException;

public class StartController extends Controller {

    public StartController(Game game, StateManager stateManager) {
        super(game,stateManager);
    }

    @Override
    public void accept(View view) throws IOException {
        view.visit(this);
    }

    public void start(){
        game.initialize();
        stateManager.next();
    }

}
