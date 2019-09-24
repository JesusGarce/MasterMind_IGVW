package com.jesusgarce.models;

import static com.jesusgarce.MasterMind.CODE_SIZE;

public class Result {
    private int deads;
    private int woundeds;

    Result(int deads, int woundeds) {
        this.deads = deads;
        this.woundeds = woundeds;
    }

    boolean isWinner(){
        return (this.deads == CODE_SIZE);
    }

    public int getDeads() {
        return deads;
    }

    public int getWoundeds() {
        return woundeds;
    }
}
