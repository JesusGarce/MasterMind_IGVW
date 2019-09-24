package com.jesusgarce.views;

import com.jesusgarce.models.SecretCode;

class SecretCodeView {
    private SecretCode secretCode;

    SecretCodeView(SecretCode secretCode){
        this.secretCode = secretCode;
    }

    String print(){
        return secretCode.getSecretCode().toString();
    }

}
