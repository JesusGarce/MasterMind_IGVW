package com.jesusgarce;

import java.util.ArrayList;

 class TokenManager {

    TokenManager(){ }

    private Token getTokenRandom() {
        return getTokens()[(int)(Math.random() * 6 + 0)];
    }

    private Token[] getTokens(){
        return Token.values();
    }

    ArrayList<Token> getCode() {
        ArrayList<Token> code = new ArrayList<>();
        int index = 0;

        while (index < 4){
            Token token = getTokenRandom();
            if (!existToken(code, token)) {
                code.add(index,token);
                index++;
            }
        }

        return code;
    }

     boolean isToken(Character tokenChar){
        tokenChar = Character.toUpperCase(tokenChar);

        if ( (tokenChar.toString().equals(Token.R.toString())) || (tokenChar.toString().equals(Token.B.toString())) ||
                (tokenChar.toString().equals(Token.Y.toString())) || (tokenChar.toString().equals(Token.G.toString())) ||
                (tokenChar.toString().equals(Token.O.toString())) || (tokenChar.toString().equals(Token.P.toString())))
            return true;
        else
            return false;
    }

     Token createToken(Character tokenChar){
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

    private boolean existToken(ArrayList<Token> code, Token token){
        return code.contains(token);
    }
}
