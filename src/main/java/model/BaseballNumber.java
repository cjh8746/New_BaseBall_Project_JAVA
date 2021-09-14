package model;

import java.util.Objects;
import java.util.regex.Pattern;

public class BaseballNumber {
    private static final String NUMBER_REGEX = "^[1-9]";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);
    private final int number;

    public BaseballNumber(String number) {
        isBlank(number);
        isNumber(number);
        this.number = Integer.parseInt(number);
    }

    private void isBlank(String number) {
        if (number.equals("")) {
            throw new IllegalArgumentException("아무 값도 입력되지 않았습니다.");
        }
    }

    private void isNumber(String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException("1~9에 있는 숫자가 아닙니다.");
        }
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "BaseballNumber " +
                " = " + number;
    }
}