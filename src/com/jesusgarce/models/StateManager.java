package com.jesusgarce.models;

public class StateManager {
    private State state;

    public StateManager() {
        state = State.STARTING;
    }

    public void next() {
        this.state = State.values()[this.state.ordinal() + 1];
    }

    public void reset() {
        this.state = State.STARTING;
    }

    public State getValueState() {
        return this.state;
    }
}
