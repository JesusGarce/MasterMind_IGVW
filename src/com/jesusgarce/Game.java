package com.jesusgarce;

import java.util.ArrayList;

import static com.jesusgarce.MasterMind.MAX_ATTEMPTS;

class Game {
    private SecretCode secretCode;
    private int attempts;
    private ArrayList<ProposedCode> proposedCodes;

    Game() {
        this.initialize();
    }

    void initialize(){
        this.secretCode = new SecretCode();
        this.attempts = 0;
        this.proposedCodes = new ArrayList<>();
    }

    boolean createProposedCode(String proposedCodeString){
        ProposedCode proposedCode = new ProposedCode(proposedCodeString);

        if (proposedCode.codeIsEmpty())
            return false;

        return proposedCodes.add(proposedCode);
    }

    private boolean saveProposedCode(ProposedCode proposedCode){
        return proposedCodes.add(proposedCode);
    }

    private ProposedCode getLastProposedCode(){
        return proposedCodes.remove(proposedCodes.size()-1);
    }

    void addAtempt(){
        attempts++;
    }

    boolean isWinner(){
        ProposedCode proposedCode = this.getLastProposedCode();
        proposedCode.setResult(secretCode.checkProposedCode(proposedCode));

        this.saveProposedCode(proposedCode);

        return proposedCode.isWinner();
    }

    boolean attemptsRemained(){
        return (attempts < MAX_ATTEMPTS);
    }

    SecretCode getSecretCode() { return secretCode;}

    int getAttempts() {
        return attempts;
    }

    ArrayList<ProposedCode> getProposedCodes() {
        return proposedCodes;
    }

}
