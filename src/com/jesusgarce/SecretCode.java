package com.jesusgarce;

import java.util.ArrayList;

import static com.jesusgarce.MasterMind.CODE_SIZE;

class SecretCode extends Code {
    private ArrayList<ProposedCode> proposedCodes;

    SecretCode() {
        super();
        ArrayList<Token> code = new ArrayList<>();
        int index = 0;

        while (index < CODE_SIZE){
            Token token = getTokenRandom();
            if (!existToken(code, token)) {
                code.add(index,token);
                index++;
            }
        }

        this.proposedCodes = new ArrayList<>();
        this.code = code;

    }

    ProposedCode checkAndSaveProposedCode(String stringProposedCode){
        ProposedCode proposedCode = new ProposedCode(stringProposedCode);
        ArrayList<Token> codeProposedCode = proposedCode.getCode();

        if (codeProposedCode.size() == 0)
            return proposedCode;

        int deads = 0;
        int woundeds = 0;

        for (int i = 0; i < CODE_SIZE; i++) {
            if (code.get(i).equals(codeProposedCode.get(i)))
                deads++;
            else {
                if (code.contains(codeProposedCode.get(i)))
                    woundeds++;
            }
        }

        proposedCode.setResult(new Result(deads,woundeds));

        this.proposedCodes.add(proposedCode);

        return proposedCode;
    }

    private Token getTokenRandom() {
        return Token.values()[(int)(Math.random() * 6 + 0)];
    }

    private boolean existToken(ArrayList<Token> code, Token token){
        return code.contains(token);
    }

    ArrayList<Token> getSecretCode() {
        return code;
    }

    ArrayList<ProposedCode> getProposedCodes() {
        return proposedCodes;
    }
}
