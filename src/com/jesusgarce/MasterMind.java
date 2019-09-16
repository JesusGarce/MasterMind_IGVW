package com.jesusgarce;

import java.util.ArrayList;

class MasterMind {
    private int attempts;
    private ArrayList<Token> code;
    private ArrayList<ArrayList<Token>> attempts_code;
    private ArrayList<ArrayList<Integer>> attempts_tokens;
    private TokenManager tokenManager;
    private int redTokens;
    private int whiteTokens;

    MasterMind() {
        tokenManager = new TokenManager();
        code = tokenManager.getCode();
        attempts = 0;
        attempts_code = new ArrayList<>();
        attempts_tokens = new ArrayList<>();
        redTokens = 0;
        whiteTokens = 0;
    }

     void restartMasterMind(){
        attempts = 0;
        code = tokenManager.getCode();
        attempts_code = new ArrayList<>();
        attempts_tokens = new ArrayList<>();
        redTokens = 0;
        whiteTokens = 0;
    }


     int checkAttempt(String attemptString){
        if (attemptString.isEmpty() || attemptString.length() != 4)
            return 1;

        ArrayList<Token> attempt = new ArrayList<>();

        for (int i = 0; i < 4; i++){
            char attempChar = attemptString.charAt(i);
            if (tokenManager.isToken(attempChar)) {
                Token token = tokenManager.createToken(attempChar);
                if (token != null)
                    attempt.add(token);
                else
                    return 2;
            }
            else {
                return 2;
            }
        }

        checkTokens(attempt);

        addAttempt(attempt);

        if (redTokens == 4)
            return 3;

        return 0;
    }

    private void addAttempt(ArrayList<Token> attempt){
        if (attempts_code.add(attempt)) {
            attempts++;

            ArrayList<Integer> attempt_tokens = new ArrayList<>();
            attempt_tokens.add(whiteTokens);
            attempt_tokens.add(redTokens);

            attempts_tokens.add(attempt_tokens);
        }
    }

    private void checkTokens(ArrayList<Token> attempt){
        redTokens = 0;
        whiteTokens = 0;

        for (int i = 0; i < attempt.size(); i++) {
            if (code.get(i).equals(attempt.get(i)))
                redTokens++;
            else {
                if (code.contains(attempt.get(i)))
                    whiteTokens++;
            }
        }

    }


    int getAttempts() {
        return attempts;
    }

    ArrayList<ArrayList<Token>> getAttempsCode() {
        return attempts_code;
    }

    ArrayList<ArrayList<Integer>> getAttempsTokens() {
        return attempts_tokens;
    }

    int getRedTokens() {
        return redTokens;
    }

    int getWhiteTokens() {
        return whiteTokens;
    }

}
