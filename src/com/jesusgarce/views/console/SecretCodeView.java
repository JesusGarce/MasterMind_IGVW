package com.jesusgarce.views.console;

import com.jesusgarce.models.SecretCode;

class SecretCodeView {
    protected final SecretCode secretCode;

    SecretCodeView(SecretCode secretCode) {
        this.secretCode = secretCode;
    }

    String print() {
        return secretCode.getCode().toString();
    }

}
