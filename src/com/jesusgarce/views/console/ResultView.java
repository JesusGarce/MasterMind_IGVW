package com.jesusgarce.views.console;

import com.jesusgarce.models.Result;

class ResultView {
    private Result result;

    ResultView(Result result) {
        this.result = result;
    }

    void print() {
        System.out.print(" | Heridos: " + result.getWoundeds() + " | Muertos: " + result.getDeads());
    }
}
