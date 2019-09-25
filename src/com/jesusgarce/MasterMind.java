package com.jesusgarce;

import com.jesusgarce.controllers.ProposeController;
import com.jesusgarce.controllers.ResumeController;
import com.jesusgarce.models.Game;
import com.jesusgarce.views.GameView;

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
        this.proposeController = new ProposeController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = new GameView(resumeController,proposeController);
    }

    public static void main(String[] args) throws IOException {
        new MasterMind().play();
    }

    void play() throws IOException {
        view.interact();
    }
}

