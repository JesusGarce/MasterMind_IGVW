package com.jesusgarce.models;

public enum Token {
    R, B, Y, G, O, P;

    static boolean isToken(Character tokenChar) {
        tokenChar = Character.toUpperCase(tokenChar);

        if ((tokenChar.toString().equals(Token.R.toString())) || (tokenChar.toString().equals(Token.B.toString())) ||
                (tokenChar.toString().equals(Token.Y.toString())) || (tokenChar.toString().equals(Token.G.toString())) ||
                (tokenChar.toString().equals(Token.O.toString())) || (tokenChar.toString().equals(Token.P.toString())))
            return true;
        else
            return false;
    }

    static Token createToken(Character tokenChar) {
        tokenChar = Character.toUpperCase(tokenChar);

        switch (tokenChar) {
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

}
