package com.jesusgarce;

import java.util.ArrayList;

import static com.jesusgarce.MasterMind.CODE_SIZE;

class SecretCode extends Code {

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

        this.code = code;
    }

    Result checkProposedCode(ProposedCode proposedCode){
        ArrayList<Token> codeProposedCode = proposedCode.getCode();

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

        return new Result(deads,woundeds);
    }

    private Token getTokenRandom() {
        return Token.values()[(int)(Math.random() * 6 + 0)];
    }

    private boolean existToken(ArrayList<Token> code, Token token){
        return code.contains(token);
    }

    ArrayList<Token> getSecretCode() { return code; }

}
