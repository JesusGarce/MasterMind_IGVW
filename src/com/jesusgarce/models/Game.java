package com.jesusgarce.models;

import java.util.ArrayList;

import static com.jesusgarce.MasterMind.MAX_ATTEMPTS;

public class Game {
    private SecretCode secretCode;
    private int attempts;
    private ArrayList<ProposedCode> proposedCodes;

    public Game() {
        this.initialize();
    }

    public void initialize() {
        this.secretCode = new SecretCode();
        this.attempts = 0;
        this.proposedCodes = new ArrayList<>();
    }

    public boolean createProposedCode(String proposedCodeString) {
        ProposedCode proposedCode = new ProposedCode(proposedCodeString);

        if (proposedCode.codeIsEmpty())
            return false;

        return proposedCodes.add(proposedCode);
    }

    private boolean saveProposedCode(ProposedCode proposedCode) {
        return proposedCodes.add(proposedCode);
    }

    private ProposedCode removeLastProposedCode() {
        return proposedCodes.remove(proposedCodes.size() - 1);
    }

    public void addAtempt() {
        attempts++;
    }

    public boolean isWinner() {
        ProposedCode proposedCode = this.removeLastProposedCode();
        proposedCode.setResult(secretCode.checkProposedCode(proposedCode));

        this.saveProposedCode(proposedCode);

        return proposedCode.isWinner();
    }

    public boolean anyAttemptsRemained() {
        return (attempts < MAX_ATTEMPTS);
    }

    public SecretCode getSecretCode() {
        return secretCode;
    }

    public int getAttempts() {
        return attempts;
    }

    public ArrayList<ProposedCode> getProposedCodes() {
        return proposedCodes;
    }

}
