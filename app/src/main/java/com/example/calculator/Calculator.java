package com.example.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {

    private double value1;
    private double value2;
    private String sign1 = "";
    private String sign2 = "";
    private StringBuilder valueOfProcess;
    private StringBuilder valueOfResult;
    private boolean flag = false; // to clear valueOfResult after calculate Result

    public Calculator() {
        valueOfProcess = new StringBuilder();
        valueOfResult = new StringBuilder();
    }

    protected Calculator(Parcel in) {
        value1 = in.readDouble();
        value2 = in.readDouble();
        sign1 = in.readString();
        sign2 = in.readString();
        flag = in.readByte() != 0;
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public String getValueOfResult() {
        return valueOfResult.toString();
    }

    public String getValueOfProcess() {
        return valueOfProcess.toString();
    }

    private void calcResult(boolean b) {
        if (sign1.equals("")) value1 = value2;
        if (sign1.equals("+")) value1 = value1 + value2;
        if (sign1.equals("-")) value1 = value1 - value2;
        if (sign1.equals("÷")) value1 = value1 / value2;
        if (sign1.equals("×")) value1 = value1 * value2;

        valueOfResult.append(value1);
        if (b) valueOfProcess.append(value1).append(" ");

        value2 = 0;
        flag = true;
        sign1 = sign2;
    }

    public void addNum(String symbol) {
        if (valueOfResult.length() < 7) {
            if (valueOfResult.length() == 0) {
                valueOfProcess.append(symbol);
                if (flag) {
                    valueOfResult.delete(0, valueOfResult.length());
                    flag = false;
                }
            } else if (valueOfResult.charAt(0) != '0' || valueOfResult.charAt(0) == '0' && valueOfResult.charAt(1) == '.') {
                valueOfProcess.append(symbol);
                if (flag) {
                    valueOfResult.delete(0, valueOfResult.length());
                    flag = false;
                }
            }
            valueOfResult.append(symbol);
        }
    }

    public void addPoint() {
        if (valueOfResult.length() != 0) {
            if (!valueOfResult.toString().contains(".")) {
                valueOfProcess.append(".");
                if (flag) {
                    valueOfResult.delete(0, valueOfResult.length());
                    flag = false;
                }
                valueOfResult.append(".");
            }
        } else {
            valueOfProcess.append("0.");
            if (flag) {
                valueOfResult.delete(0, valueOfResult.length());
                flag = false;
            }
            valueOfResult.append("0.");
        }
    }

    public void clear() {
        valueOfProcess.delete(0, valueOfProcess.length());
        valueOfResult.delete(0, valueOfResult.length());
        value1 = value2 = 0;
        sign1 = sign2 = "";
        flag = false;
    }

    public void backspace() {
        if (valueOfResult.length() != 0) {
            valueOfProcess = valueOfProcess.deleteCharAt(valueOfProcess.length() - 1);
            valueOfResult = valueOfResult.deleteCharAt(valueOfResult.length() - 1);
        }
    }

    public void addEqual() {
        if (valueOfResult.length() != 0) {
            valueOfProcess.append("=");
            value2 = Double.parseDouble(valueOfResult.toString());
            valueOfResult.delete(0, valueOfResult.length());
            calcResult(true);
        }
        value1 = 0;
        sign1 = "";
    }

    public void addMainOperation(char symbol) {
        if (valueOfResult.length() != 0) {
            if (valueOfProcess.charAt(valueOfProcess.length() - 1) != symbol) {
                valueOfProcess.append(symbol);
                if (sign1.equals("")) sign1 = String.valueOf(symbol);
                else sign2 = String.valueOf(symbol);
            }
            if (value1 == 0) {
                value1 = Double.parseDouble(valueOfResult.toString());
                valueOfResult.delete(0, valueOfResult.length());
            } else if (value1 != 0 && value2 == 0) {
                value2 = Double.parseDouble(valueOfResult.toString());
                valueOfResult.delete(0, valueOfResult.length());
                calcResult(false);
            }
        }
    }

    public void addPlusMinus() {
        if (valueOfResult.length() != 0) {
            if (valueOfResult.charAt(0) != '-') {
                valueOfResult.insert(0, '-');
                valueOfProcess.insert(0, '-');
            } else if (valueOfResult.charAt(0) == '-') valueOfResult.deleteCharAt(0);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(value1);
        parcel.writeDouble(value2);
        parcel.writeString(sign1);
        parcel.writeString(sign2);
        parcel.writeByte((byte) (flag ? 1 : 0));
    }
}
