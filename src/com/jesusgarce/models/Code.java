package com.jesusgarce.models;

import java.util.ArrayList;

abstract class Code {
    ArrayList<Token> code;

    Code() {
        this.code = new ArrayList<>();
    }

    ArrayList<Token> getCode() {
        return code;
    }

}
