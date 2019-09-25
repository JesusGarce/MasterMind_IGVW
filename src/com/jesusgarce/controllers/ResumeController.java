package src.com.jesusgarce.controllers;

import src.com.jesusgarce.models.Game;

public class ResumeController extends Controller {

    public ResumeController(Game game) {
        super(game);
    }

    public void initialize(){
        this.game.initialize();
    }

}
