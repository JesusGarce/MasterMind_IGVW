package com.jesusgarce.controllers;

import com.jesusgarce.models.Game;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public void initialize(){
        this.game.initialize();
    }

}
