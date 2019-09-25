package src.com.jesusgarce.controllers;

import src.com.jesusgarce.models.Game;

public class ProposeController extends Controller {

    public ProposeController(Game game) {
        super(game);
    }

    public boolean isWinner(){
        return this.game.isWinner();
    }

    public boolean createProposedCode(String proposedCodeString){
        return this.game.createProposedCode(proposedCodeString);
    }

    public boolean attemptsRemained(){
        return this.game.attemptsRemained();
    }

}
