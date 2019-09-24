package com.jesusgarce.models;

import java.util.ArrayList;

public abstract class Code {
    ArrayList<Token> code;

    Code() {
        this.code = new ArrayList<>();
    }

    public ArrayList<Token> getCode() {
        return code;
    }

}
