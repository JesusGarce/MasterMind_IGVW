package com.jesusgarce.views;

import com.jesusgarce.controllers.ProposeController;
import com.jesusgarce.controllers.ResumeController;
import com.jesusgarce.controllers.StartController;

import java.io.IOException;

public abstract class View {

    public abstract void visit(StartController startController);

    public abstract void visit(ProposeController proposeController) throws IOException;

    public abstract void visit(ResumeController resumeController) throws IOException;

}
