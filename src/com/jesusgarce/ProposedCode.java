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
            if (isToken(proposedCodeChar)) {
                Token token = createToken(proposedCodeChar);
                if (token != null)
                    proposedCodeArray.add(token);
            }
        }

        if (proposedCodeArray.size() == CODE_SIZE)
            this.code = proposedCodeArray;
    }

    private boolean isToken(Character tokenChar){
        tokenChar = Character.toUpperCase(tokenChar);

        if ( (tokenChar.toString().equals(Token.R.toString())) || (tokenChar.toString().equals(Token.B.toString())) ||
                (tokenChar.toString().equals(Token.Y.toString())) || (tokenChar.toString().equals(Token.G.toString())) ||
                (tokenChar.toString().equals(Token.O.toString())) || (tokenChar.toString().equals(Token.P.toString())))
            return true;
        else
            return false;
    }

    private Token createToken(Character tokenChar){
        tokenChar = Character.toUpperCase(tokenChar);

        switch(tokenChar) {
            case 'R':
                return Token.R;
            case 'B':
                return Token.B;
            case 'Y':
                return Token.Y;
            case 'G':
                return Token.G;
            case 'O':
                return Token.O;
            case 'P':
                return Token.P;
        }
        return null;
    }

    Result getResult() {
        return result;
    }
    void setResult(Result result) {
        this.result = result;
    }
}
