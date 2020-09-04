package com.customcontroller;

import javafx.scene.control.TextField;

public class DoubleTextField extends TextField {
    public DoubleTextField() {
        super();
    }

    @Override
    public void replaceText(int start, int end, String text) {
        if (text.equals(",")) text = ".";
        String newValue = (start == 0 && end == 0) ? text + getCharacters() : getCharacters() + text;
        if (validate(newValue)) {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text) {
        if (validate(text)) {
            super.replaceSelection(text);
        }
    }

    private boolean validate(String text) {
        return text.matches("^-?(\\d*\\.?\\d*)$");
    }
}