package com.jesusgarce.controllers;

import com.jesusgarce.models.Game;
import com.jesusgarce.models.StateManager;
import com.jesusgarce.views.View;

import java.io.IOException;

public class ProposeController extends Controller {

    public ProposeController(Game game, StateManager stateManager) {
        super(game,stateManager);
    }

    @Override
    public void accept(View view) throws IOException {
        view.visit(this);
    }

    public ProposedCodeState propose(String stringProposedCode){
        if (createProposedCode(stringProposedCode)) {
            addAtempt();
            if (isWinner()) {
                stateManager.next();
                return ProposedCodeState.WINNER;
            } else
                if (!anyAttemptRemained()) {
                    stateManager.next();
                    return ProposedCodeState.WITHOUT_ATTEMPTS;
                }
        } else
            return ProposedCodeState.BAD_CHARACTERS;

        return ProposedCodeState.CONTINUE_PLAYING;
    }

    private boolean isWinner(){
        return this.game.isWinner();
    }

    private boolean createProposedCode(String proposedCodeString){
        return this.game.createProposedCode(proposedCodeString);
    }

    private boolean anyAttemptRemained(){
        return this.game.anyAttemptsRemained();
    }

}
