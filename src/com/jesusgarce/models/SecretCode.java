package com.jesusgarce.models;

import java.util.ArrayList;
import java.util.Arrays;

import static com.jesusgarce.MasterMind.CODE_SIZE;

public class SecretCode extends Code {

    SecretCode() {
        super();
        ArrayList<Token> code = new ArrayList<>();
        int index = 0;

        ArrayList<Token> token_values = new ArrayList<>(Arrays.asList(Token.values()));

        while (index < CODE_SIZE) {
            Token token = token_values.get((int) (Math.random() * token_values.size()));
            token_values.remove(token);
            code.add(index, token);
            index++;
        }

        this.code = code;
    }

    Result checkProposedCode(ProposedCode proposedCode) {
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

        return new Result(deads, woundeds);
    }

}
