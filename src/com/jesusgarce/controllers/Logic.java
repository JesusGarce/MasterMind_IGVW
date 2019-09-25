package com.jesusgarce.controllers;

import com.jesusgarce.models.Game;
import com.jesusgarce.models.State;
import com.jesusgarce.models.StateManager;

import java.util.HashMap;
import java.util.Map;

public class Logic {
    private final StateManager stateManager;
    private Game game;
    private Map<State, Controller> controllers;

    public Logic() {
        this.stateManager = new StateManager();
        this.game = new Game();
        this.controllers = new HashMap<>();
        this.controllers.put(State.STARTING, new StartController(this.game, this.stateManager));
        this.controllers.put(State.PLAYING, new ProposeController(this.game, this.stateManager));
        this.controllers.put(State.FINISHING, new ResumeController(this.game, this.stateManager));
        this.controllers.put(State.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.stateManager.getValueState());
    }

    public State getState() {
        return this.stateManager.getValueState();
    }

}
