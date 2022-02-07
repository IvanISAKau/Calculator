package com.example.calculator.domain;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

import com.example.calculator.R;

public enum Theme {

    ONE(R.style.Theme_Calculator, R.string.white, "one"),
    TWO(R.style.Theme_CalculatorV2, R.string.cloudy_apple, "two"),
    THREE(R.style.Theme_CalculatorV3, R.string.new_york, "three"),
    FOUR(R.style.Theme_CalculatorV4, R.string.blessing, "four"),
    FIVE(R.style.Theme_CalculatorV5, R.string.everlasting_sky, "five");

    @StyleRes
    private final int style;

    @StringRes
    private final int title;

    private final String key;

    Theme(int style, int title, String key) {
        this.style = style;
        this.title = title;
        this.key = key;
    }

    public int getStyle() {
        return style;
    }

    public String getKey() {
        return key;
    }

    public int getTitle() {
        return title;
    }
}
