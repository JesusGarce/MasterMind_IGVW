package com.jesusgarce;

class ProposedCodeView {
    private ProposedCode proposedCode;

    ProposedCodeView(ProposedCode proposedCode) {
        this.proposedCode = proposedCode;
    }

    void print(){
        System.out.print(proposedCode.getCode().toString());
    }
}
