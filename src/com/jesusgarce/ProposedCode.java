package com.jesusgarce;

import java.util.ArrayList;

import static com.jesusgarce.MasterMind.CODE_SIZE;

class ProposedCode extends Code {
    private Result result;

    ProposedCode(String proposedCodeString) {
        super();
        ArrayList<Token> proposedCodeArray = new ArrayList<>();

        for (int i = 0; i < CODE_SIZE; i++){
            char proposedCodeChar = proposedCodeString.charAt(i);
            if (Token.isToken(proposedCodeChar)) {
                Token token = Token.createToken(proposedCodeChar);
                if ((token != null) && !(proposedCodeArray.contains(token)))
                    proposedCodeArray.add(token);
            }
        }

        if (proposedCodeArray.size() == CODE_SIZE)
            this.code = proposedCodeArray;
    }

    boolean codeIsEmpty(){
        return code.isEmpty();
    }

    boolean isWinner() { return result.isWinner();}

    Result getResult() {
        return result;
    }

    void setResult(Result result) {
        this.result = result;
    }
}
