package com.jesusgarce;

class ResultView {
    private Result result;

    ResultView(Result result) {
        this.result = result;
    }

    void print(){
        System.out.print(" | Heridos: "+ result.getWoundeds() + " | Muertos: "+result.getDeads());
    }
}
