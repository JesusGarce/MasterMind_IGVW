package com.jesusgarce;

class SecretCodeView {
    private SecretCode secretCode;

    SecretCodeView(SecretCode secretCode){
        this.secretCode = secretCode;
    }

    String print(){
        return secretCode.getSecretCode().toString();
    }

}
