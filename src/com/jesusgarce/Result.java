package com.jesusgarce;

import static com.jesusgarce.MasterMind.CODE_SIZE;

class Result {
    private int deads;
    private int woundeds;

    Result(int deads, int woundeds) {
        this.deads = deads;
        this.woundeds = woundeds;
    }

    boolean isWinner(){
        return (this.deads == CODE_SIZE);
    }

    int getDeads() {
        return deads;
    }

    int getWoundeds() {
        return woundeds;
    }
}
