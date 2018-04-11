package com.csci360.answeringMachine;

public class Passcode {

    protected String passcode;

    protected String getPasscode() {
        return this.passcode;
    }

    protected void setPasscode(String newPasscode) {
        this.passcode = newPasscode;
    }

    protected boolean validatePasscode(String passcode) {
        if (passcode.matches("[0-9]{4}") && passcode.length() == 4) {
            return true;
        } else {
            return false;
        }
    }
}
