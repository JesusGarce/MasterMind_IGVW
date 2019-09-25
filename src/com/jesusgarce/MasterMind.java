package com.jesusgarce;

import src.com.jesusgarce.controllers.ProposeController;
import src.com.jesusgarce.controllers.ResumeController;
import src.com.jesusgarce.models.Game;
import src.com.jesusgarce.views.GameView;

import java.io.IOException;

public class MasterMind {
    public static final int CODE_SIZE = 4;
    public static final int MAX_ATTEMPTS = 10;
    private GameView view;
    private Game game;
    private final ProposeController proposeController;
    private final ResumeController resumeController;

    private MasterMind() {
        this.game = new Game();
        this.view = new GameView(this.game);
        this.proposeController = new ProposeController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public static void main(String[] args) throws IOException {
        new MasterMind().play();
    }

    void play() throws IOException {
        view.interact();
    }
}

